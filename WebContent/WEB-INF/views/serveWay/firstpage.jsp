<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="../favicon1.ico" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${context}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${context}/resources/css/bootstrap-theme.min.css">
<script src="${context}/resources/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- 럭키스트 font -->
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Luckiest+Guy" />

</head>
<body>
<br/><br/><br/>
<div class="header">
<p style="text-align: center;">
<img src="${context}/resources/img/logo.png"></p>
</div>
   <form action="firstpageAction" method="post">
      <div align="center">
         <div class="container">
         	<div class="col-sm-6" align="center">
            <dl>
               <dt>
                  <input type="radio" name="type_no" value="1" checked="checked" /><img
                     src="${context}/resources/img/SANDWICH.png"
                     style="height: 168px; width: 210px;"></a>
               </dt>
               <dd><h1>SANDWICH</h1></dd>
               </div>
               <br>
               <div class="col-sm-6" align="center">
               <dt>
                  <input type="radio" name="type_no" value="2" /><img
                     src="${context}/resources/img/SALAD.png"
                     style="height: 168px; width: 210px;"></a>
               </dt>
               <dd><h1>SALAD</h1></dd>
               </div>
            </dl>
         </div>
      </div>
      <br/><br/>
      <div align="center"><input type="submit" class="btn btn-lg btn-success" value="NEXT" /></div>
   </form>
</body>
</html>