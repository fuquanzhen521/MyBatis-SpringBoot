package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.GradeService;
import com.example.demo.service.SchoolService;
import com.table.pojo.Grade;
import com.table.pojo.School;

@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private GradeService gradeService;
	
	@PostConstruct
	public void init(){
		System.out.println("ClassController is init!");
	}

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws Exception {
		System.out.print(page);
		// 查询学校id和name
		List<School> list = schoolService.selectSchool(page);
		ModelAndView modelAndView = new ModelAndView();
		// 相当于把数据放到了request域中
		modelAndView.addObject("schoolList", list);
		// 把page存入modelAndView
		modelAndView.addObject("page", page);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("schList");
		// 展示在页面的是所有的学校信息
		return modelAndView;
	}

	// 切换到插入页面
	@RequestMapping("/insert")
	public ModelAndView changeToInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("schoolinsert");
		return modelAndView;
	}

	// 插入页面
	@RequestMapping("/insertSchool")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schname") String schname, @RequestParam("jbw") Boolean jbw, @RequestParam("eyy") Boolean eyy)
					throws Exception {
		System.out.println("Get insert school name : " + schname);
		System.out.println("Get insert school jbw : " + jbw);
		System.out.println("Get insert school eyy : " + eyy);
		// 创建school对象
		School school = new School(schname, jbw, eyy);
		// 插入一条学校信息
		schoolService.insertSchool(school);
		// 返回list方法 展示所有学校信息
		return this.list(request, response, 1);
	}

	// 查询
	@RequestMapping("/select")
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schname") String schname, @RequestParam(value = "jbw", required = false) Boolean jbw,
			@RequestParam(value = "eyy", required = false) Boolean eyy) throws Exception {
		System.out.println("Get select school name : " + schname);
		System.out.println("Get select school jbw : " + jbw);
		System.out.println("Get select school eyy : " + eyy);
		// 条件查询
		List<School> selectForSchool = schoolService.selectForSchool(schname, jbw, eyy);
		// 创建school对象
		School school = new School(schname, jbw, eyy);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 相当于把数据放到了request域中
		modelAndView.addObject("schoolList", selectForSchool);
		// 把school对象存入modelAndView
		modelAndView.addObject("school", school);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("schList");
		// 将根据条件查询的结果展示在页面上
		return modelAndView;
	}

	// 切换到修改页面
	@RequestMapping("/update")
	public ModelAndView changeToUpdate(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long schoolId) throws Exception {
		System.out.println("Get update school id :" + schoolId);
		// 通过id查询这条学校信息
		School school = schoolService.selectSchoolById(schoolId);
		ModelAndView modelAndView = new ModelAndView();
		// 将这条学校信息存入modelAndView对象中
		modelAndView.addObject("school", school);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("schoolupdate");
		return modelAndView;
	}

	// 更新
	@RequestMapping("/updateSchool")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("schname") String schname,
			@RequestParam("jbw") Boolean jbw, @RequestParam("eyy") Boolean eyy) throws Exception {
		System.out.println("Get update school id : " + schoolId);
		System.out.println("Get update school name : " + schname);
		System.out.println("Get update school jbw : " + jbw);
		System.out.println("Get update school eyy : " + eyy);
		// 修改
		schoolService.update(schoolId, schname, jbw, eyy);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("schoolupdate");
		// 返回所有的学校信息(也就是主页面)
		return this.list(request, response, 1);
	}

	// 删除
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long schoolId) throws Exception {
		System.out.println("Get delete school id :" + schoolId);
		// 根据id删除这条学校信息
		schoolService.delete(schoolId);
		// 返回主页面
		return this.list(request, response, 1);
	}

	// 维护
	@RequestMapping("/maintain")
	public ModelAndView schoolMainTain(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long schoolId,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws Exception {
		System.out.println("Get maintain school id :" + schoolId);
		System.out.println(page);
		// 通过id查询这条学校信息
		School school = schoolService.selectSchoolById(schoolId);
		// 查询grade表的id和name
		List<Grade> selectAllGrade = gradeService.selectGrade(page);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将这条学校信息存入modelAndView对象中
		modelAndView.addObject("school", school);
		// 将selectAllGrade存入modelAndView
		modelAndView.addObject("gradeList", selectAllGrade);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("schoolgrade");
		return modelAndView;
	}

	// 详细信息查看
	@RequestMapping("/detailed")
	public ModelAndView schoolDetailed(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long schoolId) throws IOException {
		System.out.println("Get school id :" + schoolId);
		// 通过id查询学校信息
		School school = schoolService.selectSchoolById(schoolId);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将这条学校信息存入modelAndView对象中
		modelAndView.addObject("school", school);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("schoolInformation");
		return modelAndView;
	}

}
