package com.table.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TableUtils {

	private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;

	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSession openSqlSession() throws IOException  {
		sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		return sqlSessionFactory.openSession();
	}

}
