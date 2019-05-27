package com.example.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.repository.Ex20Repository;
import com.example.service.UserSercvice;

@Controller
@RequestMapping("/marathon")
public class Marahon {

//	@RequestMapping("")
//	public String index() {
//		return "inputname";
//	}

//	@RequestMapping("")
//	public String index() {
//		return "inputname2";
//	}

//	@RequestMapping("")
//	public String index() {
//		return "inputname3";
//	}

//	@RequestMapping("")
//	public String index() {
//		return "inputname4";
//	}

	@RequestMapping("")
	public String index() {
		return "marathon20km";
	}

	@RequestMapping("/01")
	public String Exe01(String name, Model model) {

		model.addAttribute("name", name);

		return "ex01";
	}

	@RequestMapping("/02")
	public String Exe02(User user, Model model) {

		model.addAttribute("user", user);

		return "ex02";
	}

	@Autowired
	private HttpSession session;

	@RequestMapping("/03")
	public String Exe03(String num1, String num2) {
		int answer = Integer.parseInt(num1) * Integer.parseInt(num2);

		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("answer", answer);

		return "ex03";
	}

	@RequestMapping("/03-02")
	public String Exe03_02() {
		return "ex03_02";
	}

	@Autowired
	private ServletContext application;

	@RequestMapping("/04")
	public String Exe04(String goods1, String goods2, String goods3) {

		int answer = Integer.parseInt(goods1) + Integer.parseInt(goods2) + Integer.parseInt(goods3);
		int tax = (int) (answer * 1.08);

		application.setAttribute("answer", answer);
		application.setAttribute("tax", tax);

		return "ex04";
	}

	@Autowired
	private UserSercvice service;
	
	@RequestMapping("/20")
	public String ex20(String id, Model model) {
		User user = new User();

		user = service.load(Integer.parseInt(id));

		model.addAttribute("user", user);

		return "ex20";
	}

}
