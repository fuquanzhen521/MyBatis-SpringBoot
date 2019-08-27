package com.example.demo.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.table.pojo.Student;

public interface StudentService {

	// 插入
	public void insertStudent() throws IOException;

	// 插入
	public void insertStudent(Student student) throws IOException;

	// 查询student表id
	public List<Long> selectStudent(Map<String, Object> map) throws IOException;

	// 查询student表数据
	public List<Student> selectAllStudent() throws IOException;

	// 根据id查询student对象
	public Student selectStudentById(long id) throws IOException;

	// 条件查询
	public List<Student> selectForStudent(String name, Byte sex) throws IOException;

	// 更新
	public void update(long id, String name, Date birthday, Byte sex, long sch_id, long gra_id, long cla_id)
			throws IOException;

	// 删除
	public void delete(long id) throws IOException;

}
