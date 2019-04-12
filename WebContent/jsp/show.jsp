<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="eventbean" scope="request" type="event.EventBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/nengou/css/bootstrap.min.css">
<link rel="stylesheet" href="/nengou/css/custom.css">
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery-3.2.1.slim.min.js"></script>
<script src="../js/popper.min.js"></script>

<title>元号できごと</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show.jsp</title>
</head>
<body>

<div class="jumbotron d-flex justify-content-between mb-0">
</div>

<nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse mb-40">
    <ul class="navbar-nav mr-auto w-80 container">
	<li class="nav-item list-inline-item"><a class="nav-link"  href="/">ホーム</a></li>
	<li class="nav-item list-inline-item"><a class="nav-link"  href="#">明治</a></li>
	<li class="nav-item list-inline-item"><a class="nav-link"  href="#">大正</a></li>
	<li class="nav-item list-inline-item"><a class="nav-link"  href="#">昭和</a></li>
	<li class="nav-item list-inline-item"><a class="nav-link"  href="#">平成</a></li>
	<li class="nav-item list-inline-item"><a class="nav-link"  href="#">令和</a></li>
    </ul>
</nav>

<div class ="container w-80">
<div class="row">
	<div class="col-md-8 order-md-1">
		<div class="center-block">
			<h5><c:out value="${eventbean.event_title}" /></h5>
				<p>
					<img src="http://bootstrap3.cyberlab.info/img/sample-256x256.png" alt="犬" align="left">
					<span><c:out value="${eventbean.event_detail}" /></span>
				</p>
  			<div>
			</div>
		</div>
	</div>
	<div class="col-md-4 order-md-2">
		<div class="center-block">
			<h5>このサイトについて</h5>
  			<div class="center-block">
				<p>このサイトはユーザー参加型の歴史年表です。</p>
			</div>
		</div>
		<div class="center-block">
			<h5>出来事の新規追加</h5>
  			<div class="center-block">
				<p>過去起きた出来事を新規で自由に登録することができます。</p>
				<button type="button" class="btn btn-primary">新規追加</button>
			</div>
		</div>
	</div>
</div>
</div>
</body>
</html>