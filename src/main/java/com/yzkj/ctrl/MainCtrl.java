package com.yzkj.ctrl;

import com.yzkj.base.VehBrand;
import com.yzkj.service.VehBrandService;
import com.yzkj.service.impl.VehBrandServiceImpl;
import java.util.*;

public class MainCtrl {
	
	public static void main(String[] args) {
		// ͨ����ѯ����mybatis����Ƿ��ɹ�----ok
//		testQueryBrand();
		// ���Բ��뵥��Ʒ������----ok
//		testInsertBrand();
		// ������������Ʒ������
//		testBatchInsertBrand();
		
	}

	private static void testBatchInsertBrand() {
		VehBrandService vehBrandService = new VehBrandServiceImpl();
		List<VehBrand> vehBrands = new ArrayList<VehBrand>();
		for (int i = 0; i < 3; i++) {
			VehBrand brand = new VehBrand();
			brand.setName("Ʒ��" + i);
			brand.setType(i);
			vehBrands.add(brand);
		}
		vehBrandService.addVehBrandList(vehBrands);
	}

	private static void testInsertBrand() {
		VehBrandService vehBrandService = new VehBrandServiceImpl();
		VehBrand brand = new VehBrand();
		brand.setName("����");
		brand.setType(5);
		vehBrandService.addVehBrand(brand);
	}

	private static void testQueryBrand() {
		VehBrandService vehBrandService = new VehBrandServiceImpl();
		VehBrand brand = vehBrandService.getBrandInfoById(1);
		System.out.println(brand);
	}
	
	/**********************************���½�����ҵ����ȡ����֮������**********************************************/
	
	
	
	
}
