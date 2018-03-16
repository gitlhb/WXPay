package com.wx.pay.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;

import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

/**
 * Http������
 * 
 * @author liuhongbing
 *
 */
public class HttpHelper {

	/**
	 * ����HttpPost����
	 * 
	 * @param url
	 *            �����ַ
	 * @param body
	 *            ��Ϣ��
	 * @param header
	 *            ��Ϣͷ
	 * @return ��Ӧ
	 * @throws Exception
	 * @throws ClientProtocolException
	 */
	public static String sendHttpPost(String url, String body, Map<String, String> header)
			throws ClientProtocolException, Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		StringEntity entity = new StringEntity(body, Charset.forName("UTF-8"));
		entity.setContentEncoding("UTF-8");
		entity.setContentType("text/xml");
		post.setEntity(entity);
		if (header != null && !header.keySet().isEmpty()) {
			Set<Entry<String, String>> entrySet = header.entrySet();
			for (Iterator<Entry<String, String>> iterator = entrySet.iterator(); iterator.hasNext();) {
				Entry<String, String> entry = (Entry<String, String>) iterator.next();
				post.setHeader(entry.getKey(), entry.getValue());
			}
		}
		HttpResponse httpResponse = httpClient.execute(post);
		String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		post.releaseConnection();
		return response;

	}

	/**
	 * Http����Get����
	 * 
	 * @param url
	 *            �����url
	 * @param header
	 *            ����ͷ
	 * @return Get��Ӧ
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String sendHttpGet(String url, Map<String, String> header)
			throws ClientProtocolException, IOException {
		String result = "";
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(url);
		if (header != null && !header.keySet().isEmpty()) {
			Set<Entry<String, String>> entrySet = header.entrySet();
			for (Iterator<Entry<String, String>> iterator = entrySet.iterator(); iterator.hasNext();) {
				Entry<String, String> entry = (Entry<String, String>) iterator.next();
				get.setHeader(entry.getKey(), entry.getValue());
			}
		}
		HttpResponse response = httpClient.execute(get);
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			result = EntityUtils.toString(response.getEntity(), "utf-8");
		}
		get.releaseConnection();
		return result;
	}

	/**
	 * ��΢�ŷ���������HTTPS����
	 * 
	 * @param url
	 *            �����Url
	 * @param body
	 *            ������Ϣ
	 * @return ��Ӧ��Ϣ
	 * @throws Exception
	 */
	public static String sendTecentHttpsPost(String url, String body) throws Exception {
		String filePath = "E:\\֤��\\΢ҽ����ȫ�����з�\\apiclient_cert.p12";
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		FileInputStream in = new FileInputStream(new File(filePath));
		try {
			keyStore.load(in, ConstantParam.MCHID.toCharArray());
		} finally {
			if (in != null) {
				in.close();
			}
		}
		SSLContext context = SSLContexts.custom().loadKeyMaterial(keyStore, ConstantParam.MCHID.toCharArray()).build();
		@SuppressWarnings("deprecation")
		SSLConnectionSocketFactory sslcsf = new SSLConnectionSocketFactory(context, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslcsf).build();
		HttpPost httpost = new HttpPost(url);
		httpost.setEntity(new StringEntity(body, "UTF-8"));
		HttpResponse weixinResponse = httpClient.execute(httpost);
		String re = EntityUtils.toString(weixinResponse.getEntity(), "UTF-8");
		return re;
	}
}
