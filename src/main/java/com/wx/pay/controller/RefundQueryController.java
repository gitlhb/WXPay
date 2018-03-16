package com.wx.pay.controller;

import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wx.pay.entity.request.QueryRefundJsonRequest;
import com.wx.pay.entity.request.RefundQueryRequest;
import com.wx.pay.entity.response.RefundQueryResponse;
import com.wx.pay.utils.ConstantParam;
import com.wx.pay.utils.HttpHelper;
import com.wx.pay.utils.TecentPayUtil;
import com.wx.pay.utils.XmlHelper;

@Controller
public class RefundQueryController {

	@RequestMapping(value = "/refundQuery", method = RequestMethod.POST, produces = {
			"application/json; charset=UTF-8" })
	public @ResponseBody RefundQueryResponse refundQuery(@RequestBody QueryRefundJsonRequest r) throws Exception {
		System.out.println("���յĲ�ѯ�˿�����Ϊ:" + r);
		RefundQueryResponse res = new RefundQueryResponse();
		RefundQueryRequest req = new RefundQueryRequest();
		req.setAppid(ConstantParam.APPID);
		req.setMch_id(ConstantParam.MCHID);
		req.setNonce_str(TecentPayUtil.getNonce_str());
		req.setOut_trade_no(r.getOrderNo());
		SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
		packageParams.put("appid", req.getAppid());
		packageParams.put("mch_id", req.getMch_id());
		packageParams.put("nonce_str", req.getNonce_str());
		packageParams.put("out_trade_no", req.getOut_trade_no());
		String sign = TecentPayUtil.createSign("UTF-8", packageParams, ConstantParam.MCH_KEY);// MD5��ϣ
		req.setSign(sign.toLowerCase());
		String body = XmlHelper.toXml(req, RefundQueryRequest.class);
		System.out.println("��ѯ�˿�����:" + XmlHelper.toXml(req, RefundQueryRequest.class));
		String resp = HttpHelper.sendTecentHttpsPost(ConstantParam.REFUND_QUERY, body);
		System.out.println("��ѯ�˿��:" + resp);
		res = XmlHelper.toBean(resp, RefundQueryResponse.class);
		return res;
	}
}
