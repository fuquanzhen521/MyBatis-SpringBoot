<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>插入课程页面</title>
</head>

<body>
	<form action="${pageContext.request.contextPath }/course/insertCourse"
		method="post" accept-charset="UTF-8">
		插入选项：
		<table width="100%" border=2>
			<tr>
				<td><input type="hidden" name="schoolId" value="${student.sch_id}">
				    <input type="hidden" name="gradeId" value="${student.gra_id}">
				    <input type="hidden" name="classId" value="${student.cla_id}">
				    <input type="hidden" name="studentId" value="${student.id}">
			     课程名称：<input type="text" name="courseName"></td>
			</tr>
			<tr>
				<td><input type="submit" value="插入" onclick="return confirm('你确定插入吗');" />
				&nbsp;
				<input type="reset">
				&nbsp;
				<input type="button" value="返回" onclick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
	</form>
</body>

</html>