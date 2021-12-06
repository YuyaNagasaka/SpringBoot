package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.object.Output;
import com.example.demo.service.OutputService;


@Controller
public class EditController {


	
@Autowired OutputService service;

@GetMapping("/Edit")
public String getEdit() {
  return "Edit";
}

@PostMapping(value = "/Edit",params = "delete")

public String Delete(@ModelAttribute Output output) {
	service.delete(output);
	 return "redirect:/Index";  
}

@PostMapping(value = "/Edit",params = "edit")

public String Update(@ModelAttribute Output output,Model model) {
	model.addAttribute("output", service.edit(output));
	return "Edit";  
}
}
