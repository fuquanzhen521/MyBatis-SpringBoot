package com.table.daoimpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.table.dao.ClassInfoDao;
import com.table.pojo.ClassInfo;
import com.table.utils.TableUtils;

/*
 * 作者:付全镇
 * 类名:ClassInfoDaoImpl
 * 作用:class表的增删查改的具体实现
 * 日期:2019/7/1
 */

@Repository
public class ClassInfoDaoImpl implements ClassInfoDao {

	// 无参构造器
	public ClassInfoDaoImpl() {
	}

	// 插入
	public void insertClass(ClassInfo classInfo) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.insert("insertClass", classInfo);
		sqlSession.commit();
		sqlSession.close();
	}

	// 删除
	public void deleteClass(long id) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.delete("deleteClass", id);
		sqlSession.commit();
		sqlSession.close();
	}

	// 查询id和name
	public List<ClassInfo> selectClass() throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<ClassInfo> classInfoList = sqlSession.selectList("selectClass");
		sqlSession.close();
		return classInfoList;
	}

	// 修改
	public void updateClass(Map<String, Object> map) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		sqlSession.update("updateClass", map);
		sqlSession.commit();
		sqlSession.close();
	}

	// 查询所有的班级信息
	public List<ClassInfo> selectAllClass() throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<ClassInfo> classList = sqlSession.selectList("selectAllClass");
		return classList;
	}

	// 条件查询
	public List<ClassInfo> selectForClass(ClassInfo classInfo) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		List<ClassInfo> selectList = sqlSession.selectList("selectForClass", classInfo);
		sqlSession.close();
		return selectList;
	}

	// 根据id查询
	public ClassInfo selectClassById(long id) throws IOException {
		SqlSession sqlSession = TableUtils.openSqlSession();
		ClassInfo classInfo = sqlSession.selectOne("selectClassById", id);
		return classInfo;
	}

}
