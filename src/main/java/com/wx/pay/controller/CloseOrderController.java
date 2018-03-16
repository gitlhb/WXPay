package com.wx.pay.controller;

import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wx.pay.entity.request.CloseorderRequest;
import com.wx.pay.entity.request.CloserOrderJSReq;
import com.wx.pay.entity.response.CloseorderResponse;
import com.wx.pay.utils.ConstantParam;
import com.wx.pay.utils.HttpHelper;
import com.wx.pay.utils.TecentPayUtil;
import com.wx.pay.utils.XmlHelper;

@Controller
public class CloseOrderController {
	@RequestMapping(value = "/closeOrder", produces = { "application/json; charset=UTF-8" })
	public @ResponseBody CloseorderResponse closerOrder(@RequestBody CloserOrderJSReq reqc) throws Exception {
		CloseorderRequest req = new CloseorderRequest();
		req.setAppid(ConstantParam.APPID);
		req.setMch_id(ConstantParam.MCHID);
		req.setNonce_str(TecentPayUtil.getNonceStr());
		req.setOut_trade_no(reqc.getOrderNo());
		SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
		packageParams.put("appid", req.getAppid());
		packageParams.put("mch_id", req.getMch_id());
		packageParams.put("nonce_str", req.getNonce_str());
		packageParams.put("out_trade_no", req.getOut_trade_no());
		String sign = TecentPayUtil.createSign("UTF-8", packageParams, ConstantParam.MCH_KEY);// MD5¹þÏ£
		req.setSign(sign.toUpperCase());
		String body = XmlHelper.toXml(req, CloseorderRequest.class);
		System.out.println("closerOrderRequest:" + body);

		String re = HttpHelper.sendTecentHttpsPost(ConstantParam.CLOSE_ORDER, body);

		System.out.println("closerOrderResponse:" + re);
		return XmlHelper.toBean(re, CloseorderResponse.class);
	}
}
