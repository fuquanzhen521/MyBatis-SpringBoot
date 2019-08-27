<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看学生选修课页面</title>
</head>
<body>
	学生选修课列表：
	<table width="100%" border=1>
	   <tr>
	        <td>id</td>
			<td>学生id</td>
			<td>课程id</td>
			<td>课程名称</td>
			<td>教师id</td>
			<td>学生成绩</td>
		</tr>
		<c:forEach items="${electiveList}" var="electivecourse">
			<tr>
				<td>${electivecourse.id }</td>
				<td>${electivecourse.sid }</td>
				<td>${electivecourse.cid }</td>
				<td>${electivecourse.name}</td>
				<td>${electivecourse.tid }</td>
				<td>${electivecourse.score}</td>
			</tr>
		</c:forEach>
		<tr>
			<td><input type="button" value="返回" onclick="javascript:history.go(-1)"></td>
		</tr>

		<tr>
		   <td><a
				href="${pageContext.request.contextPath }/elective/insert?sid=${electivecourse.sid}">更新该学生选课信息</a></td>
		</tr>
	</table>
	
</body>

</html>