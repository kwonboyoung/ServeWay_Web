<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주문 완료 확인</title>
</head>
<body>
<div class="header">
<p style="text-align: center;">
<img src="${context}/resources/img/logo.png"></p>
</div>
<form action="endPage" method="post">
<div class="container" align="center">
주문을 완료하셨습니다.
감사합니다!


또 주문하시겠습니까?
</div>
<input type="submit" class="btn btn-success" value="예"/>

</form>
</body>
</html>