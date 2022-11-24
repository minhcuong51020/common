package com.hmc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtToken jwtToken;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(authorizationHeader == null || !authorizationHeader.startsWith(SecurityConstant.TOKEN_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = authorizationHeader.substring(SecurityConstant.TOKEN_PREFIX.length());
        String username = jwtToken.getSubject(token);
        if(jwtToken.isTokenValid(username, token)) {
            String userId = jwtToken.getUserIdFromToken(token);
            List<GrantedAuthority> authorities = jwtToken.getAuthorities(token);
            Authentication authentication = jwtToken.getAuthentication(username, authorities, request);
            UserAuthentication auth = new UserAuthentication(
                    authentication.getPrincipal(),
                    authentication.getCredentials(),
                    authorities,
                    userId,
                    false
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
        } else {
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(request, response);
    }
}
