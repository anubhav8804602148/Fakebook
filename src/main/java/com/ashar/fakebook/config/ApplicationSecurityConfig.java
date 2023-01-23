package com.ashar.fakebook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ashar.fakebook.entities.CustomUserDetails;
import com.ashar.fakebook.entities.User;
import com.ashar.fakebook.serviceImpl.CustomUserServiceImplementation;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/resources/**");
    }
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
    	security.cors().disable();
    	security.requiresChannel().anyRequest().requiresSecure();
    	security.authorizeHttpRequests(req -> {
    		req.requestMatchers("/login").permitAll();
    		req.requestMatchers("/loginFailure").permitAll();
    		req.requestMatchers("/loginSuccess").permitAll();
    		req.requestMatchers("/loginProcess").permitAll();
    		req.requestMatchers("/register").permitAll();
    		req.requestMatchers("/registerSuccess").permitAll();
    		req.requestMatchers("/registerFailure").permitAll();
    		req.requestMatchers("/registerProcess").permitAll();
    		req.requestMatchers("/forgotPassword").permitAll();
    		req.requestMatchers("/error").permitAll();
    	})
    	.formLogin()
    		.loginPage("/login")
    		.loginProcessingUrl("/loginProcess")
    		.failureUrl("/loginFailure")
    	.and()
    	.logout()
    		.logoutUrl("/logout")
    		.logoutSuccessUrl("/login");
    	return security.build();
    }
    
    @Bean
    UserDetailsService userDetailsService() {
    	return new CustomUserServiceImplementation();
    }
    
    @Bean
    DaoAuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    	authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
    	authenticationProvider.setUserDetailsService(userDetailsService());
    	return authenticationProvider;
    }
}
