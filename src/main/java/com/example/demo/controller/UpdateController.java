package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.object.Output;
import com.example.demo.service.OutputService;
@Controller
public class UpdateController {
	
	@Autowired OutputService service;
	 @PostMapping("/Update")
	  public String PostRequest(@ModelAttribute @Validated Output output,BindingResult bindingResult) {
		 if(bindingResult.hasErrors()){
				return "Edit";
			}
		service.update(output);
	    return "redirect:/Index"; 
	  }

}
