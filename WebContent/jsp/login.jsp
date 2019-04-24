<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class ="container w-80">
<div class="row">
	<div class="col-md-8 order-md-1">
		<div class="center-block">
			<form action="../loginController" method="POST">
				<div class="center-block">
					<h5>ユーザーログイン</h5>
					<div class="form-group">
  						<label for="title">ユーザー名</label>
  						<input type="text" class="form-control"  name="user_name">
					</div>
					<div class="form-group">
					  <label for="user_password">パスワード</label>
					  <input type="password" class="form-control" id="user_password" name="user_password">
					</div>
					<div class="form-group">
					  <button type="submit" class="btn btn-default">作成</button>
					</div>
  				<div>
			</div>
		</div>
		</form>
		</div>
	</div>
<jsp:include page="sidebar.jsp" />
</div>
</div>

</body>
</html>