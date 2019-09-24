package com.quanzhen.myDemo.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quanzhen.myDemo.dao.SchoolDao;
import com.quanzhen.myDemo.pojo.School;

/*
 * 作者:fuquanzhen
 * 类名:SchoolDaoImpl
 * 作用:SchoolDao接口的实现类
 * 日期:2019/09/23
 */
@Repository
public class SchoolDaoImpl implements SchoolDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// 查询所有数据
	@Override
	public List<School> findAll() {
		// 查询
		List<School> schoolList = sqlSessionTemplate.selectList("findAll");
		return schoolList;
	}

	// 插入
	@Override
	public void save(School school) {
		// 插入
		sqlSessionTemplate.insert("save", school);
	}

	// 修改
	@Override
	public void update(School school) {
		// 修改
		sqlSessionTemplate.update("update", school);
	}

	// 删除
	@Override
	public void delete(Long id) {
		// 删除
		sqlSessionTemplate.delete("delete", id);
	}

}
