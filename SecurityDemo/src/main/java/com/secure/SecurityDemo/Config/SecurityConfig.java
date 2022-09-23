package com.secure.SecurityDemo.Config;

import com.secure.SecurityDemo.Entity.MyUserDetails;
import com.secure.SecurityDemo.Entity.User;
import com.secure.SecurityDemo.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    MyUserDetailsService myUserDetailsService;


    @Bean
    public UserDetailsService userDetailsManager() throws Exception {
        //First User
//        User u = new User();
//        u.setUserName("Bob");
//        u.setPassword("boss");
//        u.setRoles("ROLE_USER,ROLE_ADMIN");
//        u.setActive(true);
//        myUserDetailsService.addUser(u);

        List<UserDetails> userDetails = new ArrayList<>();
        for (User user: myUserDetailsService.findAllUsers()){
            userDetails.add(new MyUserDetails(user));
        }
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(auth ->{
                    auth.antMatchers("/user").hasRole("USER");
                    auth.antMatchers("/admin").hasRole("ADMIN");
                })
                .httpBasic()
                .and()
                .logout(LogoutConfigurer::permitAll)
                .build();
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return myUserDetailsService.getEncoder();
    }

    
}
