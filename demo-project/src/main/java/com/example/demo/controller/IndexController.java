package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	// @Autowired
	// private SchoolService schoolService;

	@RequestMapping("/")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("home");
		return modelAndView;
	}

}
