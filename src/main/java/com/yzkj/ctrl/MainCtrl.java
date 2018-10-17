package com.yzkj.ctrl;

import com.yzkj.base.VehBrand;
import com.yzkj.service.VehBrandService;
import com.yzkj.service.impl.VehBrandServiceImpl;

import com.yzkj.util.HTTPUtil;
import com.yzkj.util.JsoupUtil;

import java.util.*;

import org.apache.http.client.utils.HttpClientUtils;

public class MainCtrl {
	
	public static void main(String[] args) {
		// 通过查询测试mybatis框架是否搭建成功----ok
//		testQueryBrand();
		// 测试插入单条品牌数据----ok
//		testInsertBrand();
		// 测试批量插入品牌数据
//		testBatchInsertBrand();
		
//		grabAutHomeBrand();
		
		//填充品牌数据
		fillVehBrand();
	}

	private static void testBatchInsertBrand() {
		VehBrandService vehBrandService = new VehBrandServiceImpl();
		List<VehBrand> vehBrands = new ArrayList<VehBrand>();
		for (int i = 0; i < 3; i++) {
			VehBrand brand = new VehBrand();
			brand.setName("品牌" + i);
			brand.setType(i);
			vehBrands.add(brand);
		}
		vehBrandService.addVehBrandList(vehBrands);
	}

	private static void testInsertBrand() {
		VehBrandService vehBrandService = new VehBrandServiceImpl();
		VehBrand brand = new VehBrand();
		brand.setName("宝马");
		brand.setType(5);
		vehBrandService.addVehBrand(brand);
	}

	private static void testQueryBrand() {
		VehBrandService vehBrandService = new VehBrandServiceImpl();
		VehBrand brand = vehBrandService.getBrandInfoById(1);
		System.out.println(brand);
	}
	
	/**********************************以下进入主业务，爬取汽车之家数据**********************************************/
	
	/**
	 * //获取品牌数据
	 */
	private static void grabAutHomeBrand() {
		String str = HTTPUtil.HTTPGet("https://car.autohome.com.cn/AsLeftMenu/As_LeftListNew.ashx?typeId=1%20&amp;brandId=0%20&amp;fctId=0%20&amp;seriesId=0");
		List<VehBrand> brands = JsoupUtil.getVehBrand3(str);
		VehBrandService vehBrandService = new VehBrandServiceImpl();
		vehBrandService.addVehBrandList(brands);
		
	}
	
	/**
	 * 完善品牌数据
	 */
	public static void fillVehBrand(){
		// 查询数据库
		VehBrandService vehBrandService = new VehBrandServiceImpl();
		List<VehBrand> vehBrands = vehBrandService.getAllVehBrand();
		// 待插入集合
		List<VehBrand> toUpdateList = new ArrayList<VehBrand>();
		// 遍历、访问
		for (int i = 0; i < vehBrands.size(); i++) {
			VehBrand vehBrand = vehBrands.get(i);
			String serieLinkUrl = vehBrand.getSerieLinkUrl();
			// 抓取数据
			String result = HTTPUtil.HTTPGet(serieLinkUrl);
			// 解析
			vehBrand = JsoupUtil.fillBrandParse(vehBrand, result);
			// 更新vehBrand
			toUpdateList.add(vehBrand);
		}
//		System.out.println("待更新集合数据：" + toUpdateList);
		
		// 批量更新
		vehBrandService.updateBrandBatch(toUpdateList);
	}
	
	
}
