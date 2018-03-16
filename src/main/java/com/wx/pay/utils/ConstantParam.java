package com.wx.pay.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ΢�Ź��ںų���
 * 
 * @author liuhongbing
 *
 */
public class ConstantParam {
	public static Map<String, Integer> map = new ConcurrentHashMap<String,Integer>();
	public static final String APPID = "wx17db9e16a133e808";
	public static final String MCHID = "1366979202";
	public static final String MCH_KEY = "DFCC9DCA8ED7AA668E1DCC2996455191";
	public static final String NOTIFY_URL = "http://15w904t626.iask.in:24826/WXPay/payment";
	public static final String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	public static final String QUERY_ORDER = "https://api.mch.weixin.qq.com/pay/orderquery";
	public static final String CLOSE_ORDER = "https://api.mch.weixin.qq.com/pay/closeorder";
	public static final String REFUND = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	public static final String REFUND_QUERY = "https://api.mch.weixin.qq.com/pay/refundquery";

}
