package com.dndn.sbase.sys.config;

import com.dndn.sbase.sys.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

public class SecurityConfig {

    @Autowired
    private AuthService authService;

    @Autowired
    public void configAuth(AuthenticationManagerBuilder auth) throws Exception {
//        System.out.println(" the encrypted passowrd bla bla: " + (new BCryptPasswordEncoder()).encode("admin"));
        auth
                .userDetailsService(authService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//                .and()
//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password("admin");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//    }
}
