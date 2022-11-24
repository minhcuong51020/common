package com.hmc.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Objects;
import java.util.Optional;

public final class SecurityUtils {

    private SecurityUtils() {

    }

    public static Optional<String> getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(extractPrincipal(securityContext.getAuthentication()));
    }

    private static String extractPrincipal(Authentication authentication) {
        if (authentication == null) {
            return null;
        } else if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
            return springSecurityUser.getUsername();
        } else if (authentication.getPrincipal() instanceof String) {
            return (String) authentication.getPrincipal();
        }
        return null;
    }

    public static Optional<String> getCurrentUserLoginId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (Objects.nonNull(authentication) && authentication instanceof UserAuthentication) {
            UserAuthentication userAuthentication = (UserAuthentication) authentication;
            if (Objects.nonNull(userAuthentication.getUserId())) {
                return Optional.of(userAuthentication.getUserId());
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

}
