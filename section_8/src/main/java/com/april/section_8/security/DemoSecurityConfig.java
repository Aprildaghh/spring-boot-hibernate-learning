package com.april.section_8.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


   @Bean
   public UserDetailsManager userDetailsManager(DataSource dataSource)
   {

       JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

       userDetailsManager
               .setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");

       userDetailsManager
               .setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

       return userDetailsManager;

       // only for users - authorities tables
       // return new JdbcUserDetailsManager(dataSource);
   }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );

        return http.build();
    }

}
