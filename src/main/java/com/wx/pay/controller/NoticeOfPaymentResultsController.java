package com.wx.pay.controller;

import java.util.Map;
import java.util.Objects;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wx.pay.entity.request.GetPayStatusRequest;
import com.wx.pay.entity.request.NoticeOfPaymentResultsRequest;
import com.wx.pay.entity.response.GetPayStatusResponse;
import com.wx.pay.entity.response.ReplyToWeChat;
import com.wx.pay.utils.ConstantParam;
import com.wx.pay.utils.TecentPayUtil;

/**
 * 支付结果通知
 * @author liuhongbing
 *
 */
@Controller
public class NoticeOfPaymentResultsController {

	@RequestMapping(value = "/payment", produces = { "application/xml; charset=UTF-8" })
	public @ResponseBody ReplyToWeChat noticeOfPaymentResults(
			@RequestBody NoticeOfPaymentResultsRequest xml) {
		System.out.println("接收微信消息:" + xml);

		ReplyToWeChat res = new ReplyToWeChat();
		if (Objects.equals("SUCCESS", xml.getReturn_code())) {
			// 先算签名[确认是不是微信服务器发来的消息]
			if (TecentPayUtil.checkSignNoticePaymentResults(xml)) {
				String orderNo = xml.getOut_trade_no();
				// 0未支付 1 已支付
				if (ConstantParam.map.get(orderNo) == 0) {
					ConstantParam.map.put(orderNo, 1);
				}
				res.setReturn_code("SUCCESS");
				res.setReturn_msg("OK");
			} else {
				res.setReturn_code("FIAL");
				res.setReturn_msg("sign error");
			}

		} else {
			res.setReturn_code("FIAL");
			res.setReturn_msg("ERROR");
		}
		System.out.println("返回给微信的消息:" + res);
		return res;
	}

	@RequestMapping("/success")
	public String success(@RequestParam("orderNo") String orderNo, Map<String, String> map) {
		map.put("orderNo", orderNo);
		return "success";
	}

	@RequestMapping(value = "/getPayStatus", produces = { "application/xml; charset=UTF-8" })
	public @ResponseBody GetPayStatusResponse getPayStatus(@RequestBody GetPayStatusRequest xml) {
		GetPayStatusResponse res = new GetPayStatusResponse();
		String orderNo = xml.getOrderNo();
		Integer st = ConstantParam.map.get(orderNo);
		res.setStatus(st + "");
		return res;
	}

}
