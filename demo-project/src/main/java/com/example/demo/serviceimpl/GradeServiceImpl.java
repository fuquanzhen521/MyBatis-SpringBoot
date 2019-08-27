package com.example.demo.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.GradeService;
import com.table.dao.GradeDao;
import com.table.pojo.Grade;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDao gradeDao;

	// 插入
	@Override
	public List<Grade> insertGrade(Integer size) throws IOException {
		// 创建gradeList集合
		List<Grade> gradeList = new ArrayList<Grade>();
		// 创建grade对象
		Grade grade = new Grade();
		for (int i = 1; i <= size; i++) {
			// 取得name
			String name = i + "年级";
			// 把name放进去
			grade.setName(name);
			gradeDao.insertGrade(grade);
		}
		// 查询所有grade信息
		List<Grade> selectAllGrade = gradeDao.selectAllGrade();
		gradeList.addAll(selectAllGrade);
		return gradeList;
	}

	// 查询grade表id
	@Override
	public List<Grade> selectGrade(int page) throws IOException {
		int startRow = (page - 1) * 10;
		// 调用查询方法
		List<Grade> gradeList = gradeDao.selectGrade(startRow);
		return gradeList;
	}

	// 查询grade表所有信息
	@Override
	public List<Grade> selectAllGrade() throws IOException {
		// 查询grade表所有信息
		List<Grade> selectAllGrade = gradeDao.selectAllGrade();
		return selectAllGrade;
	}

	// 条件查询
	@Override
	public List<Grade> selectForGrade(String name) throws IOException {
		Grade grade = new Grade();
		grade.setName(name);
		List<Grade> selectForGrade = gradeDao.selectForGrade(grade);
		return selectForGrade;
	}

	// 插入一条年级信息
	@Override
	public void insertGrade(Grade grade) throws IOException {
		gradeDao.insertGrade(grade);
	}

	// 通过id查询这条年级信息
	@Override
	public Grade selectGradeById(long id) throws IOException {
		Grade grade = gradeDao.selectGradeById(id);
		return grade;
	}

	// 更新
	@Override
	public void update(long gradeId, String name) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", gradeId);
		map.put("name", name);
		gradeDao.updateGrade(map);
	}

	// 删除
	@Override
	public void delete(long id) throws IOException {
		gradeDao.deleteGrade(id);
	}

}
