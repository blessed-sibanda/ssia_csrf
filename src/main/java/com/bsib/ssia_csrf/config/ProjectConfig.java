package com.bsib.ssia_csrf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;

import com.bsib.ssia_csrf.security.CsrfTokenLogger;

@Configuration
public class ProjectConfig {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http)
      throws Exception {
    http.addFilterAfter(new CsrfTokenLogger(), CsrfFilter.class);
    http.authorizeRequests().anyRequest().authenticated();
    http.formLogin()
        .defaultSuccessUrl("/main", true);
    return http.build();
  }

  @Bean
  public UserDetailsService uds() {
    var uds = new InMemoryUserDetailsManager();
    var u1 = User.withUsername("blessed")
        .password(passwordEncoder().encode("1234pass"))
        .authorities("READ").build();
    uds.createUser(u1);
    return uds;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
