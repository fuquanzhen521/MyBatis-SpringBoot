<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询班级列表</title>
</head>

<body>
	<form action="${pageContext.request.contextPath }/class/select"
		method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td>班级名称：<input type="text" name="classname"></td>
				<td>学校id：<input type="text" name="schoolid"></td>
				<td>年级id：<input type="text" name="gradeid"></td>
				<td><input type="reset"></td>
				<td><input type="submit" value="查询" onclick="return true;" /></td>
			</tr>
		</table>
	</form>

	班级列表：
	<table width="100%" border=1>
		<tr>
			<td>班级id</td>
			<td>班级名称</td>
			<td>学校id</td>
			<td>年级id</td>
		</tr>
		<c:forEach items="${classList }" var="classInfo">
			<tr>
				<td>${classInfo.id }</td>
				<td>${classInfo.name }</td>
				<td>${classInfo.sch_id }</td>
				<td>${classInfo.gra_id }</td>
				<td><a href="${pageContext.request.contextPath }/class/update?id=${classInfo.id}">修改</a></td>
				<td><a href="${pageContext.request.contextPath }/class/delete?id=${classInfo.id}" onclick="return confirm('你确定要删除数据吗');">删除</a></td>
			</tr>
		</c:forEach>

	</table>

	<!-- 插入  -->
	<form action="${pageContext.request.contextPath }/class/insert"
		method="post" accept-charset="UTF-8">
		<table width="100%" border=2>
			<tr>
				<td><input type="submit" value="插入" onclick="return true;" /></td>
			</tr>
		</table>
	</form>

</body>

</html>