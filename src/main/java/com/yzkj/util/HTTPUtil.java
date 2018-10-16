package com.yzkj.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HTTPUtil {
	
	public static String HTTPGet(String url) {
		// 创建HttpClient实例
		CloseableHttpClient client = HttpClients.createDefault();
		// 创建HttpGet实例,有些url对应的服务会判断请求是否是浏览器发出的,若不是则回绝,因此要设置消息头User-Agent来模拟浏览器请求
		HttpGet httpGet = new HttpGet(url);
		// 创建HttpHost代理
		HttpHost httpHost = new HttpHost("221.222.30.253", 8118);
		// 设置ip代理、连接超时时间、请求超时时间
//		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(100000).setSocketTimeout(50000).setProxy(httpHost).build();
//		httpGet.setConfig(requestConfig);

		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		// 声明response
		CloseableHttpResponse response = null;
		try {
			// 建立连接，执行get请求
			response = client.execute(httpGet);
		} catch (ClientProtocolException e) {
			// http协议异常
			e.printStackTrace();
		} catch (IOException e) {
			// io异常
			e.printStackTrace();
		}
		// 获取响应状态（常见的有200：服务器正常；500：服务期内部错误；404：找不到资源；403：有些服务器有防采集，假如你频繁的采集数据，则返回403拒绝你请求）
		System.out.println("响应状态Status：" + response.getStatusLine().getStatusCode());
		// 获取返回实体
		HttpEntity entity = response.getEntity();
		PrintWriter writer = null;
		try {
			// 获取响应类型text/html; charset=gb2312
			System.out.println("响应类型Content-Type：" + entity.getContentType().getValue());
			// 指定编码打印网页内容，可利用jsoup对爬取的网页数据进行处理（jsoup：利用它的API让我们可以像js一样获取标签、属性、值...）
			String grabResult = EntityUtils.toString(entity, "gbk");
			// 输出到指定文件
//			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("./webpage.txt")), "utf-8"));
//			writer.println(grabResult);
			
			return grabResult;
		} catch (ParseException e) {
			// 解析异常
			e.printStackTrace();
		} catch (IOException e) {
			// io异常
			e.printStackTrace();
		} finally {
//			writer.close();
			// 关闭流和释放系统资源
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		HTTPGet("https://car.autohome.com.cn/#pvareaid=3311273");
	}
}
