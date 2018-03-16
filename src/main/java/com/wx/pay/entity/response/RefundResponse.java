package com.wx.pay.entity.response;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.wx.pay.utils.XmlHelper;

/**
 * 微信退款返回的消息
 * 
 * @author liuhongbing
 *
 */
@XStreamAlias("xml")
public class RefundResponse implements Serializable {

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
	/**
	 * 业务结果
	 */
	@XStreamAlias("result_code")
	@XStreamConverter(value = XmlHelper.class)
	private String result_code;
	/**
	 * 错误代码
	 */
	@XStreamAlias("err_code")
	@XStreamConverter(value = XmlHelper.class)
	private String err_code;
	
	/**
	 * 错误代码描述
	 */
	@XStreamAlias("err_code_des")
	@XStreamConverter(value = XmlHelper.class)
	private String err_code_des;
	/**
	 * 公众账号ID
	 */
	@XStreamAlias("appid")
	@XStreamConverter(value = XmlHelper.class)
	private String appid;
	/**
	 * 商户号
	 */
	@XStreamAlias("mch_id")
	@XStreamConverter(value = XmlHelper.class)
	private String mch_id;
	
	/**
	 * 随机字符串
	 */
	@XStreamAlias("nonce_str")
	@XStreamConverter(value = XmlHelper.class)
	private String nonce_str;
	/**
	 * 签名
	 */
	@XStreamAlias("sign")
	@XStreamConverter(value = XmlHelper.class)
	private String sign;
	/**
	 * 微信订单号
	 */
	@XStreamAlias("transaction_id")
	@XStreamConverter(value = XmlHelper.class)
	private String transaction_id;
	/**
	 * 商户订单号
	 */
	@XStreamAlias("out_trade_no")
	@XStreamConverter(value = XmlHelper.class)
	private String out_trade_no;
	/**
	 * 商户退款单号
	 */
	@XStreamAlias("out_refund_no")
	@XStreamConverter(value = XmlHelper.class)
	private String out_refund_no;
	/**
	 * 微信退款单号
	 */
	@XStreamAlias("refund_id")
	@XStreamConverter(value = XmlHelper.class)
	private String refund_id;
	/**
	 * 退款金额
	 */
	@XStreamAlias("refund_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String refund_fee;
	/**
	 * 应结退款金额
	 */
	@XStreamAlias("settlement_refund_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String settlement_refund_fee;
	/**
	 * 标价金额
	 */
	@XStreamAlias("total_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String total_fee;
	/**
	 * 应结订单金额
	 */
	@XStreamAlias("settlement_total_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String settlement_total_fee ;
	/**
	 * 标价币种
	 */
	@XStreamAlias("fee_type")
	@XStreamConverter(value = XmlHelper.class)
	private String fee_type;
	/**
	 * 现金支付金额
	 */
	@XStreamAlias("cash_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String cash_fee;
	/**
	 * 现金支付币种 
	 */
	@XStreamAlias("cash_fee_type")
	@XStreamConverter(value = XmlHelper.class)
	private String cash_fee_type;
	/**
	 * 现金退款金额
	 */
	@XStreamAlias("cash_refund_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String cash_refund_fee;
	/**
	 * 代金券退款总金额
	 */
	@XStreamAlias("coupon_refund_fee")
	@XStreamConverter(value = XmlHelper.class)
	private String coupon_refund_fee;
	/**
	 * 退款代金券使用数量
	 */
	@XStreamAlias("coupon_refund_count")
	@XStreamConverter(value = XmlHelper.class)
	private String coupon_refund_count;
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
	public String getOut_refund_no() {
		return out_refund_no;
	}
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}
	public String getRefund_id() {
		return refund_id;
	}
	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}
	public String getRefund_fee() {
		return refund_fee;
	}
	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}
	public String getSettlement_refund_fee() {
		return settlement_refund_fee;
	}
	public void setSettlement_refund_fee(String settlement_refund_fee) {
		this.settlement_refund_fee = settlement_refund_fee;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getSettlement_total_fee() {
		return settlement_total_fee;
	}
	public void setSettlement_total_fee(String settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getCash_fee() {
		return cash_fee;
	}
	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}
	public String getCash_fee_type() {
		return cash_fee_type;
	}
	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}
	public String getCash_refund_fee() {
		return cash_refund_fee;
	}
	public void setCash_refund_fee(String cash_refund_fee) {
		this.cash_refund_fee = cash_refund_fee;
	}
	public String getCoupon_refund_fee() {
		return coupon_refund_fee;
	}
	public void setCoupon_refund_fee(String coupon_refund_fee) {
		this.coupon_refund_fee = coupon_refund_fee;
	}
	public String getCoupon_refund_count() {
		return coupon_refund_count;
	}
	public void setCoupon_refund_count(String coupon_refund_count) {
		this.coupon_refund_count = coupon_refund_count;
	}
	@Override
	public String toString() {
		return "RefundResponse [return_code=" + return_code + ", return_msg=" + return_msg + ", result_code="
				+ result_code + ", err_code=" + err_code + ", err_code_des=" + err_code_des + ", appid=" + appid
				+ ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", sign=" + sign + ", transaction_id="
				+ transaction_id + ", out_trade_no=" + out_trade_no + ", out_refund_no=" + out_refund_no
				+ ", refund_id=" + refund_id + ", refund_fee=" + refund_fee + ", settlement_refund_fee="
				+ settlement_refund_fee + ", total_fee=" + total_fee + ", settlement_total_fee=" + settlement_total_fee
				+ ", fee_type=" + fee_type + ", cash_fee=" + cash_fee + ", cash_fee_type=" + cash_fee_type
				+ ", cash_refund_fee=" + cash_refund_fee + ", coupon_refund_fee=" + coupon_refund_fee
				+ ", coupon_refund_count=" + coupon_refund_count + "]";
	}
	
	
	
	
	
	
}
