package com.table.daoimpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.table.dao.TeacherDao;
import com.table.pojo.Teacher;
import com.table.utils.TableUtils;

/*
 * 作者:付全镇
 * 类名:teacherDaoImpl
 * 作用:teacher表的增删查改
 * 日期:2019/7/1
 */

@Repository
public class TeacherDaoImpl implements TeacherDao {

	// 无参构造器
	public TeacherDaoImpl() {
	}

	// 插入
	public void insertTeacher(Teacher teacher) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.insert("insertTeacher", teacher);
		sqlSession.commit();
		sqlSession.close();
	}

	// 删除
	public void deleteTeacher(long id) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.delete("deleteTeacher", id);
		sqlSession.commit();
		sqlSession.close();
	}

	// 查询
	public List<Teacher> selectAllTeacher() throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<Teacher> teacherList = sqlSession.selectList("selectAllTeacher");
		sqlSession.close();
		return teacherList;
	}

	// 修改
	public void updateTeacher(Map<String, Object> map) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.update("updateTeacher", map);
		sqlSession.commit();
		sqlSession.close();
	}

	// 条件查询
	public List<Teacher> selectForTeacher(Map<String, Object> map) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<Teacher> selectList = sqlSession.selectList("selectForTeacher", map);
		sqlSession.close();
		return selectList;
	}

	// 根据id查询
	public Teacher selectTeacherById(long id) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		Teacher teacher = sqlSession.selectOne("selectTeacherById", id);
		sqlSession.close();
		return teacher;
	}

}
