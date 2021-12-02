package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.object.Output;

@Controller
public class CreateController {
  
  @GetMapping("/Create")
  public String getCreate(@ModelAttribute Output output) {
    return "Create";
  }
  @PostMapping("/Create")
  public String PostRequest(@ModelAttribute Output  output) {
    return "redirect:/Index"; 
  }
}