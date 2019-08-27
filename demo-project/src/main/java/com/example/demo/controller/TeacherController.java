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
import com.example.demo.service.ElectiveService;
import com.example.demo.service.GradeService;
import com.example.demo.service.SchoolService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import com.table.pojo.ClassInfo;
import com.table.pojo.Course;
import com.table.pojo.Elective;
import com.table.pojo.Grade;
import com.table.pojo.School;
import com.table.pojo.Student;
import com.table.pojo.Teacher;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private CourseController courseController;

	@Autowired
	private ElectiveService electiveService;

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private GradeService gradeService;

	@Autowired
	private ClassService classService;

	// 查询
	@RequestMapping("/select")
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("teachername") String teachername) throws IOException {
		System.out.println("Get teacher name:" + teachername);
		// 查询
		List<Teacher> selectForTeacher = teacherService.selectForTeacher(teachername);
		ModelAndView modelAndView = new ModelAndView();
		// 把teachername放进modelAndView
		modelAndView.addObject("teachername", teachername);
		// 把selectForTeacher集合放进modelAndView
		modelAndView.addObject("teacherList", selectForTeacher);
		// jsp位置
		modelAndView.setViewName("courseteacher");
		// 展示在页面
		return modelAndView;
	}

	// 切换到插入页面
	@RequestMapping("/insert")
	public ModelAndView changeToInsert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("courseId") long courseId, @RequestParam("studentId") long studentId) throws Exception {
		System.out.println("Get student id:" + studentId);
		System.out.println("Get course id:" + courseId);
		// 查询当前id下的学生信息
		Student student = studentService.selectStudentById(studentId);
		// 查询当前id下的课程信息
		Course course = courseService.selectCourseById(courseId);
		// 创建modelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将这条学生信息存入modelAndView
		modelAndView.addObject("student", student);
		// 将这条课程信息存入modelAndView
		modelAndView.addObject("course", course);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("teacherinsert");
		return modelAndView;
	}

	// 插入页面
	@RequestMapping("/insertTeacher")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam("classId") long classId, @RequestParam("studentId") long studentId,
			@RequestParam("courseId") long courseId, @RequestParam("teachername") String teachername) throws Exception {
		System.out.println("Get insert school id : " + schoolId);
		System.out.println("Get insert grade id : " + gradeId);
		System.out.println("Get class id : " + classId);
		System.out.println("Get insert student id : " + studentId);
		System.out.println("Get insert course id : " + courseId);
		System.out.println("Get insert teacher name : " + teachername);
		// 插入一条课程信息
		teacherService.insertTeacher(teachername, courseId);
		// 返回维护页面
		return courseController.courseMaintain(request, response, courseId, schoolId, gradeId, classId, studentId);
	}

	// 切换到修改页面
	@RequestMapping("/update")
	public ModelAndView changeToUpdate(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long teacherId, @RequestParam("courseId") long courseId,
			@RequestParam("name") String teachername, @RequestParam("studentId") long studentId) throws Exception {
		System.out.println("Get update teacher id :" + teacherId);
		System.out.println("Get update course id :" + courseId);
		System.out.println("Get update student id :" + studentId);
		System.out.println("Get update teacher name :" + teachername);
		// 通过id查询这条学校信息
		Student student = studentService.selectStudentById(studentId);
		// 通过id查询这条课程信息
		Course course = courseService.selectCourseById(courseId);
		// 通过id查询这条教师信息
		Teacher teacher = teacherService.selectTeacherById(teacherId);
		ModelAndView modelAndView = new ModelAndView();
		// 将这条学生信息存入modelAndView对象中
		modelAndView.addObject("student", student);
		// 将这条课程信息存入modelAndView对象中
		modelAndView.addObject("course", course);
		// 将这条课程信息存入modelAndView对象中
		modelAndView.addObject("teacher", teacher);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("teacherupdate");
		return modelAndView;
	}

	// 更新
	@RequestMapping("/updateTeacher")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("courseId") Long courseId, @RequestParam("schoolId") Long schoolId,
			@RequestParam("gradeId") Long gradeId, @RequestParam("classId") Long classId,
			@RequestParam("teacherId") Long teacherId, @RequestParam("studentId") Long studentId,
			@RequestParam("teachername") String teachername) throws Exception {
		System.out.println("Get update student id : " + studentId);
		System.out.println("Get update student schoolId : " + schoolId);
		System.out.println("Get update student gradeId : " + gradeId);
		System.out.println("Get update student classId : " + classId);
		System.out.println("Get update course id : " + courseId);
		System.out.println("Get update teacher id : " + teacherId);
		System.out.println("Get teacher name : " + teachername);
		// 修改
		teacherService.update(teacherId, teachername, courseId);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("teacherupdate");
		return courseController.courseMaintain(request, response, courseId, schoolId, gradeId, classId, studentId);
	}

	// 删除
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long teacherId, @RequestParam("schoolId") long schoolId,
			@RequestParam("gradeId") long gradeId, @RequestParam("classId") long classId,
			@RequestParam("courseId") long courseId, @RequestParam("studentId") long studentId) throws Exception {
		System.out.println("Get delete course id :" + courseId);
		System.out.println("Get delete student id :" + studentId);
		System.out.println("Get delete school id :" + schoolId);
		System.out.println("Get delete grade id :" + gradeId);
		System.out.println("Get delete class id :" + classId);
		System.out.println("Get delete teacher id :" + teacherId);
		// 根据id删除这条教师信息
		teacherService.delete(teacherId);
		// 返回主页面
		return courseController.courseMaintain(request, response, courseId, schoolId, gradeId, classId, studentId);
	}

	// 维护
	@RequestMapping("/maintain")
	public ModelAndView courseMaintain(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam("classId") long classId, @RequestParam("id") long teacherId,
			@RequestParam("courseId") long courseId, @RequestParam("studentId") long studentId) throws Exception {
		System.out.println("Get school id :" + schoolId);
		System.out.println("Get grade id :" + gradeId);
		System.out.println("Get class id :" + classId);
		System.out.println("Get student id :" + studentId);
		System.out.println("Get course id :" + courseId);
		System.out.println("Get teacher id :" + teacherId);
		// 通过id查询这条学校信息
		School school = schoolService.selectSchoolById(schoolId);
		// 通过id查询这条年级信息
		Grade grade = gradeService.selectGradeById(gradeId);
		// 通过id查询这条班级信息
		ClassInfo classInfo = classService.selectClassById(classId);
		// 通过id查询这条课程信息
		Course course = courseService.selectCourseById(courseId);
		// 通过id查询这条学生信息
		Student student = studentService.selectStudentById(studentId);
		// 通过id查询教师信息
		Teacher teacher = teacherService.selectTeacherById(teacherId);
		// 查询所有选课信息
		List<Elective> selectAllElective = electiveService.selectAllElective();
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 把selectAllElective集合存入modelAndView
		modelAndView.addObject("teacherList", selectAllElective);
		// 把student对象存入modelAndView
		modelAndView.addObject("student", student);
		// 把school对象存入modelAndView
		modelAndView.addObject("school", school);
		// 把grade对象存入modelAndView
		modelAndView.addObject("grade", grade);
		// 把classInfo对象存入modelAndView
		modelAndView.addObject("classInfo", classInfo);
		// 把classInfo对象存入modelAndView
		modelAndView.addObject("course", course);
		// 把teacher对象存入modelAndView
		modelAndView.addObject("teacher", teacher);
		// jsp位置
		modelAndView.setViewName("teacherelective");
		return modelAndView;
	}

	// 详细信息查看
	@RequestMapping("/detailed")
	public ModelAndView teacherDetailed(HttpServletRequest request, HttpServletResponse response,
			 @RequestParam("id") long teacherId) throws IOException {
		System.out.println("Get teacher id :" + teacherId);
		// 通过id查询教师信息
		Teacher teacher = teacherService.selectTeacherById(teacherId);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将这条教师信息存入modelAndView对象中
		modelAndView.addObject("teacher", teacher);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("teacherInformation");
		return modelAndView;
	}
	
}
