package com.wx.pay.entity.request;

import java.io.Serializable;

public class QueryRefundJsonRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderNo;
	private String refund_id;
	private String out_refund_no;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getRefund_id() {
		return refund_id;
	}
	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}
	public String getOut_refund_no() {
		return out_refund_no;
	}
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}
	@Override
	public String toString() {
		return "QueryRefundJsonRequest [orderNo=" + orderNo + ", refund_id=" + refund_id + ", out_refund_no="
				+ out_refund_no + "]";
	}
	
}
