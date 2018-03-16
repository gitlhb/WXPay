package com.wx.pay.entity.response;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.wx.pay.utils.XmlHelper;

@XStreamAlias("xml")
public class UnifiedorderResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@XStreamAlias("return_code")
	@XStreamConverter(value = XmlHelper.class)
	private String return_code;

	@XStreamAlias("return_msg")
	@XStreamConverter(value = XmlHelper.class)
	private String return_msg;

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

	@XStreamAlias("result_code")
	@XStreamConverter(value = XmlHelper.class)
	private String result_code;

	@XStreamAlias("prepay_id")
	@XStreamConverter(value = XmlHelper.class)
	private String prepay_id;

	@XStreamAlias("trade_type")
	@XStreamConverter(value = XmlHelper.class)
	private String trade_type;

	@XStreamAlias("code_url")
	@XStreamConverter(value = XmlHelper.class)
	private String code_url;

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

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

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getPrepay_id() {
		return prepay_id;
	}

	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getCode_url() {
		return code_url;
	}

	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
