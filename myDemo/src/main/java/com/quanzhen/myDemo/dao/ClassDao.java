package com.quanzhen.myDemo.dao;

import java.util.List;

import com.quanzhen.myDemo.pojo.ClassInfo;

/*
 * 作者:fuquanzhen
 * 类名:ClassDao
 * 作用:ClassDao接口类
 * 日期:2019/09/24
 */
public interface ClassDao {

	// 查询所有数据
	public List<ClassInfo> findAll();

	// 插入
	public void save(ClassInfo classInfo);

	// 更新
	public void update(ClassInfo classInfo);

	// 删除
	public void delete(Long id);

}
