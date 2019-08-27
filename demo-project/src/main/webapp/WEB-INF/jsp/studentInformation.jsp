<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生详细信息页面</title>
</head>
<body>
	学生列表：
	<table width="100%" border=1>
		<tr>
			<td>学生id: ${student.id }</td>
		</tr>
		<tr>
			<td>学生姓名: ${student.name }</td>
		</tr>
		<tr>
			<td>学生出生年月: ${dateStr}</td>
		</tr>
		<tr>
			<td>学生性别: 
			  <c:if test="${student.sex==1}">
						<c:out value="男" />
				</c:if> <c:if test="${student.sex==2}">
						<c:out value="女" />
				</c:if>
			</td>
		</tr>
		<tr>
			<td>学校id: ${student.sch_id}</td>
		</tr>
		<tr>
			<td>年级id: ${student.gra_id}</td>
		</tr>
		<tr>
			<td>班级id: ${student.cla_id}</td>
		</tr>
		<tr>
			<td><input type="button" value="返回"
				onclick="javascript:history.go(-1)"></td>
		</tr>

	</table>
</body>

</html>