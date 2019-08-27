package com.example.demo.serviceimpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.TeacherService;
import com.table.dao.TeacherDao;
import com.table.pojo.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;

	// 插入
	@Override
	public void insertTeacher(String name, long courseId) throws IOException {
		// 创建teacher对象
		Teacher teacher = new Teacher();
		// 把名字存入teacher中
		teacher.setName(name);
		// 把课程id存入teacher中
		teacher.setCid(courseId);
		// 插入
		teacherDao.insertTeacher(teacher);
	}

	// 查询所有教师信息
	@Override
	public List<Teacher> selectAllTeacher() throws IOException {
		// 调用查询方法
		List<Teacher> teacherList = teacherDao.selectAllTeacher();
		return teacherList;
	}

	// 条件查询
	@Override
	public List<Teacher> selectForTeacher(String name) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		// 调用查询方法
		List<Teacher> teacherList = teacherDao.selectForTeacher(map);
		return teacherList;
	}

	// 通过id查询
	@Override
	public Teacher selectTeacherById(long id) throws IOException {
		Teacher teacher = teacherDao.selectTeacherById(id);
		return teacher;
	}

	// 更新
	@Override
	public void update(long id, String name, long cid) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("cid", cid);
		// 更新
		teacherDao.updateTeacher(map);
	}

	// 删除
	@Override
	public void delete(long id) throws IOException {
		teacherDao.deleteTeacher(id);
	}

}
