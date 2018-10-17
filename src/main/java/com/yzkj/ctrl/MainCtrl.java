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
		// ͨ����ѯ����mybatis����Ƿ��ɹ�----ok
//		testQueryBrand();
		// ���Բ��뵥��Ʒ������----ok
//		testInsertBrand();
		// ������������Ʒ������
//		testBatchInsertBrand();
		
//		grabAutHomeBrand();
		
		//���Ʒ������
		fillVehBrand();
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
	
	/**
	 * //��ȡƷ������
	 */
	private static void grabAutHomeBrand() {
		String str = HTTPUtil.HTTPGet("https://car.autohome.com.cn/AsLeftMenu/As_LeftListNew.ashx?typeId=1%20&amp;brandId=0%20&amp;fctId=0%20&amp;seriesId=0");
		List<VehBrand> brands = JsoupUtil.getVehBrand3(str);
		VehBrandService vehBrandService = new VehBrandServiceImpl();
		vehBrandService.addVehBrandList(brands);
		
	}
	
	/**
	 * ����Ʒ������
	 */
	public static void fillVehBrand(){
		// ��ѯ���ݿ�
		VehBrandService vehBrandService = new VehBrandServiceImpl();
		List<VehBrand> vehBrands = vehBrandService.getAllVehBrand();
		// �����뼯��
		List<VehBrand> toUpdateList = new ArrayList<VehBrand>();
		// ����������
		for (int i = 0; i < vehBrands.size(); i++) {
			VehBrand vehBrand = vehBrands.get(i);
			String serieLinkUrl = vehBrand.getSerieLinkUrl();
			// ץȡ����
			String result = HTTPUtil.HTTPGet(serieLinkUrl);
			// ����
			vehBrand = JsoupUtil.fillBrandParse(vehBrand, result);
			// ����vehBrand
			toUpdateList.add(vehBrand);
		}
//		System.out.println("�����¼������ݣ�" + toUpdateList);
		
		// ��������
		vehBrandService.updateBrandBatch(toUpdateList);
	}
	
	
}
