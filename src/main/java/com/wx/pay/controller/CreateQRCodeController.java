package com.wx.pay.controller;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.wx.pay.entity.request.UnifiedorderRequest;
import com.wx.pay.entity.response.UnifiedorderResponse;
import com.wx.pay.utils.ConstantParam;
import com.wx.pay.utils.HttpHelper;
import com.wx.pay.utils.TecentPayEnum;
import com.wx.pay.utils.TecentPayUtil;
import com.wx.pay.utils.XmlHelper;
/*this is  a  dev fenzhi
haha ganggang
*/
@Controller
public class CreateQRCodeController {
	@RequestMapping(value = "/PayQrCode2", method = RequestMethod.GET)
	public void createQrCode(HttpServletRequest request, HttpServletResponse response, Map<String, String> map,@RequestParam("orderNo") String orderNo)
			throws Exception {
		String amt = "1";//this is a test amt
		map.put("orderNo", orderNo);
		UnifiedorderRequest req = new UnifiedorderRequest();
		req.setAppid(ConstantParam.APPID);
		req.setOut_trade_no(orderNo);
		req.setBody("Demo");
		req.setTotal_fee(amt);
		req.setNotify_url(ConstantParam.NOTIFY_URL);
		req.setTrade_type(TecentPayEnum.NATIVE.name());
		req.setMch_id(ConstantParam.MCHID);
		req.setSpbill_create_ip(TecentPayUtil.getIpAddr(request));
		req.setNonce_str(TecentPayUtil.getNonceStr());
		req.setProduct_id("123456");
		SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
		packageParams.put("appid", req.getAppid());
		packageParams.put("body", req.getBody());
		packageParams.put("mch_id", req.getMch_id());
		packageParams.put("nonce_str", req.getNonce_str());
		packageParams.put("notify_url", req.getNotify_url());
		packageParams.put("out_trade_no", req.getOut_trade_no());
		packageParams.put("product_id", req.getProduct_id());
		packageParams.put("spbill_create_ip", req.getSpbill_create_ip());
		packageParams.put("total_fee", req.getTotal_fee());
		packageParams.put("trade_type", req.getTrade_type());

		String sign = TecentPayUtil.createSign("UTF-8", packageParams, ConstantParam.MCH_KEY);
		req.setSign(sign.toLowerCase());
		String body = XmlHelper.toXml(req, UnifiedorderRequest.class);
		System.out.println("CreateQRCodeRequest->:" + body);
		String responseXML = HttpHelper.sendHttpPost(ConstantParam.UNIFIEDORDER_URL, body, null);
		System.out.println("CreateQRCodeResponse->:" + responseXML);
		UnifiedorderResponse res = XmlHelper.toBean(responseXML, UnifiedorderResponse.class);
		if (Objects.equals("SUCCESS", res.getResult_code())) {
			ConstantParam.map.put(orderNo, 0);
			Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hints.put(EncodeHintType.MARGIN, 1);
			BitMatrix bitMatrix = new MultiFormatWriter().encode(res.getCode_url(), BarcodeFormat.QR_CODE, 130, 130,
					hints);
			OutputStream out = response.getOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "png", out);

			out.flush();
			out.close();
		} else {
			throw new Exception("Error");
		}
	}

}
