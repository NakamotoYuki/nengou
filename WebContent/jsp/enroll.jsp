<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class ="container w-80">
<div class="row">
	<div class="col-md-8 order-md-1">
		<div class="center-block">
			<form action="../RegistController" method="POST">
				<dl>
					<dt>ユーザー名</dt>
					<dd><input type="text" name="user_name"></dd>
					<dt>メールアドレス</dt>
					<dd><input type="text" name="user_mail"></dd>
					<dt>パスワード</dt>
					<dd><input type="text" name="user_password"></dd>
				</dl>
				<input type="submit" value="登録">
			</form>
		</div>
	</div>
<jsp:include page="sidebar.jsp" />
</div>
</div>

</body>
</html>