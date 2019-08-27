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
	<form action="${pageContext.request.contextPath }/student/maintain"
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
		 <td>学生姓名： <input type="text" name="studentname"
					value="${student.name}" readonly="readonly"></td>
			</tr>
		</table>
	</form>

	<pre>
    </pre>

	<form action="${pageContext.request.contextPath }/course/select"
		method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td><input type="hidden" name="schoolId" value="${school.id}">
					<input type="hidden" name="gradeId" value="${grade.id}"> 
					<input type="hidden" name="classId" value="${classInfo.id}"> 
					<input type="hidden" name="studentId" value="${student.id}"> 
			     课程名称：<input type="text" name="courseName" value="${course.name}"></td>
				<td><input type="reset"></td>
				<td><input type="submit" value="查询" onclick="return true;" /></td>
			</tr>
		</table>
	</form>

	<pre>
    </pre>

	课程列表：
	<table width="100%" border=1>
		<tr>
			<td>课程id</td>
			<td>课程名称</td>
			<td>修改操作</td>
			<td>删除操作</td>
			<td>查看详细信息</td>
			<td>查看教师信息</td>
		</tr>
		<c:forEach items="${courseList}" var="course">
			<tr>
				<td>${course.id }</td>
				<td>${course.name }</td>
				<td><a
					href="${pageContext.request.contextPath }/course/update?id=${course.id}&name=${course.name}&studentId=${student.id}">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/course/delete?id=${course.id}&studentId=${student.id}&schoolId=${student.sch_id}&gradeId=${student.gra_id}&classId=${student.cla_id}"
					onclick="return confirm('你确定要删除数据吗');">删除</a></td>
				<td><a
					href="${pageContext.request.contextPath }/course/detailed?id=${course.id}&name=${course.name}&studentId=${student.id}">查看详细信息</a></td>
				<td><a
					href="${pageContext.request.contextPath }/course/maintain?id=${course.id}&studentId=${student.id}&schoolId=${student.sch_id}&gradeId=${student.gra_id}&classId=${student.cla_id}">查看</a></td>
			</tr>
		</c:forEach>

	</table>
	
	<!-- 分页  -->
    <form action="${pageContext.request.contextPath }/school/insert"
		method="post" accept-charset="UTF-8">
		<table width="100%" border=2>
			<tr>
                <td align="right">
                    <input type="submit" value="下一页">
                </td>
			</tr>
		</table>
	</form>

	<pre>
    </pre>

	<!-- 插入  -->
	<form action="${pageContext.request.contextPath }/course/insert"
		method="post" accept-charset="UTF-8">
		<table width="100%" border=1>
			<tr>
				<td><input type="hidden" name="studentId" value="${student.id}">
					<input type="submit" value="插入" onclick="return true;" /></td>
			</tr>
		</table>
	</form>
</body>

</html>