package com.dndn.sbase.sys.config;

import com.dndn.sbase.sys.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.dndn.sbase"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthService authService;

    @Autowired
    public void configAuth(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(authService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//                .and()
//                .inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
//                .and()
//                .withUser("ibra").password("{noop}ibra").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/**")
                .permitAll()
                .antMatchers(HttpMethod.POST,"/**")
                .permitAll()
                .antMatchers(HttpMethod.PUT,"/**")
                .permitAll()
                .antMatchers(HttpMethod.DELETE,"/**")
                .permitAll()
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

}
