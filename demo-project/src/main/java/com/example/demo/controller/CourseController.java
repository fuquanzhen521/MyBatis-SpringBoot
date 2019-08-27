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
import com.example.demo.service.CourseService;
import com.example.demo.service.GradeService;
import com.example.demo.service.SchoolService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import com.table.pojo.ClassInfo;
import com.table.pojo.Course;
import com.table.pojo.Grade;
import com.table.pojo.School;
import com.table.pojo.Student;
import com.table.pojo.Teacher;


@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentController studentController;

	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private GradeService gradeService;

	@Autowired
	private ClassService classService;

	@Autowired
	private SchoolService schoolService;

	// 维护
	@RequestMapping("/home")
	public ModelAndView studentMaintain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 查询所有课程信息
		List<Course> selectAllCourse = courseService.selectAllCourse();
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 把selectAllCourse集合存入modelAndView
		modelAndView.addObject("courseList", selectAllCourse);
		// 把student对象存入modelAndView
		// jsp位置
		modelAndView.setViewName("courseList");
		return modelAndView;
	}

	// 查询
	@RequestMapping("/select")
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("courseName") String courseName) throws IOException {
		System.out.println("Get course name:" + courseName);
		// 查询
		List<Course> selectForCourse = courseService.selectForCourse(courseName);
		/*// 创建course对象
		Course course = new Course();
		// 把名字存入course
		course.setName(courseName);*/
		ModelAndView modelAndView = new ModelAndView();
		// 把courseName放进modelAndView
		modelAndView.addObject("courseName", courseName);
		// 把courseList集合放进modelAndView
		modelAndView.addObject("courseList", selectForCourse);
		// jsp位置
		modelAndView.setViewName("courseList");
		// 展示在页面
		return modelAndView;
	}

	// 切换到插入页面
	@RequestMapping("/insert")
	public ModelAndView changeToInsert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("studentId") long studentId) throws Exception {
		System.out.println("Get student id:" + studentId);
		// 查询当前id下的学生信息
		Student student = studentService.selectStudentById(studentId);
		// 创建modelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将这条学生信息存入modelAndView
		modelAndView.addObject("student", student);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("courseinsert");
		return modelAndView;
	}

	// 插入页面
	@RequestMapping("/insertCourse")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam("classId") long classId, @RequestParam("studentId") long studentId,
			@RequestParam("courseName") String courseName) throws Exception {
		System.out.println("Get insert student schoolId : " + schoolId);
		System.out.println("Get insert student gradeId : " + gradeId);
		System.out.println("Get insert student classId : " + classId);
		System.out.println("Get insert student studentId : " + studentId);
		System.out.println("Get insert course name : " + courseName);
		// 插入一条课程信息
		courseService.insertCourse(courseName);
		// 返回list方法 展示所有学校信息
		return studentController.studentMaintain(request, response, studentId, schoolId, gradeId, classId);
	}

	// 切换到修改页面
	@RequestMapping("/update")
	public ModelAndView changeToUpdate(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long courseId, @RequestParam("name") String courseName,
			@RequestParam("studentId") long studentId) throws Exception {
		System.out.println("Get update course id :" + courseId);
		System.out.println("Get update student id :" + studentId);
		System.out.println("Get update course name :" + courseName);
		// 通过id查询这条学校信息
		Student student = studentService.selectStudentById(studentId);
		// 通过id查询这条课程信息
		Course course = courseService.selectCourseById(courseId);
		ModelAndView modelAndView = new ModelAndView();
		// 将这条学生信息存入modelAndView对象中
		modelAndView.addObject("student", student);
		// 将这条课程信息存入modelAndView对象中
		modelAndView.addObject("course", course);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("courseupdate");
		return modelAndView;
	}

	// 更新
	@RequestMapping("/updateCourse")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("courseId") long courseId, @RequestParam("schoolId") long schoolId,
			@RequestParam("gradeId") long gradeId, @RequestParam("classId") long classId,
			@RequestParam("studentId") long studentId, @RequestParam("courseName") String courseName) throws Exception {
		System.out.println("Get update student id : " + studentId);
		System.out.println("Get update student schoolId : " + schoolId);
		System.out.println("Get update student gradeId : " + gradeId);
		System.out.println("Get update student classId : " + classId);
		System.out.println("Get update course id : " + courseId);
		System.out.println("Get course name : " + courseName);
		// 修改
		courseService.updateCourse(courseId, courseName);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("courseupdate");
		return studentController.studentMaintain(request, response, studentId, schoolId, gradeId, classId);
	}

	// 删除
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long courseId, @RequestParam("schoolId") long schoolId,
			@RequestParam("gradeId") long gradeId, @RequestParam("classId") long classId,
			@RequestParam("studentId") long studentId) throws Exception {
		System.out.println("Get delete course id :" + courseId);
		System.out.println("Get delete Student id :" + studentId);
		// 根据id删除这条课程信息
		courseService.deleteCourse(courseId);
		// 返回主页面
		return studentController.studentMaintain(request, response, studentId, schoolId, gradeId, classId);
	}

	// 维护
	@RequestMapping("/maintain")
	public ModelAndView courseMaintain(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long courseId, @RequestParam("schoolId") long schoolId,
			@RequestParam("gradeId") long gradeId, @RequestParam("classId") long classId,
			@RequestParam("studentId") long studentId) throws Exception {
		System.out.println("Get course id :" + courseId);
		System.out.println("Get school id :" + schoolId);
		System.out.println("Get grade id :" + gradeId);
		System.out.println("Get class id :" + classId);
		System.out.println("Get student id :" + studentId);
		// 通过id查询这条学生信息
		Student student = studentService.selectStudentById(studentId);
		// 通过id查询课程信息
		Course course = courseService.selectCourseById(courseId);
		// 通过id查询学校信息
		School school = schoolService.selectSchoolById(schoolId);
		// 通过id查询年级信息
		Grade grade = gradeService.selectGradeById(gradeId);
		// 通过id查询班级信息
		ClassInfo classInfo = classService.selectClassById(classId);
		// 查询所有教师信息
		List<Teacher> selectAllTeacher = teacherService.selectAllTeacher();
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 把selectAllTeacher集合存入modelAndView
		modelAndView.addObject("teacherList", selectAllTeacher);
		// 把student对象存入modelAndView
		modelAndView.addObject("student", student);
		// 把school对象存入modelAndView
		modelAndView.addObject("school", school);
		// 把grade对象存入modelAndView
		modelAndView.addObject("grade", grade);
		// 把classInfo对象存入modelAndView
		modelAndView.addObject("classInfo", classInfo);
		// 把course对象存入modelAndView
		modelAndView.addObject("course", course);
		// jsp位置
		modelAndView.setViewName("courseteacher");
		return modelAndView;
	}

	// 详细信息查看
	@RequestMapping("/detailed")
	public ModelAndView courseDetailed(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long courseId) throws IOException {
		System.out.println("Get course id :" + courseId);
		// 通过id查询课程信息
		Course course = courseService.selectCourseById(courseId);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将这条课程信息存入modelAndView对象中
		modelAndView.addObject("course", course);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("courseInformation");
		return modelAndView;
	}

}
