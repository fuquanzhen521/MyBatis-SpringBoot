package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.table.pojo.School;

public interface SchoolService {

	// 插入
	public List<School> insertSchool(String name, Integer size) throws IOException;

	// 查询school表id和name
	public List<School> selectSchool(int page) throws IOException;

	// 查询school表所有信息
	public List<School> selectAllSchool() throws IOException;

	// 插入一条信息
	public void insertSchool(School school) throws IOException;

	// 条件查询
	public List<School> selectForSchool(String name, Boolean jbw, Boolean eyy) throws IOException;

	// 修改
	public void update(long schoolId, String name, Boolean jbw, Boolean eyy) throws IOException;

	// 根据id查询单条数据
	public School selectSchoolById(long id) throws IOException;

	// 删除
	public void delete(long id) throws IOException;

}
