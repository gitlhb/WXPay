package com.wx.pay.entity.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class GetPayStatusRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderNo;

	public String getOrderNo() {
		return orderNo;
	}

	@XmlElement(name = "orderNo")
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "GetPayStatusRequest [orderNo=" + orderNo + "]";
	}

}
