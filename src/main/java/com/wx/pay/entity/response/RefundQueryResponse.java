package com.wx.pay.entity.response;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.wx.pay.utils.XmlHelper;

@XStreamAlias("xml")
public class RefundQueryResponse implements Serializable {

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
	@XStreamAlias("result_code")
	@XStreamConverter(value = XmlHelper.class)
	private String result_code;
	@XStreamAlias("err_code")
	@XStreamConverter(value = XmlHelper.class)
	private String err_code;
	@XStreamAlias("err_code_des")
	@XStreamConverter(value = XmlHelper.class)
	private String err_code_des;
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
	@XStreamAlias("transaction_id")
	@XStreamConverter(value = XmlHelper.class)
	private String transaction_id;
	@XStreamAlias("out_trade_no")
	@XStreamConverter(value = XmlHelper.class)
	private String out_trade_no;
	@XStreamAlias("total_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String total_fee;
	@XStreamAlias("cash_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String cash_fee;
	@XStreamAlias("refund_count")
	@XStreamConverter(value = XmlHelper.class)
	private String refund_count;
	@XStreamAlias("out_refund_no_0")
	@XStreamConverter(value = XmlHelper.class)
	private String out_refund_no_0;
	@XStreamAlias("refund_id_0")
	@XStreamConverter(value = XmlHelper.class)
	private String refund_id_0;
	@XStreamAlias("refund_success_time_0")
	@XStreamConverter(value = XmlHelper.class)
	private String refund_success_time_0;
	@XStreamAlias("refund_status_0")
	@XStreamConverter(value = XmlHelper.class)
	private String refund_status_0;
	@XStreamAlias("refund_fee_0")
	@XStreamConverter(value = XmlHelper.class)
	private String refund_fee_0;
	@XStreamAlias("refund_recv_accout_0")
	@XStreamConverter(value = XmlHelper.class)
	private String refund_recv_accout_0;
	
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
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
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
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getCash_fee() {
		return cash_fee;
	}
	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}
	public String getRefund_count() {
		return refund_count;
	}
	public void setRefund_count(String refund_count) {
		this.refund_count = refund_count;
	}
	public String getOut_refund_no_0() {
		return out_refund_no_0;
	}
	public void setOut_refund_no_0(String out_refund_no_0) {
		this.out_refund_no_0 = out_refund_no_0;
	}
	public String getRefund_id_0() {
		return refund_id_0;
	}
	public void setRefund_id_0(String refund_id_0) {
		this.refund_id_0 = refund_id_0;
	}
	public String getRefund_success_time_0() {
		return refund_success_time_0;
	}
	public void setRefund_success_time_0(String refund_success_time_0) {
		this.refund_success_time_0 = refund_success_time_0;
	}
	public String getRefund_status_0() {
		return refund_status_0;
	}
	public void setRefund_status_0(String refund_status_0) {
		this.refund_status_0 = refund_status_0;
	}
	public String getRefund_fee_0() {
		return refund_fee_0;
	}
	public void setRefund_fee_0(String refund_fee_0) {
		this.refund_fee_0 = refund_fee_0;
	}
	public String getRefund_recv_accout_0() {
		return refund_recv_accout_0;
	}
	public void setRefund_recv_accout_0(String refund_recv_accout_0) {
		this.refund_recv_accout_0 = refund_recv_accout_0;
	}
	@Override
	public String toString() {
		return "RefundQueryResponse [return_code=" + return_code + ", return_msg=" + return_msg + ", result_code="
				+ result_code + ", err_code=" + err_code + ", err_code_des=" + err_code_des + ", appid=" + appid
				+ ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", sign=" + sign + ", transaction_id="
				+ transaction_id + ", out_trade_no=" + out_trade_no + ", total_fee=" + total_fee + ", cash_fee="
				+ cash_fee + ", refund_count=" + refund_count + ", out_refund_no_0=" + out_refund_no_0
				+ ", refund_id_0=" + refund_id_0 + ", refund_success_time_0=" + refund_success_time_0
				+ ", refund_status_0=" + refund_status_0 + ", refund_fee_0=" + refund_fee_0 + ", refund_recv_accout_0="
				+ refund_recv_accout_0 + "]";
	}
	

}
