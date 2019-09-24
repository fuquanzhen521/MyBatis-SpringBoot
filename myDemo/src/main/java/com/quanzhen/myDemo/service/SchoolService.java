package com.quanzhen.myDemo.service;

import java.util.List;

import com.quanzhen.myDemo.pojo.School;

/*
 * 作者:fuquanzhen
 * 类名:SchoolService
 * 作用:SchoolService的接口类
 * 日期:2019/09/23
 */
public interface SchoolService {

	// 查询所有数据
	public List<School> findAll();

	// 插入
	public void save(String name, Boolean jbw, Boolean eyy);

	// 更新
	public void update(String name, Boolean jbw, Boolean eyy);

	// 删除
	public void delete(Long id);

}
