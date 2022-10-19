package com.bsib.ssia_csrf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/product")
public class ProductController {
  @PostMapping("/add")
  public String add(@RequestParam String name) {
    log.info("Adding product " + name);
    return "main";
  }
}
