<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>维护页面</title>
</head>

<body>
	<form action="${pageContext.request.contextPath }/teacher/maintain"
		method="post" accept-charset="UTF-8">
		维护选项：
		<table width="100%" border=2>
			<tr>
				<td><input type="hidden" name="schoolId" value="${school.id}">
					学校名称：<input type="text" name="schname" value="${school.name}"
					readonly="readonly"></td>
				<td><input type="hidden" name="gradeId" value="${grade.id}">
					年级名称：<input type="text" name="gradename" value="${grade.name}"
					readonly="readonly"></td>
				<td><input type="hidden" name="classId" value="${classInfo.id}">
					班级名称：<input type="text" name="classname" value="${classInfo.name}"
					readonly="readonly"></td>
				<td><input type="hidden" name="studentId" value="${student.id}">
					学生名称：<input type="text" name="studentname" value="${student.name}"
					readonly="readonly"></td>
				<td><input type="hidden" name="courseId" value="${course.id}">
					课程名称：<input type="text" name="coursename" value="${course.name}"
					readonly="readonly"></td>
			    <td><input type="hidden" name="teacherId" value="${teacher.id}">
					教师名称：<input type="text" name="teachername" value="${teacher.name}"
					readonly="readonly"></td>
			</tr>
		</table>
	</form>

	<pre>
    </pre>

	<form action="${pageContext.request.contextPath }/teacher/select"
		method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td><input type="hidden" name="schoolId" value="${school.id}">
					<input type="hidden" name="gradeId" value="${grade.id}"> 
					<input type="hidden" name="classId" value="${classInfo.id}"> 
					<input type="hidden" name="studentId" value="${student.id}"> 
					<input type="hidden" name="courseId" value="${course.id}"> 
			     教师名称：<input type="text" name="teachername" value="${teachername}"></td>
				<td><input type="reset"></td>
				<td><input type="submit" value="查询" onclick="return true;" /></td>
			</tr>
		</table>
	</form>

	<pre>
    </pre>

	教师列表：
	<table width="100%" border=1>
		<tr>
			<td>教师id</td>
			<td>教师姓名</td>
			<td>课程id</td>
			<td>修改操作</td>
			<td>删除操作</td>
			<td>维护操作</td>
		</tr>
		<c:forEach items="${teacherList}" var="teacher">
			<tr>
				<td>${teacher.id }</td>
				<td>${teacher.name }</td>
				<td>${teacher.cid }</td>
				<td><a
					href="${pageContext.request.contextPath }/teacher/update?id=${teacher.id}&name=${teacher.name}&studentId=${student.id}&courseId=${course.id}">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/teacher/delete?id=${teacher.id}&courseId=${course.id}&studentId=${student.id}&schoolId=${student.sch_id}&gradeId=${student.gra_id}&classId=${student.cla_id}"
					onclick="return confirm('你确定要删除数据吗');">删除</a></td>
				<td><a
					href="${pageContext.request.contextPath }/teacher/maintain?id=${teacher.id}&studentId=${student.id}">维护</a></td>
			</tr>
		</c:forEach>

	</table>

	<pre>
    </pre>

	<!-- 插入  -->
	<form action="${pageContext.request.contextPath }/teacher/insert"
		method="post" accept-charset="UTF-8">
		<table width="100%" border=1>
			<tr>
				<td><input type="hidden" name="studentId" value="${student.id}">
					<input type="hidden" name="courseId" value="${course.id}">
					<input type="submit" value="插入" onclick="return true;" /></td>
			</tr>
		</table>
	</form>
</body>

</html>