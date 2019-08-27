package com.example.demo.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.ElectiveService;
import com.table.dao.ElectiveDao;
import com.table.pojo.Elective;
import com.table.pojo.ElectiveCourse;

@Service
public class ElectiveServiceImpl implements ElectiveService {

	@Autowired
	public ElectiveDao electiveDao;

	// 插入
	@Override
	public void insertElective(long studentId, long teacherId, long courseId, int score) throws IOException {
		// TODO Auto-generated method stub

	}

	// 查询所有选课信息
	@Override
	public List<Elective> selectAllElective() throws IOException {
		List<Elective> electiveList = electiveDao.selectAllElective();
		return electiveList;
	}

	// 查询学生的选课信息
	@Override
	public List<ElectiveCourse> selectElectiveByStudentId(long id) throws IOException {
		List<ElectiveCourse> electiveCourseList = electiveDao.selectElectiveByStudentId(id);
		return electiveCourseList;
	}

}
