package com.table.daoimpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.table.dao.SchoolDao;
import com.table.pojo.School;
import com.table.utils.TableUtils;

/*
 * 作者:付全镇
 * 类名:SchoolDaoImpl
 * 作用:school表的增删查改操作
 * 日期:2019/7/1
 */

@Repository
public class SchoolDaoImpl implements SchoolDao {

	// 无参构造器
	public SchoolDaoImpl() {
	}

	// 插入
	public void insertSchool(School school) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.insert("insertSchool", school);
		sqlSession.commit();
		sqlSession.close();
	}

	// 删除
	public void deleteSchool(long id) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.delete("deleteSchool", id);
		sqlSession.commit();
		sqlSession.close();
	}

	// 查询学校id和name(分页查询)
	public List<School> selectSchool(int page) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<School> selectList = sqlSession.selectList("selectSchool", page);
		sqlSession.close();
		return selectList;
	}

	// 修改
	public void updateSchool(Map<String, Object> map) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.update("updateSchool", map);
		sqlSession.commit();
		sqlSession.close();
	}

	// 查询所有信息
	public List<School> selectAllSchool() throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<School> schoolList = sqlSession.selectList("selectAllSchool");
		sqlSession.close();
		return schoolList;
	}

	// 条件查询
	public List<School> selectForSchool(School school) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<School> selectList = sqlSession.selectList("selectForSchool", school);
		sqlSession.close();
		return selectList;
	}

	// 单个数据查询
	public School selectSchoolById(long id) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		School school = sqlSession.selectOne("selectSchoolById", id);
		sqlSession.close();
		return school;
	}

}
