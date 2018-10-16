package com.yzkj.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
}
