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
 * 1.����Apache HttpClient����http Get����
 * 2.������ϢͷUser-Agent���������ģ�⣨������Ϣͷ����������ã�����setHeader(key,value)��
 * 3.��ȡ��Ӧ����Content-Type
 * 4.��ȡ��Ӧ״̬Status
 * 5.ʹ�ô���IP��ֹ����������IP������ȡ��ҳ��ʱ���е�Ŀ��վ���з�������ƣ�����Ƶ������վ���Լ������Է���վ�����Ϊ����ɼ�����IP��ʩ����ʱ�򣬴���IP�������ó��ˣ�
 * 6.Http���ӳ�ʱ��Http��ȡ��ʱ
 * 
 * @author panwuji
 *
 */
public class HttpClientDemo {

	private static void httpGet() {
		// ����HttpClientʵ��
		CloseableHttpClient client = HttpClients.createDefault();
		// ����HttpGetʵ��
//		HttpGet httpGet = new HttpGet("http://www.open1111.com/");
		HttpGet httpGet = new HttpGet("http://www.tuicool.com/");// ��Щurl��Ӧ�ķ�����ж������Ƿ�������������ģ���������ؾ������Ҫ������ϢͷUser-Agent��ģ�����������
		
		// ����HttpHost����
		HttpHost httpHost = new HttpHost("221.122.91.59",80);
		// ����ip�������ӳ�ʱʱ�䡢����ʱʱ��
		RequestConfig requestConfig = RequestConfig.custom().setProxy(httpHost).setConnectTimeout(5000).setSocketTimeout(5000).build();
		httpGet.setConfig(requestConfig);
		
		httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		// ����response
		CloseableHttpResponse response = null;

		try {
			// �������ӣ�ִ��get����
			response = client.execute(httpGet);
			// httpЭ���쳣
		} catch (ClientProtocolException e) { 
			e.printStackTrace();
			// io�쳣
		} catch (IOException e) { 
			e.printStackTrace();
		}
		// ��ȡ��Ӧ״̬����������200��������������500���������ڲ�����404���Ҳ�����Դ��403����Щ�������з��ɼ���������Ƶ���Ĳɼ����ݣ��򷵻�403 �ܾ�������
		System.out.println("��Ӧ״̬Status��" + response.getStatusLine().getStatusCode());
		// ��ȡ����ʵ��
		HttpEntity entity = response.getEntity(); 

		try {
			// ָ�������ӡ��ҳ���ݣ�������jsoup����ȡ����ҳ���ݽ��д���jsoup����������API�����ǿ�����jsһ����ȡ��ǩ�����ԡ�ֵ...��
			System.out.println("��ҳ���ݣ�" + EntityUtils.toString(entity, "utf-8"));
			// ��ȡ��Ӧ����
			System.out.println("��Ӧ����Content-Type��" + entity.getContentType().getValue());
			// �����쳣
		} catch (ParseException e) { 
			e.printStackTrace();
			// io�쳣
		} catch (IOException e) { 
			e.printStackTrace();
		} 
		try {
			// �ر������ͷ�ϵͳ��Դ
			response.close();
			// io�쳣
		} catch (IOException e) { 
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		httpGet();
	}
}
