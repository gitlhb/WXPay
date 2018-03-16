package com.wx.pay.entity.response;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.wx.pay.utils.XmlHelper;
@XStreamAlias("xml")
public class QueryOrderResponse implements Serializable{

	/**
	 * 
	 */
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
	@XStreamAlias("openid")
	@XStreamConverter(value = XmlHelper.class)
	private String openid;
	@XStreamAlias("is_subscribe")
	@XStreamConverter(value = XmlHelper.class)
	private String is_subscribe;
	@XStreamAlias("trade_type")
	@XStreamConverter(value = XmlHelper.class)
	private String trade_type;
	@XStreamAlias("bank_type")
	@XStreamConverter(value = XmlHelper.class)
	private String bank_type;
	@XStreamAlias("total_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String total_fee;
	@XStreamAlias("fee_type")
	@XStreamConverter(value = XmlHelper.class)
	private String fee_type;
	@XStreamAlias("transaction_id")
	@XStreamConverter(value = XmlHelper.class)
	private String transaction_id;
	@XStreamAlias("out_trade_no")
	@XStreamConverter(value = XmlHelper.class)
	private String out_trade_no;
	@XStreamAlias("attach")
	@XStreamConverter(value = XmlHelper.class)
	private String attach;
	@XStreamAlias("time_end")
	@XStreamConverter(value = XmlHelper.class)
	private String time_end;
	@XStreamAlias("trade_state")
	@XStreamConverter(value = XmlHelper.class)
	private String trade_state;
	@XStreamAlias("cash_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String cash_fee;
	@XStreamAlias("trade_state_desc")
	@XStreamConverter(value = XmlHelper.class)
	private String trade_state_desc;
	
	
	
	
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
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getIs_subscribe() {
		return is_subscribe;
	}
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getBank_type() {
		return bank_type;
	}
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	public String getTrade_state() {
		return trade_state;
	}
	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}
	public String getCash_fee() {
		return cash_fee;
	}
	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}
	public String getTrade_state_desc() {
		return trade_state_desc;
	}
	public void setTrade_state_desc(String trade_state_desc) {
		this.trade_state_desc = trade_state_desc;
	}
	
	

}
