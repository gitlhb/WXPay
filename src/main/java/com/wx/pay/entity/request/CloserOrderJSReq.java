package com.wx.pay.entity.request;

import java.io.Serializable;

/**
 * js请求网页的关闭订单入参
 * 
 * @author liuhongbing
 *
 */

public class CloserOrderJSReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderNo;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}
