package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.object.Output;
import com.example.demo.service.OutputService;

@Controller
public class CreateController {
  
  @GetMapping("/Create")
  public String getCreate(@ModelAttribute Output output) {
    return "Create";
  }
  
  @Autowired OutputService service;
  
  @PostMapping("/Create")
  public String PostRequest(@ModelAttribute Output  output) {
	service.Create(output);
    return "redirect:/Index"; 
  }
}