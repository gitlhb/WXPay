package com.wx.pay.entity.request;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.wx.pay.utils.XmlHelper;

@XStreamAlias("xml")
public class UnifiedorderRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@XStreamAlias("appid")
	@XStreamConverter(value = XmlHelper.class)
	private String appid;

	@XStreamAlias("out_trade_no")
	@XStreamConverter(value = XmlHelper.class)
	private String out_trade_no;
	
	@XStreamAlias("body")
	@XStreamConverter(value = XmlHelper.class)
	private String body;

	@XStreamAlias("total_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String total_fee;

	@XStreamAlias("notify_url")
	@XStreamConverter(value = XmlHelper.class)
	private String notify_url;

	@XStreamAlias("trade_type")
	@XStreamConverter(value = XmlHelper.class)
	private String trade_type;

	@XStreamAlias("mch_id")
	@XStreamConverter(value = XmlHelper.class)
	private String mch_id;

	@XStreamAlias("spbill_create_ip")
	@XStreamConverter(value = XmlHelper.class)
	private String spbill_create_ip;

	@XStreamAlias("nonce_str")
	@XStreamConverter(value = XmlHelper.class)
	private String nonce_str;

	@XStreamAlias("product_id")
	@XStreamConverter(value = XmlHelper.class)
	private String product_id;

	@XStreamAlias("sign")
	@XStreamConverter(value = XmlHelper.class)
	private String sign;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	

}
