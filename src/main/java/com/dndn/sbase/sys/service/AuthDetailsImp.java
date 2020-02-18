package com.dndn.sbase.sys.service;

import com.dndn.sbase.sys.domain.Privilege;
import com.dndn.sbase.sys.domain.Role;
import com.dndn.sbase.sys.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.HashSet;

public class AuthDetailsImp implements UserDetails {


    private User user;

    public AuthDetailsImp() {
    }

    public AuthDetailsImp(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        for (Role role: this.user.getRoles()) {
            for (Privilege privilege : role.getPrivileges()) {
                authorities.add(new SimpleGrantedAuthority(privilege.getName()));
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.isEnabled();
    }
}
