package com.table.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.table.pojo.ClassInfo;

public interface ClassInfoDao {

	// 插入
	public void insertClass(ClassInfo classInfo) throws IOException;

	// 删除
	public void deleteClass(long id) throws IOException;

	// 班级查询id和name
	public List<ClassInfo> selectClass() throws IOException;

	// 条件查询
	public List<ClassInfo> selectForClass(ClassInfo classInfo) throws IOException;

	// 根据id查询
	public ClassInfo selectClassById(long id) throws IOException;

	// 查询所有的班级信息
	public List<ClassInfo> selectAllClass() throws IOException;

	// 更新
	public void updateClass(Map<String, Object> map) throws IOException;

}
