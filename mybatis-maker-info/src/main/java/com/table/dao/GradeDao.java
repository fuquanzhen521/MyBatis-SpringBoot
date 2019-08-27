package com.table.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.table.pojo.Grade;

public interface GradeDao {

	// 插入
	public void insertGrade(Grade grade) throws IOException;

	// 删除
	public void deleteGrade(long id) throws IOException;

	// 查询id和name(分页查询)
	public List<Grade> selectGrade(int page) throws IOException;

	// 条件查询
	public List<Grade> selectForGrade(Grade grade) throws IOException;

	// 查询所有数据
	public List<Grade> selectAllGrade() throws IOException;

	// 根据id查询年级信息
	public Grade selectGradeById(long id) throws IOException;

	// 更新
	public void updateGrade(Map<String, Object> map) throws IOException;

}
