<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class ="container w-80">
<div class="row">
	<div class="col-md-8 order-md-1">
		<div class="center-block">
			<h5>${ gengoumei }</h5>
  			<div>
<dl class="row">

	<c:forEach var="eventbean" items="${eventbean}">
		<tr>
  <dt class="col-sm-3">
	<span class=gengou>${eventbean.nengou } ${eventbean.nengou_nen }年</span><br>
	<span class=seireki>${eventbean.event_date }</span>
  </dt>
  <dd class="col-sm-9">
	<p>タイトル : <c:out value="${eventbean.event_title }" /></p>
	<p>内容 : <c:out value="${eventbean.event_detail }" /></p>
  </dd>
  	</c:forEach>
</dl>
			</div>
		</div>
	</div>
<jsp:include page="sidebar.jsp" />
</div>
</div>


</body>
</html>