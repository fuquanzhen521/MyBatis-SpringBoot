package com.table.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.table.pojo.Course;

public interface CourseDao {

	// 插入
	public void insertCourse(Course course) throws IOException;

	// 删除
	public void deleteCourse(long id) throws IOException;

	// 查询id
	public List<Long> selectCourse() throws IOException;

	// 查询所有数据
	public List<Course> selectAllCourse() throws IOException;

	// 条件查询
	public List<Course> selectForCourse(Course course) throws IOException;

	// 根据id查询
	public Course selectCourseById(long id) throws IOException;

	// 更新
	public void updateCourse(Map<String, Object> map) throws IOException;

}
