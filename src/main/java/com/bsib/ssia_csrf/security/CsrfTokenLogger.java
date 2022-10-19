package com.bsib.ssia_csrf.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.web.csrf.CsrfToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsrfTokenLogger implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    Object o = request.getAttribute("_csrf");
    CsrfToken token = (CsrfToken) o;
    log.info("CSRF token " + token.getToken());
    chain.doFilter(request, response);
  }

}
