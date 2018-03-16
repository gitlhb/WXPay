package com.wx.pay.entity.request;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.wx.pay.utils.XmlHelper;

/**
 * 发送退款请求给微信
 * 
 * @author liuhongbing
 *
 */
@XStreamAlias("xml")
public class RefundRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XStreamAlias("appid")
	@XStreamConverter(value = XmlHelper.class)
	private String appid;
	@XStreamAlias("mch_id")
	@XStreamConverter(value = XmlHelper.class)
	private String mch_id;
	@XStreamAlias("nonce_str")
	@XStreamConverter(value = XmlHelper.class)
	private String nonce_str;
	@XStreamAlias("sign")
	@XStreamConverter(value = XmlHelper.class)
	private String sign;
	@XStreamAlias("out_trade_no")
	@XStreamConverter(value = XmlHelper.class)
	private String out_trade_no;
	@XStreamAlias("out_refund_no")
	@XStreamConverter(value = XmlHelper.class)
	private String out_refund_no;
	@XStreamAlias("total_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String total_fee;
	@XStreamAlias("refund_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String refund_fee;
	@XStreamAlias("transaction_id")
	@XStreamConverter(value = XmlHelper.class)
	private String transaction_id;
	
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getOut_refund_no() {
		return out_refund_no;
	}
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getRefund_fee() {
		return refund_fee;
	}
	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}
	
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	@Override
	public String toString() {
		return "RefundRequest [appid=" + appid + ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", sign=" + sign
				+ ", out_trade_no=" + out_trade_no + ", out_refund_no=" + out_refund_no + ", total_fee=" + total_fee
				+ ", refund_fee=" + refund_fee + "]";
	}
	
}
