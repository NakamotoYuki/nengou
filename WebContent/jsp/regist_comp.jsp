<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class ="container w-80">
<div class="row">
	<div class="col-md-8 order-md-1">
		<div class="center-block">
			<h3>登録完了</h3>
				<dl>
					<dt>ユーザー名</dt>
					<dd>
						<c:out value="${uesr.user_name}" />
						<c:out value="${uesr.user_mail}" />
					</dd>
					<dt>メールアドレス</dt>
					<dd>
					</dd>
					<dt>パスワード</dt>
					<dd>

					</dd>
				</dl>
		</div>
	</div>
<jsp:include page="sidebar.jsp" />
</div>
</div>


</body>
</html>