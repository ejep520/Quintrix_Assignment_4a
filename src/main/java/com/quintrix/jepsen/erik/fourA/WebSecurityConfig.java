package com.quintrix.jepsen.erik.fourA;

import java.util.HashSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests((requests) -> requests.antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated())
        .formLogin((form) -> form.loginPage("/login").permitAll())
        .logout((logout) -> logout.permitAll()).build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    HashSet<GrantedAuthority> authorities = new HashSet<>();
    authorities.add(new SimpleGrantedAuthority("USER"));
    return new InMemoryUserDetailsManager(new User("user",
        PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password"),
        authorities));
  }
}
