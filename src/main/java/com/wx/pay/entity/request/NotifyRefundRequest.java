package com.wx.pay.entity.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 接受微信退款通知的请求
 * 
 * @author liuhongbing
 *
 */
@XmlRootElement(name = "xml")
public class NotifyRefundRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 返回状态码 SUCCESS/FAIL 此字段是通信标识，非结果标识，退款是否成功需要解密后查看refund_status 来判断
	 */
	private String return_code;

	/**
	 * 返回信息
	 */
	private String return_msg;

	/**
	 * 公众账号ID
	 */
	private String appid;

	/**
	 * 退款的商户号
	 */
	private String mch_id;

	/**
	 * 随机字符串
	 */
	private String nonce_str;

	/**
	 * 加密信息
	 */
	private String req_info;

	public String getReturn_code() {
		return return_code;
	}

	@XmlElement(name = "return_code")
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	@XmlElement(name = "return_msg")
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getAppid() {
		return appid;
	}

	@XmlElement(name = "appid")
	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	@XmlElement(name = "mch_id")
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	@XmlElement(name = "nonce_str")
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getReq_info() {
		return req_info;
	}

	@XmlElement(name = "req_info")
	public void setReq_info(String req_info) {
		this.req_info = req_info;
	}

	@XmlRootElement(name = "req_info")
	public static class ReqInfo {
		/**
		 * 微信订单号
		 */
		private String transaction_id;

		/**
		 * 商户订单号
		 */
		private String out_trade_no;

		/**
		 * 微信退款单号
		 */
		private String refund_id;

		/**
		 * 商户退款单号
		 */
		private String out_refund_no;

		/**
		 * 订单金额
		 */
		private String total_fee;
		/**
		 * 应结订单金额
		 */

		private String settlement_total_fee;
		/**
		 * 申请退款金额
		 */
		private String refund_fee;
		/**
		 * 退款金额
		 */

		private String settlement_refund_fee;
		/*
		 * 退款状态 SUCCESS-退款成功CHANGE-退款异常 REFUNDCLOSE—退款关闭
		 */

		private String refund_status;

		/**
		 * 退款成功时间
		 */
		private String success_time;

		/**
		 * 退款入账账户
		 */
		private String refund_recv_accout;

		/**
		 * 退款资金来源
		 */
		private String refund_account;

		/**
		 * 退款发起来源
		 */
		private String refund_request_source;

		public String getTransaction_id() {
			return transaction_id;
		}

		@XmlElement(name = "transaction_id")
		public void setTransaction_id(String transaction_id) {
			this.transaction_id = transaction_id;
		}

		public String getOut_trade_no() {
			return out_trade_no;
		}

		@XmlElement(name = "out_trade_no")
		public void setOut_trade_no(String out_trade_no) {
			this.out_trade_no = out_trade_no;
		}

		public String getRefund_id() {
			return refund_id;
		}

		@XmlElement(name = "refund_id")
		public void setRefund_id(String refund_id) {
			this.refund_id = refund_id;
		}

		public String getOut_refund_no() {
			return out_refund_no;
		}

		@XmlElement(name = "out_refund_no")
		public void setOut_refund_no(String out_refund_no) {
			this.out_refund_no = out_refund_no;
		}

		public String getTotal_fee() {
			return total_fee;
		}

		@XmlElement(name = "total_fee")
		public void setTotal_fee(String total_fee) {
			this.total_fee = total_fee;
		}

		public String getSettlement_total_fee() {
			return settlement_total_fee;
		}

		@XmlElement(name = "settlement_total_fee")
		public void setSettlement_total_fee(String settlement_total_fee) {
			this.settlement_total_fee = settlement_total_fee;
		}

		public String getRefund_fee() {
			return refund_fee;
		}

		@XmlElement(name = "refund_fee")
		public void setRefund_fee(String refund_fee) {
			this.refund_fee = refund_fee;
		}

		public String getSettlement_refund_fee() {
			return settlement_refund_fee;
		}

		@XmlElement(name = "settlement_refund_fee")
		public void setSettlement_refund_fee(String settlement_refund_fee) {
			this.settlement_refund_fee = settlement_refund_fee;
		}

		public String getRefund_status() {
			return refund_status;
		}

		@XmlElement(name = "refund_status")
		public void setRefund_status(String refund_status) {
			this.refund_status = refund_status;
		}

		public String getSuccess_time() {
			return success_time;
		}

		@XmlElement(name = "success_time")
		public void setSuccess_time(String success_time) {
			this.success_time = success_time;
		}

		public String getRefund_recv_accout() {
			return refund_recv_accout;
		}

		@XmlElement(name = "refund_recv_accout")
		public void setRefund_recv_accout(String refund_recv_accout) {
			this.refund_recv_accout = refund_recv_accout;
		}

		public String getRefund_account() {
			return refund_account;
		}

		@XmlElement(name = "refund_account")
		public void setRefund_account(String refund_account) {
			this.refund_account = refund_account;
		}

		public String getRefund_request_source() {
			return refund_request_source;
		}

		@XmlElement(name = "refund_request_source")
		public void setRefund_request_source(String refund_request_source) {
			this.refund_request_source = refund_request_source;
		}

	}

}
