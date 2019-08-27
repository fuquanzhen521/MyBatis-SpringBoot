package com.table.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.table.pojo.Teacher;

public interface TeacherDao {

	// 插入
	public void insertTeacher(Teacher teacher) throws IOException;

	// 删除
	public void deleteTeacher(long id) throws IOException;

	// 查询所有教师信息
	public List<Teacher> selectAllTeacher() throws IOException;

	// 条件查询
	public List<Teacher> selectForTeacher(Map<String, Object> map) throws IOException;

	// 根据id查询teacher
	public Teacher selectTeacherById(long id) throws IOException;

	// 更新
	public void updateTeacher(Map<String, Object> map) throws IOException;

}
