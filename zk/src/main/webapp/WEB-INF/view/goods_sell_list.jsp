<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的商品</title>
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }//resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	/* 分页 */
	function page(cpage){
		window.location.href="getSellList?pageNum="+cpage;
	}
</script>
</head>
<body>
  <h1>商品销售百分比列表</h1>
  <a href="${pageContext.request.contextPath}/getList" class="btn btn-info">商品列表</a>
	<table class="table">
		<thead>
			<tr>
				<th>序号</th>
				<th>商品名称</th>
				<th>商品价格</th>
				<th>销售百分比</th>

			</tr>
		</thead>

		<tbody>
			<c:forEach items="${list}" var="entity">
				<tr>
					<td>${entity.id}</td>
					<td>${entity.name}</td>
					<td>${entity.price}</td>
					<td>${entity.sell}</td>

				</tr>
			</c:forEach>
			<div>${pm.page}</div>
		</tbody>

	</table>
</body>
</html>