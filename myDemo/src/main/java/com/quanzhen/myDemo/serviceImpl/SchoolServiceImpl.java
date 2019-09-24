package com.quanzhen.myDemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanzhen.myDemo.dao.SchoolDao;
import com.quanzhen.myDemo.pojo.School;
import com.quanzhen.myDemo.service.SchoolService;

/*
 * 作者:fuquanzhen
 * 类名:SchoolServiceImpl
 * 作用:SchoolService的实现类
 * 日期:2019/09/23
 */
@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolDao schoolDao;

	// 查询所有数据
	@Override
	public List<School> findAll() {
		// 查询
		List<School> schoolList = schoolDao.findAll();
		return schoolList;
	}

	// 插入
	@Override
	public void save(String name, Boolean jbw, Boolean eyy) {
		// 创建school对象
		School school = new School();
		school.setName(name);
		school.setJbw(jbw);
		school.setEyy(eyy);
		// 插入
		schoolDao.save(school);
	}

	// 更新
	@Override
	public void update(String name, Boolean jbw, Boolean eyy) {
		School school = new School();
		school.setName(name);
		school.setJbw(jbw);
		school.setEyy(eyy);
		// 更新
		schoolDao.update(school);
	}

	// 删除
	@Override
	public void delete(Long id) {
		// 删除
		schoolDao.delete(id);
	}

}
