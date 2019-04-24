<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class ="container w-80">
<div class="row">
	<div class="col-md-8 order-md-1">
		<div class="center-block">
			<c:forEach var="eventbean" items="${eventbean}">
				<h5>${eventbean.event_title }</h5>
				<p><span class=seireki>${eventbean.event_date }</span></p>
				<p><img src="http://bootstrap3.cyberlab.info/img/sample-256x256.png" alt="犬" align="left"></p>
				<p><c:out value="${eventbean.event_detail }" /></p>
  			</c:forEach>

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