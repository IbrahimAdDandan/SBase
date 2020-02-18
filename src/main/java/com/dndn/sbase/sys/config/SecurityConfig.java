package com.dndn.sbase.sys.config;

import com.dndn.sbase.sys.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

public class SecurityConfig {

    @Autowired
    private AuthService authService;

    @Autowired
    public void configAuth(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(authService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
