package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.table.pojo.Grade;

public interface GradeService {

	// 插入
	public List<Grade> insertGrade(Integer size) throws IOException;

	// 插入一条年级信息
	public void insertGrade(Grade grade) throws IOException;

	// 查询grade表id和name(分页查询)
	public List<Grade> selectGrade(int page) throws IOException;

	// 查询grade表所有信息
	public List<Grade> selectAllGrade() throws IOException;

	// 条件查询
	public List<Grade> selectForGrade(String name) throws IOException;

	// 通过id查询年级信息
	public Grade selectGradeById(long id) throws IOException;

	// 修改
	public void update(long id, String name) throws IOException;

	// 删除
	public void delete(long id) throws IOException;

}
