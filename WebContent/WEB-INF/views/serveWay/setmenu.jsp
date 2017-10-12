<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${context}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${context}/resources/css/bootstrap-theme.min.css">
<script src="${context}/resources/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- 럭키스트 font -->
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Luckiest+Guy" />

<!-- 보울바이 font -->
<!-- <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Bowlby+One+SC" /> -->

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<!-- 3D버튼 -->
<!-- <link href='http://fonts.googleapis.com/css?family=Ubuntu:400,700&subset=latin,cyrillic,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'> -->


<title>셋트메뉴 선택 PAGE입니다</title>

<script type="text/javascript">
$(document).on('click', '.number-spinner button', function () {    
	var btn = $(this),
		oldValue = btn.closest('.number-spinner').find('input').val().trim(),
		newVal = 0;
	
	if (btn.attr('data-dir') == 'up') {
		newVal = parseInt(oldValue) + 1;
	} else {
		if (oldValue > 0) {
			newVal = parseInt(oldValue) - 1;
		} else {
			newVal = 0;
		}
	}
	btn.closest('.number-spinner').find('input').val(newVal);
});
<!-- 3D버튼 js-->
/* WebFontConfig = {
  google: { families: [ 'Source+Sans+Pro:300,400,600:latin,latin-ext' ] }
};
(function() {
  var wf = document.createElement('script');
  wf.src = ('https:' == document.location.protocol ? 'https' : 'http') +
    '://ajax.googleapis.com/ajax/libs/webfont/1/webfont.js';
  wf.type = 'text/javascript';
  wf.async = 'true';
  var s = document.getElementsByTagName('script')[0];
  s.parentNode.insertBefore(wf, s);
})(); 
 */
</script>

</head>
<body>
<br/><br/><br/>
<div class="header">
<p style="text-align: center;">
<img src="${context}/resources/img/logo.png"></p>
</div>

<form action="setmenuAction" method="post">

		<div class="container-fluid">
			<div class="container">
				<div class="page-header">
					<h2 align="center">SELECT COOKIE / DRINK !</h2>
					<br />
					<div class="row" style="background-color: yellowgreen; font-size: 14pt;">
						<div class="col-xs-4"><h3>LIST</h3></div>
						<div class="col-xs-4"><h3>COOKIE</h3></div>
						<div class="col-xs-4"><h3>QUANTITY</h3></div>
					</div>

					<c:forEach items="${c_list}" var="add">
						<div class="row">
							<div class="col-xs-4">
								<input type="checkbox" name="chk_cookie" value="${add.add_no}" style="width:50px;height50px">
								<img src="${context}/resources/img/${add.add_name}.png" width="100" height="100">
							</div>
							<div class="col-xs-4"><h4>${add.add_name}</h4></div>
							<div class="col-xs-4">
								<!-- <div class="container"> -->
									<!--  <div class="row"> -->
										<!--<div class="col-xs-3 col-xs-offset-3"> -->
											<div class="input-group number-spinner">
												<span class="input-group-btn">
													<button type="button" class="btn btn-default" data-dir="dwn"><span class="glyphicon glyphicon-minus"></span></button>
												</span>
												<input type="text" class="form-control text-center" name="qty" id="qty" value="0">
												<span class="input-group-btn">
													<button type="button" class="btn btn-default" data-dir="up"><span class="glyphicon glyphicon-plus"></span></button>
												</span>
											</div>
										<!-- </div> -->
									<!--</div> -->
								<!-- </div> -->
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
<br />
			<div class="container-fluid">
			<div class="container">
					<div class="row" style="background-color: yellowgreen; font-size: 14pt;">
						<div class="col-xs-4"><h3>LIST</h3></div>
						<div class="col-xs-4"><h3>DRINK</h3></div>
						<!-- <div class="col-xs-3">SIZE</div> -->
						<div class="col-xs-4"><h3>QUANTITY</h3></div>
					</div>
					<c:forEach items="${d_list}" var="add">
						<div class="row">
							<div class="col-xs-4">
								<input type="checkbox" name="chk_drink" value="${add.add_no}" style="width:50px;height50px"> <img
									src="${context}/resources/img/drink.png" width="50" height="100">
							</div>
							<div class="col-xs-4"><h4>${add.add_name}</h4></div>
							<!-- <div class="col-xs-4">
										<div class="container">
											<div class="dropdown">
												<button class="btn btn-default dropdown-toggle" type="button"
													data-toggle="dropdown">
													Size <span class="caret"></span>
												</button>
												<ul class="dropdown-menu">
													<li><a href="#">regular</a></li>
													<li><a href="#">medium</a></li>
												</ul>
											</div>
										</div>
							</div> -->
							<div class="col-xs-4">
								<!-- <div class="container"> -->
									<!--  <div class="row"> -->
										<!-- <div class="col-xs-3 col-xs-offset-3"> -->
											<div class="input-group number-spinner">
												<span class="input-group-btn">
													<button type="button" class="btn btn-default" data-dir="dwn"><span class="glyphicon glyphicon-minus"></span></button>
												</span>
												<input type="text" class="form-control text-center" value="0">
												<span class="input-group-btn">
													<button type="button" class="btn btn-default" data-dir="up"><span class="glyphicon glyphicon-plus"></span></button>
												</span>
											</div>
										<!--</div> -->
									<!--</div> -->
								<!-- </div> -->
							</div>
						</div>
					</c:forEach>
				</div>

				
				<br/>
				
				<div align="center">
					<!-- <button type="button" class="btn btn-primary">주문완료</button> -->
					<input type="submit" class="btn btn-lg btn-success" value="주문완료" /> <a href="confirm.jsp"></a>
				</div>
				<br /> <br />

			</div>
			
			
			
			
	</form>
</body>
</html>