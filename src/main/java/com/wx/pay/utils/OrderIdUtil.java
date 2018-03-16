package com.wx.pay.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public final class OrderIdUtil {
	public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 生成一个唯一的订单号
	 * 
	 * @return
	 */
	public final static  String getOrderId() {
		String date = simpleDateFormat.format(new Date());
		Integer uuidHashCode = UUID.randomUUID().toString().hashCode();
		if (uuidHashCode < 0) {
			uuidHashCode = uuidHashCode * (-1);
		}
		return "0001" + date + uuidHashCode;
	}
}
