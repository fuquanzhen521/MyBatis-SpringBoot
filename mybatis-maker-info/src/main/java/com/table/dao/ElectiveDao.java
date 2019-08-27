package com.table.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.table.pojo.Elective;
import com.table.pojo.ElectiveCourse;

public interface ElectiveDao {

	// 插入
	public void insertElective(Elective elective) throws IOException;

	// 删除
	public void deleteElective(long id) throws IOException;

	// 查询所有选课信息
	public List<Elective> selectAllElective() throws IOException;

	// 条件查询
	public List<Elective> selectForElective(Map<String, Object> map) throws IOException;

	// 根据id查询
	public Elective selectElectiveById(long id) throws IOException;

	// 更新
	public void updateElective(Map<String, Object> map) throws IOException;

	// 学生选课信息查询
	public List<ElectiveCourse> selectElectiveByStudentId(long id) throws IOException;

}
