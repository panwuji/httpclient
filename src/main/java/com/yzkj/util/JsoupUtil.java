package com.yzkj.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.yzkj.base.SerieModelMapper;
import com.yzkj.base.VehBrand;
import com.yzkj.base.VehModel;

public class JsoupUtil {
//	public static List<String> getVehBrand(String str){
//		System.out.println("开始解析......");
//		List<Brand> keyPair = new ArrayList<Brand>();
//		Document doc = Jsoup.parse(str);
//		Elements es = doc.select("ul a");
//		for (Element element : es) {
//			Brand brand = new Brand();
//			String html = element.html();
//			String brandStr = html.substring(html.indexOf("</i>") + 4, html.indexOf("<em>"));
//			String typeCount = element.select("em").get(0).text();
//			brand.setName(brandStr);
//			int totalchexing = Integer.valueOf(typeCount.substring(typeCount.indexOf("(") + 1, typeCount.indexOf(")")));//包含在售与停售
//			brand.setType(totalchexing);
//			keyPair.add(brand);
//			System.out.println(brandStr + "," + totalchexing);
//		}
//		System.out.println(keyPair);
//		System.out.println("结束解析......");
//		return null;
//	}
	
	public static List<String> getVehBrand2(String str){
		System.out.println("开始解析......");
		Document doc = Jsoup.parse(str);
		Elements es = doc.select("ul li");
		for (Element element : es) {
			String brandIdStr = element.attr("id");
			String brandUrl = brandIdStr.replace("b", "https://car.autohome.com.cn/price/brand-") + ".html";
			//遍历li下的i标签
			String html = element.select("a").get(0).html();
			
			String brandStr = html.substring(html.indexOf("</i>") + 4, html.indexOf("<em>"));
			String typeCount = element.select("em").get(0).text();
			int totalchexing = Integer.valueOf(typeCount.substring(typeCount.indexOf("(") + 1, typeCount.indexOf(")")));//包含在售/将售/停售
			System.out.println(brandUrl + "," + brandStr + "," + totalchexing);
		}
		System.out.println("结束解析......");
		return null;
	}
	
	public static List<VehBrand> getVehBrand3(String str){
		System.out.println("开始解析......");
		List<VehBrand> brands = new ArrayList<VehBrand>();
		Document doc = Jsoup.parse(str);
		Elements es = doc.select("ul li");
		for (Element element : es) {
			String brandIdStr = element.attr("id");
			String brandUrl = brandIdStr.replace("b", "https://car.autohome.com.cn/price/brand-") + ".html";
			//遍历li下的i标签
			String html = element.select("a").get(0).html();
			
			String brandStr = html.substring(html.indexOf("</i>") + 4, html.indexOf("<em>"));
			String typeCount = element.select("em").get(0).text();
			int totalchexing = Integer.valueOf(typeCount.substring(typeCount.indexOf("(") + 1, typeCount.indexOf(")")));//包含在售/将售/停售
			System.out.println(brandUrl + "," + brandStr + "," + totalchexing);
			
			VehBrand brand = new VehBrand();
			brand.setName(brandStr.replace("?", "·"));
			brand.setType(totalchexing);
			brand.setSerieLinkUrl(brandUrl);
			brands.add(brand);
		}
		System.out.println("结束解析......");
		return brands;
	}
	
	public static VehBrand fillBrandParse(VehBrand vehBrand, String html){
		System.out.println("开始解析......");
		Map<String, Object> result = new HashMap<String, Object>();
		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("div.tab-nav.border-t-no ul li a");
//		System.out.println("a标签：" + elements);
		for (Element element : elements) {
			String serieTabLink = element.attr("href");
			String type = element.text();
//			System.out.println(serieTabLink + "," + type);
			if("在售".equals(type)){
				vehBrand.setOnSaleLinkUrl("https://car.autohome.com.cn" + serieTabLink);
			} else if("停售".equals(type)){
				vehBrand.setOffSaleLinkUrl("https://car.autohome.com.cn" + serieTabLink);
			} else if("即将销售".equals(type)){
				vehBrand.setWillSaleLinkUrl("https://car.autohome.com.cn" + serieTabLink);
			}
		}
//		System.out.println("结束解析......" + vehBrand);
		return vehBrand;
	}
	
	public static List<SerieModelMapper> parseVehSerie(String html){
		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("div.tab-nav.border-t-no ~ div.tab-content.fn-visible div.list-cont");
		
		// 返回结果集合
		List<SerieModelMapper> resultList = new ArrayList<SerieModelMapper>();
		
		for (Element e : elements) {
			Element a = e.select("div.main-title a").get(0);
			String vehSerie = a.text();
			
			SerieModelMapper serieModelMapper = new SerieModelMapper();
			serieModelMapper.setSerieName(vehSerie);
			
			Element modelDiv = e.nextElementSibling();
			if(modelDiv!=null){
				Elements lis = modelDiv.select("ul.interval01-list li");
				
				List<String> models = new ArrayList<String>();
				
				for(int i = 0; i<lis.size();i++){
					String modelName = lis.get(i).select("div").eq(0).select("p a").text();
					models.add(modelName);
				}
				serieModelMapper.setModelList(models);
			}
			
			resultList.add(serieModelMapper);
		}
		
		return resultList;
	}
	
}
