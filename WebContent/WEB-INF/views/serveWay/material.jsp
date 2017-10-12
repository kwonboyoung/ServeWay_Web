<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<style>
.button {
    background-color: #4CAF50;
    border: none;
    color: yellowgreen;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    width : 200px;
    height : 42px;
 
}

.button1 {
    background-color: yellowgreen; 
    color: black; 
    border: 0px solid #33FF9F;
    border-radius: 10px;
}

.button2 {
    background-color: yellowgreen; 
    color: black; 
    border: 0px solid #33FF9F;
}

.button3 {
    background-color: yellowgreen; 
    color: black; 
    border: 0px solid #33FF9F;
}

.button4 {
    background-color: yellowgreen;
    color: black;
    border: 0px solid #33FF9F;
}



.submitbutton {
	background-color:brown;
   width : 200px;
   height : 42px;

}





</style>




<script type="text/javascript">
 
var maxChecked = 3;   //선택가능한 체크박스 갯수
var totalChecked = 0; // 설정 끝
function CountChecked(field) {
    if (field.checked)
        totalChecked += 1;
    else
        totalChecked -= 1;
    if (totalChecked > maxChecked) {
        alert ("최대 3개 까지만 가능합니다.");
    field.checked = false;
    totalChecked -= 1;
    }
    
}
function ResetCount(){
    totalChecked = 0;
}

</script>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${context}/resources/css/bootstrap.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="${context}/resources/js/bootstrap.min.js"></script>
	
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Luckiest+Guy" />
	
</head>

<body>
<br/><br/><br/>
<div class="header">
<p style="text-align: center;">
<img src="${context}/resources/img/logo.png"></p>
</div>
	<FORM action="materialListAction" method="post" name="mainForm">

		<div class="text" align="center">
			<h1>
				 ORDER DETAIL
			</h1>
			<h4><span style="background-color:#ffd799"><font face="">PICK BREAD, VEGETABLES, 3SAU!</font></h4>
		</span></div>

		<div id="myCarousel" class="carousel slide" align="center">
			<div class="carousel-buttons" align="center">

				<a data-target="#myCarousel" data-slide-to="0" href="#"><button
						class="button button1">BREAD</button></a> <a
					data-target="#myCarousel" data-slide-to="1" href="#"><button
						class="button button1">VEGETABLE</button></a> <a
					data-target="#myCarousel" data-slide-to="2" href="#"><button
						class="button button1">SAUCE</button></a> <a
					data-target="#myCarousel" data-slide-to="3" href="#"><button
						class="button button1">EXTRA</button></a>
			</div>
			<div class="carousel-inner">
				<div class="item active">
					<img src="${context}/resources/img/lime2.png"
						style="height: 400; width: 835;">
					<div class="container">
						<div class="carousel-caption">
							<table align="center">
								<c:forEach items="${b_list}" var="BVO" varStatus="bt">
								<c:if test="${bt.count % 2 == 1}"><tr></c:if>
										<td><input type="radio" name="bread" class = "dataname"
											value="${BVO.material_no}" /> 
											${BVO.material_name}</td>
										<td><img src="${context}/resources/img/${BVO.material_name}.jpg"
											width="100" height="100" class = "samenameimg"></td>
										
								<c:if test="${bt.count % 2 == 0}"></tr></c:if>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
				<div class="item">
					<img src="${context}/resources/img/lime2.png"
						style="height: 600; width: 835;">
					<div class="container">
						<div class="carousel-caption">

							<table align="center">
								<c:forEach items="${v_list}" var="VVO" varStatus="vt">
								<c:if test = "${vt.count % 2 == 1}"><tr></c:if>
										<td><input type="checkbox" checked="checked" name=vegetable
											value="${VVO.material_no}" />
											${VVO.material_name}</td>
										<td><img src="${context}/resources/img/${VVO.material_name}.jpg"
											width="100" height="100"></td>
								<c:if test="${vt.count %2 == 0}"></tr></c:if>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
				<div class="item">
					<img src="${context}/resources/img/lime2.png"
						style="height: 900; width: 835;">
					<div class="container">
						<div class="carousel-caption">
<!-- onclick=CountChecked(this) -->
						
							<table align="center">
								<FORM action=# id="srclimit" method=post name=Check>
								<c:forEach items="${s_list}" var="SVO" varStatus="st">
										<c:if test="${st.count%2 == 1}"><tr></c:if>
											<td><input type="checkbox" onclick=CountChecked(this)
												name=source value="${SVO.material_no}" />
												${SVO.material_name}</td>
											<td><img src="${context}/resources/img/${SVO.material_name}.jpg"
												width="100" height="100"></td>
										<c:if test="${st.count%2==0}"></tr></c:if>
								</c:forEach>
								</FORM>
							</table>
						





						</div>
					</div>
				</div>
				<div class="item">
					<img src="${context}/resources/img/lime2.png"
						style="height:450; width: 835;">
					<div class="container">
						<div class="carousel-caption">



							<table align="center">
							
							
								<c:forEach items="${extra_list}" var="EVO" varStatus ="ex">
									<c:if test="${ex.count%2 ==1}"><tr></c:if>
										<td><input type="checkbox" name=addition
											value="${EVO.add_no}" /> 
											${EVO.add_name}</td>
										<td><img src="${context}/resources/img/${EVO.add_name}.jpg"
											width="100" height="100"></td>
									<c:if test="${ex.count%2 ==0}"></tr></c:if>
								</c:forEach>
								</table>
								
								<table align="center">
								
								<tr>
								<td>

								
								<p>★</p>
								
								
								</td>
								
								</tr>
								
								
								
								</table>
								
								
								
								
															
								<table align = "center">
								<tr>
								<td><p>Text us more detailed order!!</p></td>
								</tr>
								</table>
								
								<table align = "center">
								
								<tr>
								<font color="black"><textarea cols="50" rows="5" name="content" align = "center"> </textarea></font>
								</tr>
								</table>


						</div>
					</div>
				</div>
			</div>

		</div>


		<div class="container-fluid">

			<div class="row">
				<div class="col-sm-12" style="background-color: white;">

					<!-- 
			
			<table>
			<tr>
			<td>※상세 부탁사항을 입력해주세요.</td>
			</tr>
 
			<tr>
				<td><textarea cols="190" rows="5" name="content"
				required="required" class="col-sm-12"></textarea></td>
			</tr>
			
			</table>
			</div>
			</div>
-->


					<center>
					<input type="submit" class="btn btn-lg btn-success" value="NEXT" />
					</center>
	</FORM>
</body>
</html>