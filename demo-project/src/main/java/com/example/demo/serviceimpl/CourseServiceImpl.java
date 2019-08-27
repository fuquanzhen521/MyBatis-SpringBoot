package com.example.demo.serviceimpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.CourseService;
import com.table.dao.CourseDao;
import com.table.pojo.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	public CourseDao courseDao;

	// 插入
	@Override
	public void insertCourse(String name) throws IOException {
		// 创建course对象
		Course course = new Course();
		course.setName(name);
		courseDao.insertCourse(course);
	}

	// course表查询id
	@Override
	public List<Long> selectCourse() throws IOException {
		// 调用查询方法
		List<Long> courseIdList = courseDao.selectCourse();
		return courseIdList;
	}

	// course表查询对象
	@Override
	public List<Course> selectAllCourse() throws IOException {
		List<Course> selectAllCourse = courseDao.selectAllCourse();
		return selectAllCourse;
	}

	// 条件查询
	@Override
	public List<Course> selectForCourse(String name) throws IOException {
		// 创建course对象
		Course course = new Course();
		// 将name存入course
		course.setName(name);
		// 查询
		List<Course> courseList = courseDao.selectForCourse(course);
		// 返回集合
		return courseList;
	}

	// 通过id查询课程
	@Override
	public Course selectCourseById(long id) throws IOException {
		Course course = courseDao.selectCourseById(id);
		return course;
	}

	// 删除
	@Override
	public void deleteCourse(long id) throws IOException {
		courseDao.deleteCourse(id);
	}

	// 更新
	@Override
	public void updateCourse(long id, String name) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		courseDao.updateCourse(map);
	}

}
