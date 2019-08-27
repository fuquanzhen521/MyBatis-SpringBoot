package com.example.demo.serviceimpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.ClassService;
import com.table.dao.ClassInfoDao;
import com.table.pojo.ClassInfo;


@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassInfoDao classInfoDao;

	// 查询class表的id和name
	@Override
	public List<ClassInfo> selectClass() throws IOException {
		// 调用查询方法
		List<ClassInfo> classList = classInfoDao.selectClass();
		return classList;
	}

	// 查询class表的对象
	@Override
	public List<ClassInfo> selectAllClass() throws IOException {
		List<ClassInfo> selectAllClass = classInfoDao.selectAllClass();
		return selectAllClass;
	}

	// 插入一条班级信息
	@Override
	public void insertClass(ClassInfo classInfo) throws IOException {
		classInfoDao.insertClass(classInfo);
	}

	// 条件查询
	@Override
	public List<ClassInfo> selectForClass(String name) throws IOException {
		ClassInfo classInfo = new ClassInfo();
		classInfo.setName(name);
		List<ClassInfo> selectForClass = classInfoDao.selectForClass(classInfo);
		return selectForClass;
	}

	// 更新
	@Override
	public void update(long id, String name, long sch_id, long gra_id) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("sch_id", sch_id);
		map.put("gra_id", gra_id);
		classInfoDao.updateClass(map);
	}

	// 删除
	@Override
	public void delete(long id) throws IOException {
		classInfoDao.deleteClass(id);
	}

	// 根据id查询班级信息
	@Override
	public ClassInfo selectClassById(long id) throws IOException {
		ClassInfo classInfo = classInfoDao.selectClassById(id);
		return classInfo;
	}

}
