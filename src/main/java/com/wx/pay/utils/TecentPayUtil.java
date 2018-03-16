package com.wx.pay.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import com.wx.pay.entity.request.NoticeOfPaymentResultsRequest;
import com.wx.pay.entity.response.RefundResponse;

/**
 * 微信支付处理类
 * 
 * @author liuhongbing
 *
 */
public final class TecentPayUtil {

	/**
	 * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 * 
	 * @param characterEncoding
	 *            字符编码
	 * @param packageParams
	 *            参数
	 * @param API_KEY
	 *            签名的密钥
	 * @return 签名是否正确
	 */
	public static boolean isTenpaySign(String characterEncoding, SortedMap<Object, Object> packageParams,
			String API_KEY) {
		StringBuffer sb = new StringBuffer();
		Set<?> es = packageParams.entrySet();
		Iterator<?> it = es.iterator();
		while (it.hasNext()) {
			@SuppressWarnings("unchecked")
			Entry<Object, Object> entry = (Entry<Object, Object>) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (!"sign".equals(k) && null != v && !"".equals(v)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + API_KEY);
		System.out.println("待签名的字符串:" + sb.toString());
		// 算出摘要
		String mysign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toLowerCase();
		String tenpaySign = ((String) packageParams.get("sign")).toLowerCase();
		return Objects.equals(mysign, tenpaySign);
	}

	/**
	 * 获取签名
	 * 
	 * @param characterEncoding
	 *            字符编码
	 * @param packageParams
	 *            参数
	 * @param API_KEY
	 *            算签名的密钥
	 * @return 签名
	 */
	public static String createSign(String characterEncoding, SortedMap<Object, Object> packageParams, String API_KEY) {
		StringBuffer sb = new StringBuffer();
		@SuppressWarnings("rawtypes")
		Set es = packageParams.entrySet();
		@SuppressWarnings("rawtypes")
		Iterator it = es.iterator();
		while (it.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey().toString();
			String v = (String) entry.getValue().toString();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + API_KEY);
		System.out.println("sign:" + sb.toString());
		String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
		return sign;
	}

	/**
	 * 取出一个指定长度大小的随机正整数.
	 * 
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}

	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * 
	 * @return String 当前时间
	 */
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}

	/**
	 * 获取随机字符
	 * 
	 * @return 随机字符
	 */
	public synchronized static String getNonce_str() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String bg = outFormat.format(now);
		bg.substring(8, bg.length());
		String end = String.valueOf(buildRandom(4));
		return bg + end;
	}

	/**
	 * 获取随机字符串
	 * 
	 * @return
	 */
	public static String getNonceStr() {
		StringBuffer sb = new StringBuffer();
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 16; i++) {
			int index = new Random().nextInt(str.length());
			sb.append(str.charAt(index));
		}
		return sb.toString();
	}

	/**
	 * 获取当前请求的客户端IP
	 * 
	 * @param request
	 *            请求的Serverlet
	 * @return IP地址
	 */
	public static String getIpAddr(final HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	/**
	 * 验证支付结果通知的签名
	 * 
	 * @param xml
	 *            微信服务器传送的xml
	 * @return 签名是否正确
	 */
	public static Boolean checkSignNoticePaymentResults(NoticeOfPaymentResultsRequest xml) {
		SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
		/*Set<Entry<Object,Object>> entrySet = packageParams.entrySet();
		for (Iterator<Entry<Object, Object>> iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<Object, Object> entry = (Entry<Object, Object>) iterator.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}*/
		
		
		if (!Objects.equals(null, xml.getAppid())) {
			packageParams.put("appid", xml.getAppid());
		}
		if (!Objects.equals(null, xml.getMch_id())) {
			packageParams.put("mch_id", xml.getMch_id());
		}
		if (!Objects.equals(null, xml.getNonce_str())) {
			packageParams.put("nonce_str", xml.getNonce_str());
		}
		if (!Objects.equals(null, xml.getSign())) {
			packageParams.put("sign", xml.getSign());
		}
		if (!Objects.equals(null, xml.getResult_code())) {
			packageParams.put("result_code", xml.getResult_code());
		}
		if (!Objects.equals(null, xml.getErr_code())) {
			packageParams.put("err_code", xml.getErr_code());
		}
		if (!Objects.equals(null, xml.getOpenid())) {
			packageParams.put("openid", xml.getOpenid());
		}
		if (!Objects.equals(null, xml.getTrade_type())) {
			packageParams.put("trade_type", xml.getTrade_type());
		}
		if (!Objects.equals(null, xml.getBank_type())) {
			packageParams.put("bank_type", xml.getBank_type());
		}
		if (!Objects.equals(null, xml.getTotal_fee())) {
			packageParams.put("total_fee", xml.getTotal_fee());
		}
		if (!Objects.equals(null, xml.getSettlement_total_fee())) {
			packageParams.put("settlement_total_fee", xml.getSettlement_total_fee());
		}
		if (!Objects.equals(null, xml.getFee_type())) {
			packageParams.put("fee_type", xml.getFee_type());
		}
		if (!Objects.equals(null, xml.getCash_fee())) {
			packageParams.put("cash_fee", xml.getCash_fee());
		}
		if (!Objects.equals(null, xml.getCash_fee_type())) {
			packageParams.put("cash_fee_type", xml.getCash_fee_type());
		}
		if (!Objects.equals(null, xml.getTransaction_id())) {
			packageParams.put("transaction_id", xml.getTransaction_id());
		}
		if (!Objects.equals(null, xml.getOut_trade_no())) {
			packageParams.put("out_trade_no", xml.getOut_trade_no());
		}
		if (!Objects.equals(null, xml.getTime_end())) {
			packageParams.put("time_end", xml.getTime_end());
		}
		if (!Objects.equals(null, xml.getDevice_info())) {
			packageParams.put("device_info", xml.getDevice_info());
		}

		if (!Objects.equals(null, xml.getErr_code_des())) {
			packageParams.put("err_code_des", xml.getErr_code_des());
		}
		if (!Objects.equals(null, xml.getIs_subscribe())) {
			packageParams.put("is_subscribe", xml.getIs_subscribe());
		}
		if (!Objects.equals(null, xml.getCoupon_fee())) {
			packageParams.put("coupon_fee", xml.getCoupon_fee());
		}
		if (!Objects.equals(null, xml.getCoupon_count())) {
			packageParams.put("coupon_count", xml.getCoupon_count());
		}
		if (!Objects.equals(null, xml.getAttach())) {
			packageParams.put("attach", xml.getAttach());
		}
		if (!Objects.equals(null, xml.getReturn_code())) {
			packageParams.put("return_code", xml.getReturn_code());
		}
		if (!Objects.equals(null, xml.getReturn_msg())) {
			packageParams.put("return_msg", xml.getReturn_msg());
		}

		return TecentPayUtil.isTenpaySign("utf-8", packageParams, ConstantParam.MCH_KEY);
	}

	/**
	 * 检查微信退款签名的正确性
	 * 
	 * @param xml
	 *            微信退款返回的实体
	 * @return
	 */
	public static Boolean checkSignRefund(RefundResponse xml) {
		SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
		if (!Objects.equals(null, xml.getReturn_code())) {
			packageParams.put("return_code", xml.getReturn_code());
		}
		if (!Objects.equals(null, xml.getReturn_msg())) {
			packageParams.put("return_msg", xml.getReturn_msg());
		}
		if (!Objects.equals(null, xml.getResult_code())) {
			packageParams.put("result_code", xml.getResult_code());
		}
		if (!Objects.equals(null, xml.getErr_code())) {
			packageParams.put("err_code", xml.getErr_code());
		}
		if (!Objects.equals(null, xml.getErr_code_des())) {
			packageParams.put("err_code_des", xml.getErr_code_des());
		}
		if (!Objects.equals(null, xml.getErr_code_des())) {
			packageParams.put("err_code_des", xml.getErr_code_des());
		}
		if (!Objects.equals(null, xml.getAppid())) {
			packageParams.put("appid", xml.getAppid());
		}
		if (!Objects.equals(null, xml.getMch_id())) {
			packageParams.put("mch_id", xml.getMch_id());
		}
		if (!Objects.equals(null, xml.getNonce_str())) {
			packageParams.put("nonce_str", xml.getNonce_str());
		}
		if (!Objects.equals(null, xml.getSign())) {
			packageParams.put("sign", xml.getSign());
		}
		if (!Objects.equals(null, xml.getTransaction_id())) {
			packageParams.put("transaction_id", xml.getTransaction_id());
		}
		if (!Objects.equals(null, xml.getOut_trade_no())) {
			packageParams.put("out_trade_no", xml.getOut_trade_no());
		}
		if (!Objects.equals(null, xml.getOut_refund_no())) {
			packageParams.put("out_refund_no", xml.getOut_refund_no());
		}
		if (!Objects.equals(null, xml.getRefund_id())) {
			packageParams.put("refund_id", xml.getRefund_id());
		}
		if (!Objects.equals(null, xml.getRefund_fee())) {
			packageParams.put("refund_fee", xml.getRefund_fee());
		}
		if (!Objects.equals(null, xml.getSettlement_refund_fee())) {
			packageParams.put("settlement_refund_fee", xml.getSettlement_refund_fee());
		}
		if (!Objects.equals(null, xml.getTotal_fee())) {
			packageParams.put("total_fee", xml.getTotal_fee());
		}
		if (!Objects.equals(null, xml.getSettlement_total_fee())) {
			packageParams.put("settlement_total_fee ", xml.getSettlement_total_fee());
		}
		if (!Objects.equals(null, xml.getFee_type())) {
			packageParams.put("fee_type", xml.getFee_type());
		}
		if (!Objects.equals(null, xml.getCash_fee())) {
			packageParams.put("cash_fee", xml.getCash_fee());
		}
		if (!Objects.equals(null, xml.getCash_fee_type())) {
			packageParams.put("cash_fee_type", xml.getCash_fee_type());
		}
		if (!Objects.equals(null, xml.getCash_refund_fee())) {
			packageParams.put("cash_refund_fee", xml.getCash_refund_fee());
		}
		if (!Objects.equals(null, xml.getCoupon_refund_fee())) {
			packageParams.put("coupon_refund_fee", xml.getCoupon_refund_fee());
		}
		if (!Objects.equals(null, xml.getCoupon_refund_count())) {
			packageParams.put("coupon_refund_count", xml.getCoupon_refund_count());
		}
		return TecentPayUtil.isTenpaySign("utf-8", packageParams, ConstantParam.MCH_KEY);
	}

	public static void main(String[] args) {
		System.out.println(getNonceStr());
	}
}
