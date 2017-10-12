<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="order" value="${sessionScope.order}" />
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="../favicon1.ico"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${context}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${context}/resources/css/bootstrap-theme.min.css">
<script src="${context}/resources/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- 럭키스트 font -->
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Luckiest+Guy" />

</head>
<body>
<div class="header">
<p style="text-align: center;">
<img src="${context}/resources/img/logo.png"></p>
</div>
<form action="selectmenuAction" method="post">
<br>
<br>
<br>
<div class="container">
   <div class="jumbotron" align="center">
<%-- ${sessionScope.order} --%>
<h1>select menu</h1>
   </div>
<table>
<tr valign="top">
<c:forEach items="${menus}" var="menu" varStatus="row">
<td align="right">
   <h3 class="text-center">${menu}</h3>   
   <c:forEach items="${f_list}" var="foodVO"  varStatus="col">

       <c:if test="${foodVO.kind == menu}">
               <span title="사 이 즈: 15cm,
가     격: ${foodVO.price}원,
칼 로 리: ${foodVO.f_cal}cal,
고기종류: ${foodVO.meat},
영양성분: ${foodVO.nutrition}"><br>
                  <input type="radio" name="f_no" value="${foodVO.f_no}" checked="checked"/>${foodVO.f_name}<img src="${context}/resources/img/${foodVO.f_name}.png" style="height:100px;"></a></span><br>
            <br><br><br>
      </c:if>
      </div>   
   </c:forEach>
   </td>
   <c:if test="${row.count==2}"></tr><tr valign="top"></c:if> 
</c:forEach>
</tr>
</table>
   
   <div class="container" align="center">
      <!-- <div class="col-sm-6" >
      <input type="button" class="btn btn-lg btn-success" value="previous step"><a href="javascript:history.back();"></a></input>
      </div> -->
 <!--      <div class="button" > -->
      <input type="submit" class="btn btn-lg btn-success" value="NEXT"/>
      <!-- </div> -->
   </div>        
</div>
</form>
</body>
</html>