package com.table.daoimpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.table.dao.GradeDao;
import com.table.pojo.Grade;
import com.table.utils.TableUtils;

/*
 * 作者:付全镇
 * 类名:GradeDaoImpl
 * 作用:grade表的增删查改操作
 * 日期:2019/7/1
 */

@Repository
public class GradeDaoImpl implements GradeDao {

	// 无参构造器
	public GradeDaoImpl() {
	}

	// 插入
	public void insertGrade(Grade grade) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.insert("insertGrade", grade);
		sqlSession.commit();
		sqlSession.close();
	}

	// 删除
	public void deleteGrade(long id) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.delete("deleteGrade", id);
		sqlSession.commit();
		sqlSession.close();
	}

	// 查询id和name
	public List<Grade> selectGrade(int page) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<Grade> gradeIdList = sqlSession.selectList("selectGrade", page);
		sqlSession.close();
		return gradeIdList;
	}

	// 修改
	public void updateGrade(Map<String, Object> map) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.update("updateGrade", map);
		sqlSession.commit();
		sqlSession.close();
	}

	// 查询所有数据
	public List<Grade> selectAllGrade() throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<Grade> gradeList = sqlSession.selectList("selectAllGrade");
		return gradeList;
	}

	// 条件查询
	public List<Grade> selectForGrade(Grade grade) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<Grade> selectList = sqlSession.selectList("selectForGrade", grade);
		sqlSession.close();
		return selectList;
	}

	// 根据id查询年级信息
	public Grade selectGradeById(long id) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		Grade grade = sqlSession.selectOne("selectGradeById", id);
		return grade;
	}

}
