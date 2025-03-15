//package com.sri.petstore.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(authz -> authz  // Use 'authorizeHttpRequests'
//                .requestMatchers("/api/pets").permitAll()  // Public access to GET /api/pets
//                .anyRequest().authenticated())  // Everything else needs authentication
//            .httpBasic(Customizer.withDefaults());  // Use httpBasic with Customizer
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            if ("admin".equals(username)) {
//                return User.withUsername("admin")
//                           .password("{noop}admin123")  // Plain-text password (noop for testing)
//                           .roles("USER")
//                           .build();
//            } else {
//                throw new UsernameNotFoundException("User  not found: " + username);
//            }
//        };
//    }
//}