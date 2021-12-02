package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.object.User;
import com.example.demo.service.UserService;

@Controller
public class RegisterController {
  @Autowired UserService userService;
  
  @GetMapping("/Register")
  public String getRegister(@ModelAttribute User user) {
    return "Register";
  }
   
  @PostMapping("/Register")
  public String postRequest(@ModelAttribute User user) {
    userService.Insert(user);
    return "redirect:/Create";  
  }
}