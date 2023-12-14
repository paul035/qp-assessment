package com.questionpro.GroceryService.utils;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
            .authorizeHttpRequests((authz) -> authz
            	.requestMatchers("/api/user/**").hasRole("USER")
            	.requestMatchers("/api/admin/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                
            )
            .httpBasic();
        return http.build();
    }
	
	
	@Bean
	public UserDetailsService users() {
		UserBuilder users = User.withDefaultPasswordEncoder();
		UserDetails user = users
			.username("user")
			.password("user@123")
			.roles("USER")
			.build();
		UserDetails admin = users
			.username("admin")
			.password("admin@123")
			.roles("ADMIN")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
}
