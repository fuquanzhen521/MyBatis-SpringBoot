package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.table.pojo.Teacher;

public interface TeacherService {

	// 插入
	public void insertTeacher(String name, long courseId) throws IOException;

	// 查询所有教师信息
	public List<Teacher> selectAllTeacher() throws IOException;

	// 条件查询
	public List<Teacher> selectForTeacher(String name) throws IOException;

	// 通过id查询
	public Teacher selectTeacherById(long id) throws IOException;

	// 更新
	public void update(long id, String name, long cid) throws IOException;

	// 删除
	public void delete(long id) throws IOException;

}
