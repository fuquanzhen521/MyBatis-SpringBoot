package com.example.demo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.table.pojo.ClassInfo;
import com.table.pojo.Course;
import com.table.pojo.Elective;
import com.table.pojo.ElectiveCourse;
import com.table.pojo.Grade;
import com.table.pojo.School;
import com.table.pojo.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private GradeService gradeService;

	@Autowired
	private ClassService classService;

	@Autowired
	private ClassController classController;

	@Autowired
	private CourseService courseService;

	@Autowired
	private ElectiveService electiveService;

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 查询
		List<Student> selectAllStudent = studentService.selectAllStudent();
		ModelAndView modelAndView = new ModelAndView();
		// 相当于把数据放到了request域中
		modelAndView.addObject("stuList", selectAllStudent);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("studentList");
		return modelAndView;
	}

	// 查询
	@RequestMapping("/select")
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam("classId") long classId,
			@RequestParam(value = "studentName", required = false) String studentName,
			@RequestParam(value = "sex", required = false) Byte sex) throws IOException {
		System.out.println("Get student schoolId:" + schoolId);
		System.out.println("Get student gradeId:" + gradeId);
		System.out.println("Get student classId:" + classId);
		System.out.println("Get student sex:" + sex);
		System.out.println("Get student name:" + studentName);
		// 条件查询
		List<Student> selectForStudent = studentService.selectForStudent(studentName, sex);
		// 通过id查询school
		School school = schoolService.selectSchoolById(schoolId);
		// 通过id查询grade
		Grade grade = gradeService.selectGradeById(gradeId);
		// 通过id查询classInfo
		ClassInfo classInfo = classService.selectClassById(classId);
		// 创建student对象
		Student student = new Student();
		// 把studentName和sex放进去
		student.setName(studentName);
		student.setSex(sex);
		ModelAndView modelAndView = new ModelAndView();
		// 把school存入modelAndView
		modelAndView.addObject("school", school);
		// 把grade存入modelAndView
		modelAndView.addObject("grade", grade);
		// 把classInfo存入modelAndView
		modelAndView.addObject("classInfo", classInfo);
		// 把student放进modelAndView
		modelAndView.addObject("student", student);
		// 把studentList集合放进modelAndView
		modelAndView.addObject("studentList", selectForStudent);
		// jsp位置
		modelAndView.setViewName("classstudent");
		// 展示在页面
		return modelAndView;
	}

	// 切换到插入页面
	@RequestMapping("/insert")
	public ModelAndView changeToInsert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("classId") long classId, @RequestParam("schoolId") long schoolId,
			@RequestParam("gradeId") long gradeId) throws Exception {
		// 查询当前id下的学校信息
		School school = schoolService.selectSchoolById(schoolId);
		// 查询当前id下的年级信息
		Grade grade = gradeService.selectGradeById(gradeId);
		// 查询当前id下的班级信息
		ClassInfo classInfo = classService.selectClassById(classId);
		// 创建modelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将这条学校信息存入modelAndView
		modelAndView.addObject("school", school);
		// 将这条年级信息存入modelAndView
		modelAndView.addObject("grade", grade);
		// 将这条班级信息存入modelAndView
		modelAndView.addObject("classInfo", classInfo);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("studentInsert");
		return modelAndView;
	}

	// 插入页面
	@RequestMapping("/insertStudent")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("studentname") String studentname,
			@RequestParam("birthday") @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm") Date birthday,
			@RequestParam("sex") Byte sex, @RequestParam("schoolid") long schoolid,
			@RequestParam("gradeid") long gradeid, @RequestParam("classid") long classid) throws Exception {
		System.out.println("Get insert student name : " + studentname);
		System.out.println("Get insert student birthday : " + birthday);
		System.out.println("Get insert student sex : " + sex);
		System.out.println("Get insert student schoolid : " + schoolid);
		System.out.println("Get insert student gradeid : " + gradeid);
		System.out.println("Get insert student classid : " + classid);
		java.sql.Date sd = new java.sql.Date(birthday.getTime());
		// 创建student对象
		Student student = new Student(studentname, sd, sex, schoolid, gradeid, classid);
		// 插入一条学校信息
		studentService.insertStudent(student);
		// 返回list方法 展示所有学校信息
		return classController.classMaintain(request, response, schoolid, gradeid, classid);
	}

	// 切换到修改页面
	@RequestMapping("/update")
	public ModelAndView changeToUpdate(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long studentId, @RequestParam("schoolId") long schoolId,
			@RequestParam("gradeId") long gradeId, @RequestParam("classId") long classId) throws Exception {
		System.out.println("Get update student id :" + studentId);
		System.out.println("Get update student schoolId :" + schoolId);
		System.out.println("Get update student gradeId :" + gradeId);
		System.out.println("Get update student classId :" + classId);
		// 通过id查询这条班级信息
		ClassInfo classInfo = classService.selectClassById(classId);
		// 通过id查询这条学校信息
		School school = schoolService.selectSchoolById(schoolId);
		// 通过id查询这条年级信息
		Grade grade = gradeService.selectGradeById(gradeId);
		// 通过id查询学生信息
		Student student = studentService.selectStudentById(studentId);
		// 获取出生日期
		java.sql.Date birthday = student.getBirthday();
		// Date转成String类型
		String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(birthday);
		ModelAndView modelAndView = new ModelAndView();
		// 将这条班级信息存入modelAndView对象中
		modelAndView.addObject("classInfo", classInfo);
		// 将这条学校信息存入modelAndView对象中
		modelAndView.addObject("school", school);
		// 将这条年级信息存入modelAndView对象中
		modelAndView.addObject("grade", grade);
		// 把学生存入modelAndView
		modelAndView.addObject("student", student);
		// 把出生日期存入modelAndView
		modelAndView.addObject("birth", dateStr);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("studentupdate");
		return modelAndView;
	}

	// 更新
	@RequestMapping("/updateStudent")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") long id,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam("classId") long classId, @RequestParam("studentName") String studentName,
			@RequestParam("birthday") @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm") Date birthday,
			@RequestParam("sex") Byte sex) throws Exception {
		System.out.println("Get update student id : " + id);
		System.out.println("Get update student schoolId : " + schoolId);
		System.out.println("Get update student gradeId : " + gradeId);
		System.out.println("Get update student classId : " + classId);
		System.out.println("Get update student studentName : " + studentName);
		System.out.println("Get student birthday : " + birthday);
		System.out.println("Get student sex : " + sex);
		java.sql.Date sd = new java.sql.Date(birthday.getTime());
		// 修改
		studentService.update(id, studentName, sd, sex, schoolId, gradeId, classId);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("studentupdate");
		return classController.classMaintain(request, response, schoolId, gradeId, classId);
	}

	// 删除
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") long id,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam("classId") long classId) throws Exception {
		System.out.println("Get delete Student id :" + id);
		System.out.println("Get delete Student schoolId :" + schoolId);
		System.out.println("Get delete Student gradeId :" + gradeId);
		System.out.println("Get delete Student classId :" + classId);
		// 根据id删除这条学生信息
		studentService.delete(id);
		// 返回主页面
		return classController.classMaintain(request, response, schoolId, gradeId, classId);
	}

	// 维护
	@RequestMapping("/maintain")
	public ModelAndView studentMaintain(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long studentId, @RequestParam("schoolId") long schoolId,
			@RequestParam("gradeId") long gradeId, @RequestParam("classId") long classId) throws Exception {
		System.out.println("Get student id :" + studentId);
		System.out.println("Get student schoolId :" + schoolId);
		System.out.println("Get student gradeId :" + gradeId);
		System.out.println("Get student classId :" + classId);
		// 通过id查询这条学生信息
		Student student = studentService.selectStudentById(studentId);
		// 通过id查询学校信息
		School school = schoolService.selectSchoolById(schoolId);
		// 通过id查询年级信息
		Grade grade = gradeService.selectGradeById(gradeId);
		// 通过id查询班级信息
		ClassInfo classInfo = classService.selectClassById(classId);
		// 查询所有课程信息
		List<Course> selectAllCourse = courseService.selectAllCourse();
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 把selectAllCourse集合存入modelAndView
		modelAndView.addObject("courseList", selectAllCourse);
		// 把student对象存入modelAndView
		modelAndView.addObject("student", student);
		// 把school对象存入modelAndView
		modelAndView.addObject("school", school);
		// 把grade对象存入modelAndView
		modelAndView.addObject("grade", grade);
		// 把classInfo对象存入modelAndView
		modelAndView.addObject("classInfo", classInfo);
		// jsp位置
		modelAndView.setViewName("studentcourse");
		return modelAndView;
	}

	// 查看学生选课信息
	@RequestMapping("/add")
	public ModelAndView addCourse(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("schoolId") long schoolId, @RequestParam("gradeId") long gradeId,
			@RequestParam("classId") long classId, @RequestParam("id") long studentId) throws IOException {
		System.out.println("Get school id :" + schoolId);
		System.out.println("Get grade id :" + gradeId);
		System.out.println("Get class id :" + classId);
		System.out.println("Get student id :" + studentId);
		// 通过id查询学校信息
		School school = schoolService.selectSchoolById(schoolId);
		// 通过id查询年级信息
		Grade grade = gradeService.selectGradeById(gradeId);
		// 通过id查询班级信息
		ClassInfo classInfo = classService.selectClassById(classId);
		// 通过id查询学生信息
		Student student = studentService.selectStudentById(studentId);
		// 查询所有课程信息
		List<ElectiveCourse> electiveList = electiveService.selectElectiveByStudentId(studentId);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将这条学校信息存入modelAndView对象中
		modelAndView.addObject("school", school);
		// 将这条年级信息存入modelAndView对象中
		modelAndView.addObject("grade", grade);
		// 将这条班级信息存入modelAndView对象中
		modelAndView.addObject("classInfo", classInfo);
		// 将这条学生信息存入modelAndView对象中
		modelAndView.addObject("student", student);
		// 将electiveList存入modelAndView
		modelAndView.addObject("electiveList", electiveList);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("addcourse");
		return modelAndView;
	}

	// 更新学生选课信息
	@RequestMapping("/updatecourse")
	public ModelAndView updateCourse(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long studentId) throws IOException {
		System.out.println("Get student id :" + studentId);
		// 通过id查询学生信息
		Student student = studentService.selectStudentById(studentId);
		// 查询所有的选课信息
		List<Elective> selectAllElective = electiveService.selectAllElective();
		// 取出学生的出生年月
		java.sql.Date birthday = student.getBirthday();
		// 将Date类型转成String类型
		String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(birthday);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将这条学生信息存入modelAndView对象中
		modelAndView.addObject("student", student);
		// 将selectAllElective存入modelAndView
		modelAndView.addObject("electiveList", selectAllElective);
		// 将dateStr存入modelAndView
		modelAndView.addObject("dateStr", dateStr);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("updateCourseInfo");
		return modelAndView;
	}

	// 详细信息查看
	@RequestMapping("/detailed")
	public ModelAndView gradeDetailed(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") long studentId) throws IOException {
		System.out.println("Get student id :" + studentId);
		// 通过id查询学生信息
		Student student = studentService.selectStudentById(studentId);
		// 取出学生的出生年月
		java.sql.Date birthday = student.getBirthday();
		// 将Date类型转成String类型
		String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(birthday);
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将这条学生信息存入modelAndView对象中
		modelAndView.addObject("student", student);
		// 将dateStr存入modelAndView
		modelAndView.addObject("dateStr", dateStr);
		// 逻辑视图:就是jsp的路径
		modelAndView.setViewName("studentInformation");
		return modelAndView;
	}

}
