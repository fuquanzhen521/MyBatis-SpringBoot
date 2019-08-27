package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.table.pojo.Elective;
import com.table.pojo.ElectiveCourse;

public interface ElectiveService {

	// 插入
	public void insertElective(long studentId, long teacherId, long courseId, int score) throws IOException;

	// 查询所有的elective信息
	public List<Elective> selectAllElective() throws IOException;

	// 查询学生的选课信息
	public List<ElectiveCourse> selectElectiveByStudentId(long id) throws IOException;

}
