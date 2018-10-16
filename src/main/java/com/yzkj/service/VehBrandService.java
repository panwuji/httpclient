package com.yzkj.service;

import java.util.List;

import com.yzkj.base.VehBrand;
/**
 * ����Ʒ�Ʒ���ӿڲ�
 * @author panwuji
 *
 */
public interface VehBrandService {
	/**
	 * ����Ʒ��id��ѯƷ����Ϣ�������ã�
	 * @param brandId
	 * @return
	 */
	VehBrand getBrandInfoById(int brandId);
	/**
	 * ��ӳ���Ʒ����Ϣ
	 * @param vehBrand
	 */
	void addVehBrand(VehBrand vehBrand);
	/**
	 * ������ӳ���Ʒ����Ϣ
	 * @param brands
	 */
	void addVehBrandList(List<VehBrand> brands);
}
