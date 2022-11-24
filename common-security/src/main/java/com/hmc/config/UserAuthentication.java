package com.hmc.config;

import lombok.EqualsAndHashCode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@EqualsAndHashCode(callSuper = false)
public class UserAuthentication extends UsernamePasswordAuthenticationToken {

    private final String userId;

    private final boolean isRoot;

    public UserAuthentication(Object principal, Object credentials,
                              Collection<? extends GrantedAuthority> authorities,
                              String userId, boolean isRoot) {
        super(principal, credentials, authorities);
        this.userId = userId;
        this.isRoot = isRoot;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isAdmin() {
        return this.isRoot;
    }
}
