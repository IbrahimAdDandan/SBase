package com.dndn.sbase.sys.helper;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorityHelper {

    public static boolean hasAuthority(UserDetails user, String privilege) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.addAll(user.getAuthorities());
        GrantedAuthority authority = new SimpleGrantedAuthority(privilege);
        return authorities.contains(authority);
    }

    public static boolean hasAuthority(List<GrantedAuthority> authorities, String privilege) {

        GrantedAuthority authority = new SimpleGrantedAuthority(privilege);
        return authorities.contains(authority);
    }

}
