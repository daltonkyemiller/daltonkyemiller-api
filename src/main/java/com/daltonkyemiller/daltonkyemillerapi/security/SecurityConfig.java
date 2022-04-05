package com.daltonkyemiller.daltonkyemillerapi.security;

import com.daltonkyemiller.daltonkyemillerapi.auth.jwt.JwtConfig;
import com.daltonkyemiller.daltonkyemillerapi.auth.jwt.JwtTokenVerifier;
import com.daltonkyemiller.daltonkyemillerapi.auth.jwt.JwtUsernamePassAuthFilter;
import com.daltonkyemiller.daltonkyemillerapi.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder,
                          UserService userService,
                          JwtConfig jwtConfig,
                          SecretKey secretKey) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // TODO: Enable for production
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernamePassAuthFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(jwtConfig, secretKey), JwtUsernamePassAuthFilter.class)
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*", "/login").permitAll()
                .antMatchers( HttpMethod.GET, "/api/**/projects/**").permitAll()
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
}
