
<%@page import="com.wx.pay.utils.OrderIdUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setAttribute("orderNo", OrderIdUtil.getOrderId());
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.1.1.js"></script>

<style type="text/css">
.box {
	width: 310px;
	height: 619px;
	left: 500px;
	position: absolute;
	background: url(img/bg.png) no-repeat center;
}

.er {
	width: 130px;
	height: 130px;
	left: 91px;
	margin-top: 203px;
	position: absolute;
	border-radius: 10px;
}
</style>

<title>扫码支付首页</title>
</head>
<script type="text/javascript">
	var timeInterval;
	var countInterval;
	var timeCount = 30;
	$(function() {
		timeInterval = window.setInterval("payStatus()", 1000);
		countInterval = window.setInterval("showTime()", 1000);
	});
	function showTime() {
		$("#ts").html(timeCount);
		timeCount--;
		if (timeCount == 0) {
			window.clearInterval(countInterval);
			$("#ts").html("二维码已经失效");
			closeOrder();
		}
	}
	function closeOrder() {
		var url = "${pageContext.request.contextPath}";
		var orderNo = "${orderNo}";
		var ax = $.ajax({
			url : url + "/closeOrder",
			type : "POST",
			data : JSON.stringify({
				"orderNo" : "${orderNo}"
			}),
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			async : true,
			beforeSend : function() {
				//alert("beforeSend...");
			},
			error : function(data, textStatus, e) { //出错处理
				alert("error");
				$("#er1").css("background", "url(img/0.jpg)");
				window.clearInterval(timeInterval);
			},
			success : function(data, textStatus, args) { //成功处理
				window.clearInterval(timeInterval);
				var a = data.result_code;
				if (a == "SUCCESS") {
					$("#ts").html("订单关闭成功");
				} else {
					$("#ts").html("订单关闭失败");
				}
				$("img").attr("src",
						"${pageContext.request.contextPath }/img/0.jpg");
			}
		});
	}
	function payStatus() {
		var url = "${pageContext.request.contextPath}";
		var orderNo = "${orderNo}";
		var args = "<xml><orderNo>" + orderNo + "</orderNo></xml>";
		var ax = $
				.ajax({
					url : url + "/getPayStatus",
					type : "POST",
					data : args,
					dataType : "xml",
					contentType : "application/xml;charset=utf-8",
					async : true,
					beforeSend : function() {
						//alert("beforeSend...");
					},
					error : function(data, textStatus, e) { //出错处理
						window.clearInterval(timeInterval);
					},
					success : function(data, textStatus, args) { //成功处理
						//$(location).attr('href',"${pageContext.request.contextPath}/showdoclist}");
						var a = $(data).find("xml").children("status").text();
						if (a == "1") {
							window.clearInterval(timeInterval);
							$(location)
									.attr('href',
											"${pageContext.request.contextPath}/success?orderNo=${orderNo}");
						} else {

						}

					}
				});
	}
</script>
<body>
	<span id="ts"
		style="position: absolute; text-align: right; color: red; font-size: 18px">60</span>
	<span
		style="position: absolute; left: 300px; text-align: center; color: Blue; font-size: 25px">扫码支付一分钱</span>
	<%-- 	<img alt="" width="300px" height="300px"
			src="${pageContext.request.contextPath }/PayQrCode2?orderNo=${orderNo}"
			onerror="this.src='${pageContext.request.contextPath }/img/error.jpg'" /> --%>
	<div class="box">
		<div id="er1">
			<img class="er" alt="" width="130px" height="130px"
				src="${pageContext.request.contextPath }/PayQrCode2?orderNo=${orderNo}"
				onerror="this.src='${pageContext.request.contextPath }/img/error.jpg'" />
		</div>
	</div>

</body>
</html>