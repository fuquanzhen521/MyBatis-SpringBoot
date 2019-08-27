package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.ClassService;
import com.example.demo.service.GradeService;
import com.example.demo.service.SchoolService;
import com.table.pojo.ClassInfo;
import com.table.pojo.Grade;
import com.table.pojo.School;

@Controller
@RequestMapping("/grade")
public class GradeController {

	@Autowired
	private GradeService gradeService;

	@Autowired
	private ClassService classService;

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private SchoolController schoolController;

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 查询grade表所有信息
		List<Grade> selectAllGrade = gradeService.selectAllGrade();
		// 创建modelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 相当于把数据放到了request域中
		modelAndView.addObject("gradeList", selectAllGrade);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("gradeList");
		// 将查询结果展示在页面
		return modelAndView;
	}

	// 查询
	@RequestMapping("/select")
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "gradename", required = false) String name) throws Exception {
		System.out.println("Get select grade name : " + name);
		// 条件查询
		List<Grade> selectForGrade = gradeService.selectForGrade(name);
		// 创建grade对象
		Grade grade = new Grade(name);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 相当于把数据放到了request域中
		modelAndView.addObject("gradeList", selectForGrade);
		// 将grade对象存入modelAndView
		modelAndView.addObject("grade", grade);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("schoolgrade");
		return modelAndView;
	}

	// 切换到插入页面
	@RequestMapping("/insert")
	public ModelAndView changeToInsert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId) throws Exception {
		// 通过id查询school
		School school = schoolService.selectSchoolById(schoolId);
		ModelAndView modelAndView = new ModelAndView();
		// 将school存入modelAndView
		modelAndView.addObject("school", school);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("gradeinsert");
		return modelAndView;
	}

	// 插入页面
	@RequestMapping("/insertGrade")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradename") String gradename) throws Exception {
		System.out.println("Get insert grade name : " + gradename);
		System.out.println("Get school id : " + schoolId);
		// 创建grade对象
		Grade grade = new Grade(gradename);
		// 插入一条学校信息
		gradeService.insertGrade(grade);
		// 返回list方法 展示所有学校信息
		return schoolController.schoolMainTain(request, response, schoolId,1);
	}

	// 切换到修改页面
	@RequestMapping("/update")
	public ModelAndView changeToUpdate(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("id") long gradeId) throws Exception {
		System.out.println("Get update grade id :" + gradeId);
		System.out.println("Get school id :" + schoolId);
		// 通过id查询这条年级信息
		Grade grade = gradeService.selectGradeById(gradeId);
		// 通过id查询这条学校信息
		School school = schoolService.selectSchoolById(schoolId);
		ModelAndView modelAndView = new ModelAndView();
		// 将这条年级信息存入modelAndView对象中
		modelAndView.addObject("grade", grade);
		// 将schoolId存入modelAndView
		modelAndView.addObject("school", school);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("gradeupdate");
		return modelAndView;
	}

	// 更新
	@RequestMapping("/updateGrade")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam("gradename") String gradename) throws Exception {
		System.out.println("Get update grade id : " + gradeId);
		System.out.println("Get update grade name : " + gradename);
		// 修改
		gradeService.update(gradeId, gradename);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("gradeupdate");
		// 返回所有的年级信息(也就是主页面)
		return schoolController.schoolMainTain(request, response, schoolId,1);
	}

	// 删除
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("id") long gradeId) throws Exception {
		System.out.println("Get delete grade id :" + gradeId);
		System.out.println("Get school id :" + schoolId);
		// 根据id删除这条年级信息
		gradeService.delete(gradeId);
		// 返回主页面
		return schoolController.schoolMainTain(request, response, schoolId,1);
	}

	// 维护
	@RequestMapping("/maintain")
	public ModelAndView gradeMainTain(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("id") long gradeId) throws Exception {
		System.out.println("Get grade id :" + gradeId);
		System.out.println("Get school id :" + schoolId);
		// 根据id查询这条年级信息
		Grade grade = gradeService.selectGradeById(gradeId);
		// 根据id查询这条学校信息
		School school = schoolService.selectSchoolById(schoolId);
		// 查询班级的id和name
		List<ClassInfo> selectAllClass = classService.selectClass();
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 把获得的年级存入modelAndView
		modelAndView.addObject("grade", grade);
		// 把获得的学校存入modelAndView
		modelAndView.addObject("school", school);
		// 将selectAllClass存入modelAndView
		modelAndView.addObject("classList", selectAllClass);
		// jsp位置
		modelAndView.setViewName("gradeclass");
		return modelAndView;
	}

	// 详细信息查看
	@RequestMapping("/detailed")
	public ModelAndView gradeDetailed(HttpServletRequest request, HttpServletResponse response,
			 @RequestParam("id") long gradeId) throws IOException {
		System.out.println("Get grade id :" + gradeId);
		// 通过id查询年级信息
		Grade grade = gradeService.selectGradeById(gradeId);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将这条年级信息存入modelAndView对象中
		modelAndView.addObject("grade", grade);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("gradeInformation");
		return modelAndView;
	}

}
