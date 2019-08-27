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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.ClassService;
import com.example.demo.service.GradeService;
import com.example.demo.service.SchoolService;
import com.example.demo.service.StudentService;
import com.table.pojo.ClassInfo;
import com.table.pojo.Grade;
import com.table.pojo.School;
import com.table.pojo.Student;



@Controller
@RequestMapping("/class")
public class ClassController {

	@Autowired
	private ClassService classService;

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private GradeService gradeService;

	@Autowired
	private GradeController gradeController;

	@Autowired
	private StudentService studentService;

	@PostConstruct
	public void init(){
		System.out.println("ClassController is init!");
	}
	
	// 查询所有的班级信息
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 查询
		List<ClassInfo> selectAllClass = classService.selectAllClass();
		// 创建modelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 相当于把数据放到了request域中
		modelAndView.addObject("classList", selectAllClass);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("classList");
		return modelAndView;
	}

	// 查询
	@RequestMapping("/select")
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam(value = "classname", required = false) String classname) throws Exception {
		System.out.println("Get select class name : " + classname);
		System.out.println("Get school id : " + schoolId);
		System.out.println("Get grade id : " + gradeId);
		// 查询
		List<ClassInfo> selectForClass = classService.selectForClass(classname);
		// 通过id查询学校
		School school = schoolService.selectSchoolById(schoolId);
		// 通过id查询年级
		Grade grade = gradeService.selectGradeById(gradeId);
		// 创建一个class对象
		ClassInfo classInfo = new ClassInfo();
		classInfo.setName(classname);
		// 创建modelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 把school放入modelAndView
		modelAndView.addObject("school", school);
		// 把grade放入modelAndView
		modelAndView.addObject("grade", grade);
		// 相当于把数据放到了request域中
		modelAndView.addObject("classList", selectForClass);
		// 把classname存入modelAndView
		modelAndView.addObject("classInfo", classInfo);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("gradeclass");
		return modelAndView;
	}

	// 切换到插入页面
	@RequestMapping("/insert")
	public ModelAndView changeToInsert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId) throws Exception {
		// 查询当前id下的学校信息
		School school = schoolService.selectSchoolById(schoolId);
		// 查询当前id下的年级信息
		Grade grade = gradeService.selectGradeById(gradeId);
		ModelAndView modelAndView = new ModelAndView();
		// 将这条学校信息存入modelAndView
		modelAndView.addObject("school", school);
		// 将这条年级信息存入modelAndView
		modelAndView.addObject("grade", grade);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("classinsert");
		return modelAndView;
	}

	// 插入页面
	@RequestMapping("/insertClass")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("classname") String classname, @RequestParam("schoolid") long schoolid,
			@RequestParam("gradeid") long gradeid) throws Exception {
		System.out.println("Get insert class classname : " + classname);
		System.out.println("Get insert class schoolid : " + schoolid);
		System.out.println("Get insert class gradeid : " + gradeid);
		// 创建class对象
		ClassInfo classInfo = new ClassInfo(classname, schoolid, gradeid);
		// 插入一条学校信息
		classService.insertClass(classInfo);
		// 返回list方法 展示所有学校信息
		return gradeController.gradeMainTain(request, response, schoolid, gradeid);
	}

	// 切换到修改页面
	@RequestMapping("/update")
	public ModelAndView changeToUpdate(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam("id") long classId) throws Exception {
		System.out.println("Get update class id :" + classId);
		System.out.println("Get school id :" + schoolId);
		System.out.println("Get grade id :" + classId);
		// 通过id查询这条班级信息
		ClassInfo classInfo = classService.selectClassById(classId);
		// 通过id查询这条学校信息
		School school = schoolService.selectSchoolById(schoolId);
		// 通过id查询这条年级信息
		Grade grade = gradeService.selectGradeById(gradeId);
		ModelAndView modelAndView = new ModelAndView();
		// 将这条班级信息存入modelAndView对象中
		modelAndView.addObject("classInfo", classInfo);
		// 将这条学校信息存入modelAndView对象中
		modelAndView.addObject("school", school);
		// 将这条年级信息存入modelAndView对象中
		modelAndView.addObject("grade", grade);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("classupdate");
		return modelAndView;
	}

	// 更新
	@RequestMapping("/updateClass")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam("classId") long classId, @RequestParam("classname") String classname,
			@RequestParam("sch_id") long sch_id, @RequestParam("gra_id") long gra_id) throws Exception {
		System.out.println("Get update class classId : " + classId);
		System.out.println("Get update class classname : " + classname);
		System.out.println("Get update class sch_id : " + sch_id);
		System.out.println("Get update class gra_id : " + gra_id);
		System.out.println("Get school id : " + schoolId);
		System.out.println("Get grade id : " + gradeId);
		// 修改
		classService.update(classId, classname, sch_id, gra_id);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("classupdate");
		return gradeController.gradeMainTain(request, response, schoolId, gradeId);
	}

	// 删除
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam("id") long classId) throws Exception {
		System.out.println("Get delete class id :" + classId);
		// 根据id删除这条班级信息
		classService.delete(classId);
		// 返回主页面
		return gradeController.gradeMainTain(request, response, schoolId, gradeId);
	}

	// 维护
	@RequestMapping("/maintain")
	public ModelAndView classMaintain(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam("id") long classId) throws Exception {
		System.out.println("Get class id :" + classId);
		System.out.println("Get school id :" + schoolId);
		System.out.println("Get grade id :" + gradeId);
		// 通过id查询这条学校信息
		School school = schoolService.selectSchoolById(schoolId);
		// 通过id查询这条班级信息
		ClassInfo classInfo = classService.selectClassById(classId);
		// 通过id查询这条年级信息
		Grade grade = gradeService.selectGradeById(gradeId);
		// 查询所有学生信息
		List<Student> selectAllStudent = studentService.selectAllStudent();
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 把school对象存入modelAndView
		modelAndView.addObject("school", school);
		// 把classInfo对象存入modelAndView
		modelAndView.addObject("classInfo", classInfo);
		// 把grade对象存入modelAndView
		modelAndView.addObject("grade", grade);
		// 把查询的学生集合存入modelAndView
		modelAndView.addObject("studentList", selectAllStudent);
		// jsp位置
		modelAndView.setViewName("classstudent");
		return modelAndView;
	}

	// 详细信息查看
	@RequestMapping("/detailed")
	public ModelAndView gradeDetailed(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam("id") long classId) throws IOException {
		System.out.println("Get class id :" + classId);
		// 通过id查询学校信息
		School school = schoolService.selectSchoolById(schoolId);
		// 通过id查询年级信息
		Grade grade = gradeService.selectGradeById(gradeId);
		// 通过id查询班级信息
		ClassInfo classInfo = classService.selectClassById(classId);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将这条学校信息存入modelAndView对象中
		modelAndView.addObject("school", school);
		// 将这条年级信息存入modelAndView对象中
		modelAndView.addObject("grade", grade);
		// 将这条班级信息存入modelAndView对象中
		modelAndView.addObject("classInfo", classInfo);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("classInformation");
		return modelAndView;
	}

}
