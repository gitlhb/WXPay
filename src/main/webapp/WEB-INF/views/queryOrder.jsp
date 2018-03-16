<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.1.1.js"></script>


<script type="text/javascript">
	var timeInterval;
	$(function() {
		orderQuery();
	});

	function orderQuery() {
		var url = "${pageContext.request.contextPath}";
		var ax = $.ajax({
			url : url + "/orderQueryList",
			type : "POST",
			data : JSON.stringify({
				"orderNo" : "${orderNo}"
			}),
			datatype : "json",
			contentType : "application/json",
			cache : false,
			timeout : 30000,
			async : true,
			beforeSend : function() {
				alert("beforeSend...");
			},
			error : function(data, status, e) { //出错处理
				alert(data.responseText);
			},
			success : function(data, textStatus) { //成功处理
				$(document).attr("title", "查询微信订单信息")
				$("#return_code").html(data.return_code);
				$("#return_msg").html(data.return_msg);
				$("#appid").html(data.appid);
				$("#mch_id").html(data.mch_id);
				$("#nonce_str").html(data.nonce_str);
				$("#sign").html(data.sign);
				$("#result_code").html(data.result_code);
				$("#openid").html(data.openid);
				$("#is_subscribe").html(data.is_subscribe);
				$("#trade_type").html(data.trade_type);
				$("#trade_state").html(data.trade_state);
				$("#bank_type").html(data.bank_type);
				$("#total_fee").html(data.total_fee);
				$("#fee_type").html(data.fee_type);
				$("#cash_fee").html(data.cash_fee);
				$("#transaction_id").html(data.transaction_id);
				$("#out_trade_no").html(data.out_trade_no);
				$("#time_end").html(data.time_end);
				$("#trade_state_desc").html(data.trade_state_desc);
			}
		});
	}
</script>
<title>查询订单列表</title>




</head>
<body>
	返回状态码:
	<span id="return_code"></span>
	<br> 返回信息 :
	<span id="return_msg"></span>
	<br> 公众账号ID:
	<span id="appid"></span>
	<br> 商户号:
	<span id="mch_id"></span>
	<br> 随机字符串:
	<span id="nonce_str"></span>
	<br> 签名:
	<span id="sign"></span>
	<br> 错误代码:
	<span id="result_code"></span>
	<br> 用户标识 :
	<span id="openid"></span>
	<br> 是否关注公众账号:
	<span id="is_subscribe"></span>
	<br> 交易类型:
	<span id="trade_type"></span>
	<br> 付款银行:
	<span id="bank_type"></span>
	<br> 标价金额:
	<span id="total_fee"></span>
	<br> 标价币种:
	<span id="fee_type"></span>
	<br> 微信支付订单号 :
	<span id="transaction_id"></span>
	<br> 商户订单号 :
	<span id="out_trade_no"></span>
	<br> 支付完成时间:
	<span id="time_end"></span>
	<br> 交易状态 :
	<span id="trade_state"></span>
	<br> 现金支付金额:
	<span id="cash_fee"></span>
	<br> 交易状态描述 :
	<span id="trade_state_desc"></span>
	<br>
</body>
</html>