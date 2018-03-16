package com.wx.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wx.pay.entity.request.NotifyRefundRequest;
import com.wx.pay.entity.request.NotifyRefundRequest.ReqInfo;
import com.wx.pay.entity.response.ReplyToWeChat;
import com.wx.pay.utils.AesUtil;
import com.wx.pay.utils.XmlHelper;

/**
 * 退款通知url处理
 * 
 * @author liuhongbing
 *
 */
@Controller
public class NotifyRefundController {
	@RequestMapping(value = "/notifyRefund", produces = { "application/xml; charset=UTF-8" })
	public @ResponseBody ReplyToWeChat noticeOfPaymentResults(@RequestBody NotifyRefundRequest req) {
		ReplyToWeChat res = new ReplyToWeChat();
		String req_info = req.getReq_info();
		String wxDecrypt="";
		try {
			wxDecrypt = AesUtil.decryptData(req_info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ReqInfo reqInfo = XmlHelper.toBean(wxDecrypt,NotifyRefundRequest.ReqInfo.class);
		System.out.println(reqInfo.getRefund_status());
		res.setReturn_code("SUCCESS");
		res.setReturn_msg("ok");
		return res;
	}
}
