package com.example.demo.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.SchoolService;
import com.table.dao.SchoolDao;
import com.table.pojo.School;

/*
 * 姓名:付全镇
 * 类名:SchoolServiceImpl
 * 作用:school表的增删查改
 * 日期:2019/7/5
 */

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolDao schoolDao;

	// 插入
	public List<School> insertSchool(String name, Integer size) throws IOException {
		List<School> schoolList = new ArrayList<School>();
		School school = new School();
		// 随机数
		Random random = new Random();
		for (int i = 1; i <= size; i++) {
			// 生成name
			String schoolName = name + "第" + i + "中学";
			school.setName(schoolName);
			// 取0到9之间的随机数
			int count = random.nextInt(10);
			if (count >= 0 && count < 5) {
				school.setJbw(false);
				school.setEyy(false);
			} else if (count >= 5 && count < 7) {
				school.setJbw(true);
				school.setEyy(false);
			} else if (count >= 7 && count < 9) {
				school.setJbw(false);
				school.setEyy(true);
			} else {
				school.setJbw(true);
				school.setEyy(true);
			}
			schoolDao.insertSchool(school);
		}
		List<School> selectAllSchool = schoolDao.selectAllSchool();
		schoolList.addAll(selectAllSchool);
		return schoolList;
	}

	// 查询school的id和name
	@Override
	public List<School> selectSchool(int page) throws IOException {
		int startRow = (page-1)*10;
		// 调用查询方法
		List<School> schoolList = schoolDao.selectSchool(startRow);
		return schoolList;
	}

	// 查询school表所有信息
	@Override
	public List<School> selectAllSchool() throws IOException {
		List<School> selectAllSchool = schoolDao.selectAllSchool();
		return selectAllSchool;
	}

	// 插入一条数据
	@Override
	public void insertSchool(School school) throws IOException {
		schoolDao.insertSchool(school);
	}

	// 条件查询
	@Override
	public List<School> selectForSchool(String name, Boolean jbw, Boolean eyy) throws IOException {
		School school = new School();
		school.setName(name);
		school.setJbw(jbw);
		school.setEyy(eyy);
		List<School> selectForSchool = schoolDao.selectForSchool(school);
		return selectForSchool;
	}

	// 更新
	@Override
	public void update(long schoolId, String name, Boolean jbw, Boolean eyy) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", schoolId);
		map.put("name", name);
		map.put("jbw", jbw);
		map.put("eyy", eyy);
		schoolDao.updateSchool(map);
	}

	// 根据id查询单个数据
	@Override
	public School selectSchoolById(long id) throws IOException {
		// 查询
		School school = schoolDao.selectSchoolById(id);
		return school;
	}

	// 删除
	@Override
	public void delete(long id) throws IOException {
		schoolDao.deleteSchool(id);
	}

}
