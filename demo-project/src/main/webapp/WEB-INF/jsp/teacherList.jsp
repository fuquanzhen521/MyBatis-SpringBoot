<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询教师列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/teacher/list"
		method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td><input type="submit" value="插入" /></td>
			</tr>
		</table>
		教师列表：
		<table width="100%" border=1>
			<tr>
				<td>教师id</td>
				<td>教师名称</td>
				<td>课程id</td>
			</tr>
			<c:forEach items="${teaList }" var="tea">
				<tr>
					<td>${tea.id }</td>
					<td>${tea.name }</td>
					<td>${tea.cid }</td>
				</tr>
			</c:forEach>

		</table>
	</form>
</body>

</html>