package com.quanzhen.myDemo.dao;

import java.util.List;

import com.quanzhen.myDemo.pojo.Course;

/*
 * 作者:fuquanzhen
 * 类名:CourseDao
 * 作用:CourseDao接口类
 * 日期:2019/09/24
 */
public interface CourseDao {

	// 查询所有数据
	public List<Course> findAll();

	// 插入
	public void save(Course course);

	// 更新
	public void update(Course course);

	// 删除
	public void delete(Long id);

}
