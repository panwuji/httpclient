package com.yzkj.service;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 内部类实现单例SqlSessionFactory
 * @author panwuji
 *
 */
public class SqlSessionFactoryLoader {
	/**
	 * 静态内部类
	 * @author panwuji
	 *
	 */
	static class SingletonSqlSessionFactory{
		/**
		 * 内部类静态成员SqlSessionFactory
		 */
		private static SqlSessionFactory SQLSESSIONFACTORY;
		/**
		 * 静态块用以加载资源文件，初始化静态成员
		 */
		static {
			try {
				String resource = "mybatis-config.xml";
				InputStream inputStream = Resources.getResourceAsStream(resource);
				SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
				SQLSESSIONFACTORY = builder.build(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 暴露给外部方法
	 * @return
	 */
	public static SqlSessionFactory getSingletonSqlSessionFactory(){
		return SingletonSqlSessionFactory.SQLSESSIONFACTORY;
	}
}
