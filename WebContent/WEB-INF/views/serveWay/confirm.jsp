
<%@page import="serveWay.models.AddVO"%>
<%@page import="serveWay.models.MaterialVO"%>
<%@page import="java.util.List"%>
<%@page import="serveWay.models.Order_detailVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<%
	Order_detailVO order_detailVO = (Order_detailVO)request.getAttribute("detailVO");
	List<MaterialVO> material = (List<MaterialVO>)request.getAttribute("material");
	List<AddVO> addition =(List<AddVO>)request.getAttribute("addition");
	String name = (String)request.getAttribute("f_name");
	
	/* Order_detailVO order_detailVO = (Order_detailVO)session.getAttribute("order"); */
	
	HttpSession session5 = request.getSession();
	session5.setAttribute("order", order_detailVO);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Luckiest+Guy" />
<link rel="stylesheet" href="${context}/resources/css/bootstrap.css">
<%-- <link rel="stylesheet" href="${context}/resources/css/bootstrap.min.css"> --%>
<link rel="stylesheet" href="${context}/resources/css/bootstrap-theme.min.css">
<script src="${context}/resources/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>confirm order</title>

</head>
<body>
<br/><br/><br/>
<div class="header">
<p style="text-align: center;">
<img src="${context}/resources/img/logo.png"></p>
</div>
<form action="confirmAction" method="post">
<!-- <div style="margin:5% 40% 0% 33%;float:left; width:500px; box-shadow:0 0 3px #aaa; height:auto;color:black;">
   <div style="width:100%; padding:10px; float:left; background:yellowgreen; font-size:30px; text-align:center;">
	주문 리스트
   </div> -->
   
   <div style="margin:5% 10% 0% 10%; float:center; box-shadow:0 0 3px #aaa; height:auto; color:black; max-width:500">
   <div align="center" style="width:100%; padding:10px; float:center; background:yellowgreen; font-size:30px; text-align:center;">
   <h1>Order List</h1>
   </div>
    <div style="width:100%; padding:0px 0px;border-bottom:1px solid rgba(0,0,0,0.2);float:left; font:"Luckiest Guy";>
        <div style="width:100%; float:left;padding:10px;">
          <%--  <div class="form-group">
	           	<div class="col-sm-4" style="font-size:20px;float:left; width:100%;">
	           		<b>주문번호</b>
	           	</div>
	           	<div class="col-sm-8" style="font-size:20px;float:right;  padding:10px; text-align:right;">
	           		<%=order_detailVO.getOrder_num() %>
	           	</div>
           </div> --%>
           <div class="form-group">
	           	<div class="col-sm-4" style="font-size:20px;float:left; width:100%;">
	           		<h3>name</h3>
	           	</div>
	           	<div class="col-sm-8" style="font-size:20px;float:right;  padding:10px; text-align:right;">
	           		<%=name%>
	           	</div>
           </div>
           <div class="form-group">
	           	<div class="col-sm-4" style="font-size:20px;float:left; width:100%;">
	           		<h3>recipe detail</h3>
	           	</div>
	           	<div class="col-sm-8" style="font-size:20px;float:right;  padding:10px; text-align:right;">
	           		<b>Bread</b> : <c:forEach items="${material}" var="material" ><c:if test="${material.material_type_no ==1 }">${material.material_name }</c:if> </c:forEach><br/>
					<b>Vegetables</b> : <c:forEach items="${material}" var="material" ><c:if test="${material.material_type_no ==2 }">${material.material_name }<br/></c:if></c:forEach><br/>
					<b>Sources</b> : <c:forEach items="${material}" var="material" ><c:if test="${material.material_type_no ==3 }">${material.material_name }<br/></c:if></c:forEach><br/>
					<b>Extras</b> : <c:forEach items="${addition}" var="addition" ><c:if test="${addition.add_type_no ==1 }">${addition.add_name }<br/></c:if></c:forEach>
	           	</div>
           </div>
           <div class="form-group">
	           	<div class="col-sm-4" style="font-size:20px;float:left; width:100%;">
	           		<h3>request message</h3>
	           	</div>
	           	<div class="col-sm-8" style="font-size:20px;float:right;  padding:10px; text-align:right;">
	           		<%=order_detailVO.getRequest_msg() %>
	           	</div>
           </div>
           <div class="form-group">
	           	<div class="col-sm-4" style="font-size:20px;float:left; width:100%;">
	           		<h3>price</h3>
	           	</div>
	           	<div class="col-sm-8" style="font-size:20px;float:right;  padding:10px; text-align:right;">
	           		<%=order_detailVO.getPrice() %>
	           	</div>
           </div>
            <div class="form-group">
	           	<div class="col-sm-4" style="font-size:20px;float:left; width:100%;">
	           		<h3>calorie</h3>
	           	</div>
	           	<div class="col-sm-8" style="font-size:20px;float:right;  padding:10px; text-align:right;">
	           		<%=order_detailVO.getTotal_cal() %>
	           	</div>
           </div>
           <div class="form-group">
	           	<div class="col-sm-4" style="font-size:20px;float:left; width:100%;">
	           		<h3>cookies</h3>
	           	</div>
	           	<div class="col-sm-8" style="font-size:20px;float:right;  padding:10px; text-align:right;">
	           		<c:forEach items="${addition}" var="addition" ><c:if test="${addition.add_type_no ==3}">${addition.add_name }<br/></c:if></c:forEach>
	           	</div>
           </div>
           <div class="form-group">
	           	<div class="col-sm-4" style="font-size:20px;float:left; width:100%;">
	           		<h3>drinks</h3>
	           	</div>
	           	<div class="col-sm-8" style="font-size:20px;float:right;  padding:10px; text-align:right;">
	           		<c:forEach items="${addition}" var="addition" ><c:if test="${addition.add_type_no ==2}">${addition.add_name }<br/></c:if></c:forEach>
	           	</div>
           </div>
            <div class="form-group">
	           	<div class="col-sm-4" style="font-size:20px;float:left; width:100%;">
	           		<h3>date</h3>
	           	</div>
	           	<div class="col-sm-8" style="font-size:20px;float:right;  padding:10px; text-align:right;">
	           		<%=order_detailVO.getDate() %>
	           	</div>
           </div>
        </div>
        
    </div>
    <!-- <div align="center">
	        <button class="btn btn-success" type="submit" value="확인" />
			<button class="btn btn-success" type="button" value="수정"><a href="index.jsp" /></button>
		</div> -->
		
		<div align="center">
				<input type="submit" class="btn btn-success" value="확인" />
				<input type="submit" class="btn btn-success" value="수정" />
		</div>
        <br>
        <br>
        <br>
        
</form>
</body>
</html>
