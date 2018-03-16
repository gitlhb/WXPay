package com.wx.pay.controller;

import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wx.pay.entity.request.RefundRequest;
import com.wx.pay.entity.response.RefundResponse;
import com.wx.pay.utils.ConstantParam;
import com.wx.pay.utils.HttpHelper;
import com.wx.pay.utils.TecentPayUtil;
import com.wx.pay.utils.XmlHelper;

@Controller
public class RefundController {
	private final String SELECT = "select";

	@RequestMapping(value = "/refund", produces = { "application/json; charset=UTF-8" })
	public String refund(@RequestParam("orderNo") String orderNo, Map<String, String> map) {
		try {
			RefundRequest req = new RefundRequest();
			req.setAppid(ConstantParam.APPID);
			req.setMch_id(ConstantParam.MCHID);
			req.setNonce_str(TecentPayUtil.getNonce_str());
			req.setOut_trade_no(orderNo);
			req.setOut_refund_no(System.currentTimeMillis() + "");
			req.setTotal_fee("1");
			req.setRefund_fee("1");
			// req.setTransaction_id("4200000004201801080200119990");
			SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
			packageParams.put("appid", req.getAppid());
			packageParams.put("mch_id", req.getMch_id());
			packageParams.put("nonce_str", req.getNonce_str());
			packageParams.put("out_trade_no", req.getOut_trade_no());
			packageParams.put("out_refund_no", req.getOut_refund_no());
			packageParams.put("total_fee", req.getTotal_fee());
			packageParams.put("refund_fee", req.getRefund_fee());
			// packageParams.put("transaction_id",
			// "4200000004201801080200119990");
			String sign = TecentPayUtil.createSign("UTF-8", packageParams, ConstantParam.MCH_KEY);// MD5哈希
			req.setSign(sign.toUpperCase());
			String body = XmlHelper.toXml(req, RefundRequest.class);
			String refundRespose = HttpHelper.sendTecentHttpsPost(ConstantParam.REFUND, body);
			System.out.println("refund-response:" + refundRespose);
			RefundResponse res = XmlHelper.toBean(refundRespose, RefundResponse.class);
			// 验证签名
			if (Objects.equals("SUCCESS", res.getReturn_code())) {
				if (TecentPayUtil.checkSignRefund(res)) {
					map.put("orderNo", orderNo);
					map.put("refund_id", res.getRefund_id());
					map.put("out_refund_no", res.getOut_refund_no());
					map.put("refundCode", res.getResult_code());
				}
			} else {
				map.put("refundCode", res.getErr_code());
				/*
				 * SYSTEMERROR 接口返回错误 系统超时等 请不要更换商户退款单号，请使用相同参数再次调用API。
				 * BIZERR_NEED_RETRY 退款业务流程错误，需要商户触发重试来解决
				 * 并发情况下，业务被拒绝，商户重试即可解决请不要更换商户退款单号，请使用相同参数再次调用API。 TRADE_OVERDUE
				 * 订单已经超过退款期限订单已经超过可退款的最大期限(支付后一年内可退款) 请选择其他方式自行退款 ERROR 业务错误
				 * 申请退款业务发生错误该错误都会返回具体的错误原因，请根据实际返回做相应处理。 USER_ACCOUNT_ABNORMAL
				 * 退款请求失败用户帐号注销 此状态代表退款申请失败，商户可自行处理退款。 INVALID_REQ_TOO_MUCH
				 * 无效请求过多连续错误请求数过多被系统短暂屏蔽 请检查业务是否正常，确认业务正常后请在1分钟后再来重试 NOTENOUGH
				 * 余额不足商户可用退款余额不足 此状态代表退款申请失败，商户可根据具体的错误提示做相应的处理。
				 * INVALID_TRANSACTIONID 无效transaction_id
				 * 请求参数未按指引进行填写请求参数错误，检查原交易号是否存在或发起支付交易接口返回失败 PARAM_ERROR 参数错误
				 * 请求参数未按指引进行填写请求参数错误，请重新检查再调用退款申请 APPID_NOT_EXIST APPID不存在
				 * 参数中缺少APPID请检查APPID是否正确 MCHID_NOT_EXIST MCHID不存在 参数中缺少MCHID
				 * 请检查MCHID是否正确 REQUIRE_POST_METHOD 请使用post方法
				 * 未使用post传递参数 请检查请求参数是否通过post方法提交 SIGNERROR 签名错误
				 * 参数签名结果不正确请检查签名参数和方法是否都符合签名算法要求 XML_FORMAT_ERROR XML格式错误
				 * XML格式错误请检查XML参数格式是否正确 FREQUENCY_LIMITED 频率限制
				 * 2个月之前的订单申请退款有频率限制该笔退款未受理，请降低频率后重试
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SELECT;
	}

}
