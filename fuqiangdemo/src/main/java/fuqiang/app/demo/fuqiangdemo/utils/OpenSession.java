package fuqiang.app.demo.fuqiangdemo.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * 作者:付全镇
 * 类名:OpenSession
 * 作用:获得sqlSession
 * 日期:2019.09.04
 */
public class OpenSession {

	private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;

	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSession openSession() throws IOException {
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		return sqlSessionFactory.openSession();
	}
}
