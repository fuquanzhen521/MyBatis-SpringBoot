package com.table.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.table.pojo.School;

public interface SchoolDao {

	// 插入
	public void insertSchool(School school) throws IOException;

	// 删除
	public void deleteSchool(long id) throws IOException;

	// 查询id和name(分页查询)
	public List<School> selectSchool(int page) throws IOException;

	// 根据id查询school对象
	public School selectSchoolById(long id) throws IOException;

	// 查询所有学校信息
	public List<School> selectAllSchool() throws IOException;

	// 更新学校信息
	public void updateSchool(Map<String, Object> map) throws IOException;

	// 条件查询
	public List<School> selectForSchool(School school) throws IOException;

}
