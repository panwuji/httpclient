package cn.yzkj.httpclient;

import java.io.IOException;

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

/**
 * 1.利用Apache HttpClient进行http Get访问
 * 2.设置消息头User-Agent进行浏览器模拟（其他消息头亦是如此设置，形如setHeader(key,value)）
 * 3.获取响应类型Content-Type
 * 4.获取响应状态Status
 * 5.使用代理IP防止服务器屏蔽IP（在爬取网页的时候，有的目标站点有反爬虫机制，对于频繁访问站点以及规则性访问站点的行为，会采集屏蔽IP措施。这时候，代理IP就派上用场了）
 * 6.Http连接超时、Http读取超时
 * 
 * @author panwuji
 *
 */
public class HttpClientDemo {

	private static void httpGet() {
		// 创建HttpClient实例
		CloseableHttpClient client = HttpClients.createDefault();
		// 创建HttpGet实例
//		HttpGet httpGet = new HttpGet("http://www.open1111.com/");
		HttpGet httpGet = new HttpGet("http://www.tuicool.com/");// 有些url对应的服务会判断请求是否是浏览器发出的，若不是则回绝，因此要设置消息头User-Agent来模拟浏览器请求
		
		// 创建HttpHost代理
		HttpHost httpHost = new HttpHost("221.122.91.59",80);
		// 设置ip代理、连接超时时间、请求超时时间
		RequestConfig requestConfig = RequestConfig.custom().setProxy(httpHost).setConnectTimeout(5000).setSocketTimeout(5000).build();
		httpGet.setConfig(requestConfig);
		
		httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		// 声明response
		CloseableHttpResponse response = null;

		try {
			// 建立连接，执行get请求
			response = client.execute(httpGet);
			// http协议异常
		} catch (ClientProtocolException e) { 
			e.printStackTrace();
			// io异常
		} catch (IOException e) { 
			e.printStackTrace();
		}
		// 获取响应状态（常见的有200：服务器正常；500：服务期内部错误；404：找不到资源；403：有些服务器有防采集，假如你频繁的采集数据，则返回403 拒绝你请求）
		System.out.println("响应状态Status：" + response.getStatusLine().getStatusCode());
		// 获取返回实体
		HttpEntity entity = response.getEntity(); 

		try {
			// 指定编码打印网页内容，可利用jsoup对爬取的网页数据进行处理（jsoup：利用它的API让我们可以像js一样获取标签、属性、值...）
			System.out.println("网页内容：" + EntityUtils.toString(entity, "utf-8"));
			// 获取响应类型
			System.out.println("响应类型Content-Type：" + entity.getContentType().getValue());
			// 解析异常
		} catch (ParseException e) { 
			e.printStackTrace();
			// io异常
		} catch (IOException e) { 
			e.printStackTrace();
		} 
		try {
			// 关闭流和释放系统资源
			response.close();
			// io异常
		} catch (IOException e) { 
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		httpGet();
	}
}
