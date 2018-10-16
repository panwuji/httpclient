package com.yzkj.mapper;

import java.util.List;

import com.yzkj.base.VehBrand;
/**
 * ����Ʒ�Ƴ־ò����ӿ�----mapper����ƥ��ӳ���ļ�
 * @author panwuji
 *
 */
public interface VehBrandMapper {
	/**
	 * ����Ʒ��id��ѯƷ����Ϣ
	 * @param id
	 * @return
	 */
	VehBrand selectByBrandId(int id);
	/**
	 * ���복��Ʒ����Ϣ��������
	 * @param vehBrand
	 */
	void insertVehBrand(VehBrand vehBrand);
	/**
	 * ���복��Ʒ����Ϣ��������
	 * @param vehBrand
	 */
	void insertVehBrandList(List<VehBrand> brands);
}
