package com.quanzhen.myDemo.dao;

import java.util.List;

import com.quanzhen.myDemo.pojo.School;

/*
 * 作者:fuquanzhen
 * 类名:
 * 作用:school接口类
 * 日期:2019/09/23
 */
public interface SchoolDao {

	// 查询所有数据
	public List<School> findAll();

	// 插入数据
	public void save(School school);

	// 修改数据
	public void update(School school);

	// 删除数据
	public void delete(Long id);

}
