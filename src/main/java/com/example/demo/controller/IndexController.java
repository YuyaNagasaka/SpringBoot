package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.object.Output;
import com.example.demo.service.OutputService;

@Controller
public class IndexController {
  @Autowired OutputService service;
  @GetMapping("/Index")
  public String getIndex(Model model) {
	List<Output> outputIndex =  service.Index();
	model.addAttribute("outputIndex",outputIndex);
    return "Index";
  }
  
}