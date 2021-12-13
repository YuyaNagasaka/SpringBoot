package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.object.User;

@Controller
public class LoginController {
  
  @GetMapping("/Login")
  public String getLogin(@ModelAttribute User user) {
    return "Login";
  }
  
}