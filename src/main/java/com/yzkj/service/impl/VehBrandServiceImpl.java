package com.yzkj.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yzkj.base.VehBrand;
import com.yzkj.mapper.VehBrandMapper;
import com.yzkj.service.SqlSessionFactoryLoader;
import com.yzkj.service.VehBrandService;
/**
 * 车辆品牌服务接口实现
 * @author panwuji
 *
 */
public class VehBrandServiceImpl implements VehBrandService {
	/**
	 * 根据品牌id查询品牌信息（测试用）
	 */
	public VehBrand getBrandInfoById(int brandId) {
		SqlSession session = null;
		try {
			// 获取单例的SqlSessionFactory
			SqlSessionFactory factory = SqlSessionFactoryLoader.getSingletonSqlSessionFactory();
			// 获取sqlSession
			session = factory.openSession(true);
			// 获取mapper对象
			VehBrandMapper vehBrandMapper = session.getMapper(VehBrandMapper.class);
			// 查询
			VehBrand brand = vehBrandMapper.selectByBrandId(brandId);
			// 返回
			return brand;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源，可能会发生NullPointException，故try...catch...
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 添加车辆品牌（单个）
	 */
	public void addVehBrand(VehBrand vehBrand) {
		SqlSession session = null;
		try {
			// 获取单例的SqlSessionFactory
			SqlSessionFactory factory = SqlSessionFactoryLoader.getSingletonSqlSessionFactory();
			// 获取sqlSession
			session = factory.openSession(true);
			// 获取mapper对象
			VehBrandMapper vehBrandMapper = session.getMapper(VehBrandMapper.class);
			// 查询
			vehBrandMapper.insertVehBrand(vehBrand);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源，可能会发生NullPointException，故try...catch...
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	/**
	 * 添加车辆品牌（批量）
	 */
	public void addVehBrandList(List<VehBrand> brands) {
		SqlSession session = null;
		try {
			// 获取单例的SqlSessionFactory
			SqlSessionFactory factory = SqlSessionFactoryLoader.getSingletonSqlSessionFactory();
			// 获取sqlSession
			session = factory.openSession(true);
			// 获取mapper对象
			VehBrandMapper vehBrandMapper = session.getMapper(VehBrandMapper.class);
			// 查询
			vehBrandMapper.insertVehBrandList(brands);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源，可能会发生NullPointException，故try...catch...
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
