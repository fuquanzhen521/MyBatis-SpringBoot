package com.table.daoimpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.table.dao.ElectiveDao;
import com.table.pojo.Elective;
import com.table.pojo.ElectiveCourse;
import com.table.utils.TableUtils;

/*
 * 作者:付全镇
 * 类名:ElectiveDaoImpl
 * 作用:elective表的增删查改
 * 日期:2019/7/1
 */

@Repository
public class ElectiveDaoImpl implements ElectiveDao {

	// 无参构造器
	public ElectiveDaoImpl() {
	}

	// 插入
	public void insertElective(Elective elective) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.insert("insertElective", elective);
		sqlSession.commit();
		sqlSession.close();
	}

	// 删除
	public void deleteElective(long id) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.delete("deleteElective", id);
		sqlSession.commit();
		sqlSession.close();
	}

	// 查询
	public List<Elective> selectAllElective() throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<Elective> electiveList = sqlSession.selectList("selectAllElective");
		sqlSession.close();
		return electiveList;
	}

	// 修改
	public void updateElective(Map<String, Object> map) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.update("updateElective", map);
		sqlSession.commit();
		sqlSession.close();
	}

	// 条件查询
	public List<Elective> selectForElective(Map<String, Object> map) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<Elective> selectList = sqlSession.selectList("selectForElective", map);
		sqlSession.close();
		return selectList;
	}

	// 选修班根据id查询数据
	public Elective selectElectiveById(long id) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		Elective elective = sqlSession.selectOne("selectElectiveById", id);
		sqlSession.close();
		return elective;
	}

	// 查询学生的选课信息
	public List<ElectiveCourse> selectElectiveByStudentId(long id) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<ElectiveCourse> selectList = sqlSession.selectList("selectElectiveByStudentId", id);
		sqlSession.close();
		return selectList;
	}

}
