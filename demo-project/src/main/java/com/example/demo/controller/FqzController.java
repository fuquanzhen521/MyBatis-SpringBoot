package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class FqzController {
	
	@RequestMapping("/init")
	public @ResponseBody String index(){
		return " index Success";
	}
}
