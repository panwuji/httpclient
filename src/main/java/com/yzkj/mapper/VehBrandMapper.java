package com.yzkj.mapper;

import java.util.List;

import com.yzkj.base.VehBrand;
/**
 * 车辆品牌持久层服务接口----mapper对象，匹配映射文件
 * @author panwuji
 *
 */
public interface VehBrandMapper {
	/**
	 * 根据品牌id查询品牌信息
	 * @param id
	 * @return
	 */
	VehBrand selectByBrandId(int id);
	/**
	 * 插入车辆品牌信息（单个）
	 * @param vehBrand
	 */
	void insertVehBrand(VehBrand vehBrand);
	/**
	 * 插入车辆品牌信息（批量）
	 * @param vehBrand
	 */
	void insertVehBrandList(List<VehBrand> brands);
}
