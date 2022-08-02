package com.aplos.josipdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserControlller {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/login")
	public ModelAndView loginForm(@RequestParam String password, @RequestParam String userName,
			@RequestParam String url) {
		ModelAndView mv = new ModelAndView("redirect:" + url);
		return mv;
	}
}