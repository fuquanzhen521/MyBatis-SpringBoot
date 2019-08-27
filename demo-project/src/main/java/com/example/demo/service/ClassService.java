package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.table.pojo.ClassInfo;

public interface ClassService {

	// 插入一条数据
	public void insertClass(ClassInfo classInfo) throws IOException;

	// 查询id和name
	public List<ClassInfo> selectClass() throws IOException;

	// 查询所有数据
	public List<ClassInfo> selectAllClass() throws IOException;

	// 条件查询
	public List<ClassInfo> selectForClass(String name) throws IOException;

	// 根据id查询年级信息
	public ClassInfo selectClassById(long id) throws IOException;

	// 更新
	public void update(long id, String name, long sch_id, long gra_id) throws IOException;

	// 删除
	public void delete(long id) throws IOException;

}
