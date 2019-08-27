package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.table.pojo.Course;

public interface CourseService {

	// 插入
	public void insertCourse(String name) throws IOException;

	// 查询课程id
	public List<Long> selectCourse() throws IOException;

	// 查询所有课程信息
	public List<Course> selectAllCourse() throws IOException;

	// 条件查询
	public List<Course> selectForCourse(String name) throws IOException;

	// 根据id查询
	public Course selectCourseById(long id) throws IOException;

	// 删除
	public void deleteCourse(long id) throws IOException;

	// 更新
	public void updateCourse(long id, String name) throws IOException;

}
