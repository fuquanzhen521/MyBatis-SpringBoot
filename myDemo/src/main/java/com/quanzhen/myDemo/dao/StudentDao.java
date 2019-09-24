package com.quanzhen.myDemo.dao;

import java.util.List;

import com.quanzhen.myDemo.pojo.Student;

/*
 * 作者:fuquanzhen
 * 类名:StudentDao
 * 作用:StudentDao的接口类
 * 日期:2019/09/24
 */
public interface StudentDao {

	// 查询所有数据
	public List<Student> findAll();

	// 插入
	public void save(Student student);

	// 更新
	public void update(Student student);

	// 删除
	public void delete(Long id);

}
