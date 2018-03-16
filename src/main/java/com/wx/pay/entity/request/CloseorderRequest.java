package com.wx.pay.entity.request;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.wx.pay.utils.XmlHelper;

/**
 * 关闭订单功能
 * 
 * @author liuhongbing
 *
 */
@XStreamAlias("xml")
public class CloseorderRequest implements Serializable {

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
	@XStreamAlias("out_trade_no")
	@XStreamConverter(value = XmlHelper.class)
	private String out_trade_no;
	@XStreamAlias("nonce_str")
	@XStreamConverter(value = XmlHelper.class)
	private String nonce_str;
	@XStreamAlias("sign")
	@XStreamConverter(value = XmlHelper.class)
	private String sign;

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

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
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

}
