package com.springboot.quipux.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception { http
	 * 
	 * .authorizeHttpRequests((authz) -> authz .anyRequest().authenticated() )
	 * .httpBasic(); http.csrf().disable();
	 * 
	 * return http.build(); }
	 */
	
	@Bean
    public SecurityFilterChain filterChainUser(HttpSecurity http) throws Exception {
        http
        	
          .authorizeHttpRequests()
          .antMatchers("/lists/**").hasRole("User");
        http.httpBasic();
        http.csrf().disable();
       
        return http.build();
    }
	
	@Autowired
	protected void registerAuthentication(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder
            .inMemoryAuthentication()
                .withUser("user").password("{noop}"+"user").roles("User");
    }


}
