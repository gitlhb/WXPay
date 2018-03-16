package com.wx.pay.utils;

/**
 * 微信支付方式枚举
 * 
 * @author liuhongbing
 *
 */
public enum TecentPayEnum {
	/**
	 * 公众号支付
	 */
	JSAPI,
	/**
	 * 原生扫码支付
	 */
	NATIVE,
	/**
	 * app支付，统一下单接口trade_type的传参可参考这里
	 */
	APP,
	/**
	 * 刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口
	 */
	MICROPAY
}
