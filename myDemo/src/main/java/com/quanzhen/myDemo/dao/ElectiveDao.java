package com.quanzhen.myDemo.dao;

import java.util.List;

import com.quanzhen.myDemo.pojo.Elective;

/*
 * 作者:fuquanzhen
 * 类名:ElectiveDao
 * 作用:ElectiveDao的接口类
 * 日期:2019/09/24
 */
public interface ElectiveDao {

	// 查询所有数据
	public List<Elective> findAll();

	// 插入
	public void save(Elective elective);

	// 更新
	public void update(Elective elective);

	// 删除
	public void delete(Long id);

}
