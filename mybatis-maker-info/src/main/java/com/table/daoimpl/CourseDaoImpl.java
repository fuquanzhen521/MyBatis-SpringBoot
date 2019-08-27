package com.table.daoimpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.table.dao.CourseDao;
import com.table.pojo.Course;
import com.table.utils.TableUtils;

/*
 * 作者:付全镇
 * 类名:CourseDaoImpl
 * 作用:course表的增删查改
 * 日期:2019/7/1
 */

@Repository
public class CourseDaoImpl implements CourseDao {

	public CourseDaoImpl() {
	}

	// 插入
	public void insertCourse(Course course) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.insert("insertCourse", course);
		sqlSession.commit();
		sqlSession.close();
	}

	// 删除
	public void deleteCourse(long id) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.delete("deleteCourse", id);
		sqlSession.commit();
		sqlSession.close();
	}

	// 查询id
	public List<Long> selectCourse() throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<Long> CourseIdList = sqlSession.selectList("selectCourse");
		return CourseIdList;
	}

	// 更新
	public void updateCourse(Map<String, Object> map) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.update("updateCourse", map);
		sqlSession.commit();
		sqlSession.close();
	}

	// 查询所有数据
	public List<Course> selectAllCourse() throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<Course> courseList = sqlSession.selectList("selectAllCourse");
		sqlSession.close();
		return courseList;
	}

	// 条件查询
	public List<Course> selectForCourse(Course course) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<Course> selectList = sqlSession.selectList("selectForCourse", course);
		sqlSession.close();
		return selectList;
	}

	// 根据id查询
	public Course selectCourseById(long id) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		Course course = sqlSession.selectOne("selectCourseById", id);
		sqlSession.close();
		return course;
	}

}
