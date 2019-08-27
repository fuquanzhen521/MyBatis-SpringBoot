package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeConrroller {
	@RequestMapping("/page")
	public ModelAndView homepage(HttpServletRequest request, HttpServletResponse response) {
		// 创建modelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("home");
		return modelAndView;
	}
}
