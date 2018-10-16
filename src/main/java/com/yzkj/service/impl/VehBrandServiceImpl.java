package com.yzkj.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yzkj.base.VehBrand;
import com.yzkj.mapper.VehBrandMapper;
import com.yzkj.service.SqlSessionFactoryLoader;
import com.yzkj.service.VehBrandService;
/**
 * ����Ʒ�Ʒ���ӿ�ʵ��
 * @author panwuji
 *
 */
public class VehBrandServiceImpl implements VehBrandService {
	/**
	 * ����Ʒ��id��ѯƷ����Ϣ�������ã�
	 */
	public VehBrand getBrandInfoById(int brandId) {
		SqlSession session = null;
		try {
			// ��ȡ������SqlSessionFactory
			SqlSessionFactory factory = SqlSessionFactoryLoader.getSingletonSqlSessionFactory();
			// ��ȡsqlSession
			session = factory.openSession(true);
			// ��ȡmapper����
			VehBrandMapper vehBrandMapper = session.getMapper(VehBrandMapper.class);
			// ��ѯ
			VehBrand brand = vehBrandMapper.selectByBrandId(brandId);
			// ����
			return brand;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ�����ܻᷢ��NullPointException����try...catch...
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * ��ӳ���Ʒ�ƣ�������
	 */
	public void addVehBrand(VehBrand vehBrand) {
		SqlSession session = null;
		try {
			// ��ȡ������SqlSessionFactory
			SqlSessionFactory factory = SqlSessionFactoryLoader.getSingletonSqlSessionFactory();
			// ��ȡsqlSession
			session = factory.openSession(true);
			// ��ȡmapper����
			VehBrandMapper vehBrandMapper = session.getMapper(VehBrandMapper.class);
			// ��ѯ
			vehBrandMapper.insertVehBrand(vehBrand);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ�����ܻᷢ��NullPointException����try...catch...
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	/**
	 * ��ӳ���Ʒ�ƣ�������
	 */
	public void addVehBrandList(List<VehBrand> brands) {
		SqlSession session = null;
		try {
			// ��ȡ������SqlSessionFactory
			SqlSessionFactory factory = SqlSessionFactoryLoader.getSingletonSqlSessionFactory();
			// ��ȡsqlSession
			session = factory.openSession(true);
			// ��ȡmapper����
			VehBrandMapper vehBrandMapper = session.getMapper(VehBrandMapper.class);
			// ��ѯ
			vehBrandMapper.insertVehBrandList(brands);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ�����ܻᷢ��NullPointException����try...catch...
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
