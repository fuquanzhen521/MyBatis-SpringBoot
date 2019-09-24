<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学校列表页面</title>
</head>
<body>
	学校列表：
	<table width="100%" border=1>
		<tr>
			<td>学校id</td>
			<td>学校名称</td>
			<td>修改操作</td>
			<td>删除操作</td>
			<td>详细信息查看</td>
			<td>查看年级信息</td>
		</tr>
		<c:forEach items="${list}" var="school">
			<tr>
				<td>${school.id }</td>
				<td>${school.name }</td>
				<td><a
					href="${pageContext.request.contextPath }/school/update?id=${school.id}">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/school/delete?id=${school.id}"
					onclick="return confirm('你确定要删除数据吗');">删除</a></td>
				<td><a
					href="${pageContext.request.contextPath }/school/detailed?id=${school.id}">详细信息</a></td>
				<td><a
					href="${pageContext.request.contextPath }/school/maintain?id=${school.id}">查看</a></td>
			</tr>
		</c:forEach>

	</table>
</body>

</html>