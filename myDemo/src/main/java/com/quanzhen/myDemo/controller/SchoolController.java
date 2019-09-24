package com.quanzhen.myDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.quanzhen.myDemo.pojo.School;
import com.quanzhen.myDemo.service.SchoolService;

@Controller
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	// 查询所有数据,返回json数据
	@RequestMapping("/test")
	@ResponseBody
	public List<School> list() {
		List<School> schoolList = schoolService.findAll();
		return schoolList;
	}

	@RequestMapping("/list")
	public String list(Model model) {
		// 查询
		List<School> schoolList = schoolService.findAll();
		//将schoolList存入model中
		model.addAttribute("list", schoolList);
		//返回jsp路径
		return "schList";
	}
	
	@RequestMapping("/list2")
	public ModelAndView list2() {
		// 查询
		List<School> schoolList = schoolService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", schoolList);
		modelAndView.setViewName("schList");
		return modelAndView;
	}

}
