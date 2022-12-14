//package com.example.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService(){
//
//        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        User.UserBuilder userBuilder = User.builder().passwordEncoder(passwordEncoder ::encode);
//        UserDetails user1 = userBuilder
//                .username("Reem")
//                .password("Reem@")
//                .roles("ADMIN")
//                .build();
//        UserDetails user2 = userBuilder
//                .username("Reema")
//                .password("Reem@")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user1,user2);
//    }
//}
