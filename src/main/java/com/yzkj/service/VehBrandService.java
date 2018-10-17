package com.yzkj.service;

import java.util.List;

import com.yzkj.base.VehBrand;
/**
 * 车辆品牌服务接口层
 * @author panwuji
 *
 */
public interface VehBrandService {
	/**
	 * 根据品牌id查询品牌信息（测试用）
	 * @param brandId
	 * @return
	 */
	VehBrand getBrandInfoById(int brandId);
	/**
	 * 添加车辆品牌信息
	 * @param vehBrand
	 */
	void addVehBrand(VehBrand vehBrand);
	/**
	 * 批量添加车辆品牌信息
	 * @param brands
	 */
	void addVehBrandList(List<VehBrand> brands);
	/**
	 * 查询所有品牌数据
	 * @return
	 */
	List<VehBrand> getAllVehBrand();
	/**
	 * 批量更新品牌数据
	 * @param list
	 */
	void updateBrandBatch(List<VehBrand> list);
}
