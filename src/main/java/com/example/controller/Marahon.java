package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/marathon")
public class Marahon {

	
	@RequestMapping("")
	public String index() {
		return "inputname";
	}
	
	@RequestMapping("/01")
	public String Exe01(String name,Model model) {
		
		model.addAttribute("name",name);
		
		return "ex01";
	}
}
