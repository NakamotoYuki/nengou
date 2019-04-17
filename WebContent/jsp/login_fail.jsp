<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class ="container w-80">
<div class="row">
	<div class="col-md-8 order-md-1">
		<div class="center-block">
			<h2>ログイン失敗</h2>
			<p>ユーザー名もしくはパスワードが異なります。</p>
			<p><a href="/jsp/login.jsp">再度ログインしなおしてください。</a></p>
		</div>
	</div>
<jsp:include page="sidebar.jsp" />
</div>
</div>
</body>
</html>