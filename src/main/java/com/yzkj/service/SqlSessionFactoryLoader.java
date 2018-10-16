package com.yzkj.service;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * �ڲ���ʵ�ֵ���SqlSessionFactory
 * @author panwuji
 *
 */
public class SqlSessionFactoryLoader {
	/**
	 * ��̬�ڲ���
	 * @author panwuji
	 *
	 */
	static class SingletonSqlSessionFactory{
		/**
		 * �ڲ��ྲ̬��ԱSqlSessionFactory
		 */
		private static SqlSessionFactory SQLSESSIONFACTORY;
		/**
		 * ��̬�����Լ�����Դ�ļ�����ʼ����̬��Ա
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
	 * ��¶���ⲿ����
	 * @return
	 */
	public static SqlSessionFactory getSingletonSqlSessionFactory(){
		return SingletonSqlSessionFactory.SQLSESSIONFACTORY;
	}
}
