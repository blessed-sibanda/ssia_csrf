package com.bsib.ssia_csrf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;

import com.bsib.ssia_csrf.security.CsrfTokenLogger;

@Configuration
public class ProjectConfig {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http)
      throws Exception {
    return http.addFilterAfter(new CsrfTokenLogger(), CsrfFilter.class)
        .authorizeRequests().anyRequest().permitAll()
        .and().build();

  }
}
