package com.wx.pay.entity.request;

import java.io.Serializable;

/**
 * ��ѯ΢�Ž��׶���
 * @author liuhongbing
 *
 */
public class QueryOrderJSReq implements Serializable{

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
