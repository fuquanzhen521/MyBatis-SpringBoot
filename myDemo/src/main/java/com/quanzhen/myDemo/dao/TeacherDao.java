package com.quanzhen.myDemo.dao;

import java.util.List;

import com.quanzhen.myDemo.pojo.Teacher;

/*
 * 作者:fuquanzhen
 * 类名:TeacherDao
 * 作用:TeacherDao的接口类
 * 日期:2019/09/24
 */
public interface TeacherDao {

	// 查询所有数据
	public List<Teacher> findAll();

	// 插入
	public void save(Teacher teacher);

	// 更新
	public void update(Teacher teacher);

	// 删除
	public void delete(Long id);

}
