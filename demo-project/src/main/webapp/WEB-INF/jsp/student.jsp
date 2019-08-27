<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询学生列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/student/list"
		method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td><input type="submit" value="插入" /></td>
			</tr>
		</table>
		学生列表：
		<table width="100%" border=1>
			<tr>
				<td>学生id</td>
				<td>学生姓名</td>
				<td>学校生日</td>
				<td>学生性别</td>
				<td>学校id</td>
				<td>年级id</td>
				<td>班级id</td>
			</tr>
			<c:forEach items="${stuList }" var="stu">
				<tr>
					<td>${stu.id }</td>
					<td>${stu.name }</td>
					<td>${stu.birthday }</td>
					<td>${stu.sex }</td>
					<td>${stu.sch_id }</td>
					<td>${stu.gra_id }</td>
					<td>${stu.cla_id }</td>
				</tr>
			</c:forEach>

		</table>
	</form>
</body>

</html>