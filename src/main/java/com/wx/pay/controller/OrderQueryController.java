package com.wx.pay.controller;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wx.pay.entity.request.QueryOrderJSReq;
import com.wx.pay.entity.request.QueryOrderRequest;
import com.wx.pay.entity.response.QueryOrderResponse;
import com.wx.pay.utils.ConstantParam;
import com.wx.pay.utils.HttpHelper;
import com.wx.pay.utils.TecentPayUtil;
import com.wx.pay.utils.XmlHelper;

@Controller
public class OrderQueryController {

	@RequestMapping("/orderQuery")
	public String orderQery(Map<String, String> map, @RequestParam("orderNo") String orderNo) {
		map.put("orderNo", orderNo);
		return "queryOrder";
	}

	@RequestMapping(value = "/orderQueryList", produces = { "application/json; charset=UTF-8" })
	public @ResponseBody QueryOrderResponse orderQueryList(@RequestBody QueryOrderJSReq jsreq) throws Exception {
		QueryOrderResponse res = new QueryOrderResponse();
		QueryOrderRequest req = new QueryOrderRequest();
		req.setAppid(ConstantParam.APPID);
		req.setMch_id(ConstantParam.MCHID);
		req.setNonce_str(TecentPayUtil.getNonce_str());
		req.setOut_trade_no(jsreq.getOrderNo());

		SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
		packageParams.put("appid", req.getAppid());
		packageParams.put("mch_id", req.getMch_id());
		packageParams.put("nonce_str", req.getNonce_str());
		packageParams.put("out_trade_no", req.getOut_trade_no());
		String sign = TecentPayUtil.createSign("UTF-8", packageParams, ConstantParam.MCH_KEY);// MD5¹þÏ£
		req.setSign(sign.toUpperCase());
		String body = XmlHelper.toXml(req, QueryOrderRequest.class);
		System.out.println("orderQueryRequest:" + body);
		String reswx = HttpHelper.sendTecentHttpsPost(ConstantParam.QUERY_ORDER, body);
		System.out.println("orderQueryResponse:" + reswx);
		res = XmlHelper.toBean(reswx, QueryOrderResponse.class);
		return res;
	}
}
