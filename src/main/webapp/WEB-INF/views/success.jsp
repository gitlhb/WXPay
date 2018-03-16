<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付成功</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.1.1.js"></script>
<title>index</title>

<script type="text/javascript">
	var timeInterval;
	$(function() {
		timeInterval = window.setInterval("payStatus()", 500);
	});

	function payStatus() {
		var url = "${pageContext.request.contextPath}";
		var orderNo = "${orderNo}";
		//alert(orderNo);
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
							//$(location).attr('href',"${pageContext.request.contextPath}/success?orderNo=${orderNo}");
						} else {
								$("h1").html("支付结果获取中。。。")
						}
					}
				});
	}
</script>

</head>
<body>
	<h1>Pay SUCCESS!!!商户订单号为:${orderNo}</h1>
	<form action="${pageContext.request.contextPath }/refund" method="get">
		<input type="text" name="orderNo" value="${ orderNo}" /> <input
			type="submit" value="退款" />
	</form>
	<form action="${pageContext.request.contextPath }/orderQuery" method="get">
		<input type="text" name="orderNo" value="${ orderNo}" /> <input
			type="submit" value="查询订单状态" />
	</form>
</body>
</html>
