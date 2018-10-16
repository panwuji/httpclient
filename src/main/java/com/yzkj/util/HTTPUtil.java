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
		// ����HttpClientʵ��
		CloseableHttpClient client = HttpClients.createDefault();
		// ����HttpGetʵ��,��Щurl��Ӧ�ķ�����ж������Ƿ��������������,��������ؾ�,���Ҫ������ϢͷUser-Agent��ģ�����������
		HttpGet httpGet = new HttpGet(url);
		// ����HttpHost����
		HttpHost httpHost = new HttpHost("221.222.30.253", 8118);
		// ����ip�������ӳ�ʱʱ�䡢����ʱʱ��
//		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(100000).setSocketTimeout(50000).setProxy(httpHost).build();
//		httpGet.setConfig(requestConfig);

		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		// ����response
		CloseableHttpResponse response = null;
		try {
			// �������ӣ�ִ��get����
			response = client.execute(httpGet);
		} catch (ClientProtocolException e) {
			// httpЭ���쳣
			e.printStackTrace();
		} catch (IOException e) {
			// io�쳣
			e.printStackTrace();
		}
		// ��ȡ��Ӧ״̬����������200��������������500���������ڲ�����404���Ҳ�����Դ��403����Щ�������з��ɼ���������Ƶ���Ĳɼ����ݣ��򷵻�403�ܾ�������
		System.out.println("��Ӧ״̬Status��" + response.getStatusLine().getStatusCode());
		// ��ȡ����ʵ��
		HttpEntity entity = response.getEntity();
		PrintWriter writer = null;
		try {
			// ��ȡ��Ӧ����text/html; charset=gb2312
			System.out.println("��Ӧ����Content-Type��" + entity.getContentType().getValue());
			// ָ�������ӡ��ҳ���ݣ�������jsoup����ȡ����ҳ���ݽ��д���jsoup����������API�����ǿ�����jsһ����ȡ��ǩ�����ԡ�ֵ...��
			String grabResult = EntityUtils.toString(entity, "gbk");
			// �����ָ���ļ�
//			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("./webpage.txt")), "utf-8"));
//			writer.println(grabResult);
			
			return grabResult;
		} catch (ParseException e) {
			// �����쳣
			e.printStackTrace();
		} catch (IOException e) {
			// io�쳣
			e.printStackTrace();
		} finally {
//			writer.close();
			// �ر������ͷ�ϵͳ��Դ
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
