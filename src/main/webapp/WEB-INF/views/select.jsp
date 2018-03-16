<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.1.1.js"></script>
<title>index</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询退款列表页面</title>

<script type="text/javascript">
	$(function() {
		//alert("${orderNo}");
		refundQuery();
	});
	function refundQuery() {
		var url = "${pageContext.request.contextPath}";
		var ax = $.ajax({
			url : url + "/refundQuery",
			type : "POST",
			data : JSON.stringify({
				"orderNo" : "${orderNo}",
				"refund_id" : "${refund_id}",
				"out_refund_no" : "${out_refund_no}"
			}),
			datatype : "json",
			contentType : "application/json",
			cache : false,
			timeout : 30000,
			async : true,
			beforeSend : function() {
				//alert("beforeSend...");
			},
			error : function(data, status, e) { //出错处理
				//alert("error");
			},
			success : function(data, textStatus) { //成功处理
				$(document).attr("title", "查询微信退款信息")
				$("#result_code").html(data.result_code);
				$("#return_msg").html(data.return_msg);
				$("#appid").html(data.appid);
				$("#mch_id").html(data.mch_id);
				$("#out_trade_no").html(data.out_trade_no);
				$("#refund_fee_0").html(data.refund_fee_0);
				$("#refund_status_0").html(data.refund_status_0);
				$("#refund_success_time_0").html(data.refund_success_time_0);
				$("#refund_recv_accout_0").html(data.refund_recv_accout_0);
			}
		});
	}
</script>


</head>
<body>
	返回结果:
	<span id="result_code"></span>
	<br> 返回信息:
	<span id="return_msg"></span>
	<br> 公众账号ID:
	<span id="appid"></span>
	<br> 商户号:
	<span id="mch_id"></span>
	<br> 商户订单号:
	<span id="out_trade_no"></span>
	<br> 退款金额:
	<span id="refund_fee_0"></span>
	<br> 商户退款状态:
	<span id="refund_status_0"></span>
	<br> 退款时间:
	<span id="refund_success_time_0"></span>
	<br> 退款路径:
	<span id="refund_recv_accout_0"></span>
</body>
</html>