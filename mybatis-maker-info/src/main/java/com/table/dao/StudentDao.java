package com.table.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.table.pojo.Student;

public interface StudentDao {

	// 插入
	public void insertStudent(Student student) throws IOException;

	// 删除
	public void deleteStudent(long id) throws IOException;

	// 查询id
	public List<Long> selectStudent(Map<String, Object> map) throws IOException;

	// 查询所有学生信息
	public List<Student> selectAllStudent() throws IOException;

	// 条件查询
	public List<Student> selectForStudent(Student sudent) throws IOException;

	// 通过id查询
	public Student selectStudentById(long id) throws IOException;

	// 更新
	public void updateStudent(Map<String, Object> map) throws IOException;

}
