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
	<form action="${pageContext.request.contextPath }/grade/maintain"
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
			</tr>
		</table>
	</form>

	<pre>
    </pre>

	<form action="${pageContext.request.contextPath }/student/select"
		method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td><input type="hidden" name="schoolId" value="${school.id}">
					<input type="hidden" name="gradeId" value="${grade.id}"> 
					<input type="hidden" name="classId" value="${classInfo.id}"> 
			     学生姓名：<input type="text" name="studentName" value="${student.name}"></td>
				<td>性别： <select name="sex">
						<option <c:if test="${student.sex==null}">selected</c:if>></option>
						<option value="1" <c:if test="${student.sex==1}">selected</c:if> >男</option>
						<option value="2" <c:if test="${student.sex==2}">selected</c:if>>女</option>
				       </select>
				</td>
				<td><input type="reset"></td>
				<td><input type="submit" value="查询" onclick="return true;" /></td>
			</tr>
		</table>
	</form>

	<pre>
    </pre>

	学生列表：
	<table width="100%" border=1>
		<tr>
			<td>学生id</td>
			<td>学生姓名</td>
			<td>修改操作</td>
			<td>删除操作</td>
			<td>查看选课信息</td>
			<td>学生详细信息</td>
			<td>查看课程信息</td>
		</tr>
		<c:forEach items="${studentList}" var="student">
			<tr>
				<td>${student.id }</td>
				<td>${student.name }</td>
				<td><a
					href="${pageContext.request.contextPath }/student/update?id=${student.id}&classId=${classInfo.id}&schoolId=${school.id}&gradeId=${grade.id}">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/student/delete?id=${student.id}&schoolId=${school.id}&gradeId=${grade.id}&classId=${classInfo.id}"
					onclick="return confirm('你确定要删除数据吗');">删除</a></td>
				<td><a
					href="${pageContext.request.contextPath }/student/add?id=${student.id}&classId=${classInfo.id}&schoolId=${school.id}&gradeId=${grade.id}">查看选课信息</a></td>
				<td><a
					href="${pageContext.request.contextPath }/student/detailed?id=${student.id}">详细信息</a></td>
				<td><a
					href="${pageContext.request.contextPath }/student/maintain?id=${student.id}&schoolId=${school.id}&gradeId=${grade.id}&classId=${classInfo.id}">查看</a></td>
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
	<form action="${pageContext.request.contextPath }/student/insert"
		method="post" accept-charset="UTF-8">
		<table width="100%" border=1>
			<tr>
				<td><input type="hidden" name="schoolId" value="${school.id}">
					<input type="hidden" name="gradeId" value="${grade.id}"> 
					<input type="hidden" name="classId" value="${classInfo.id}"> 
					<input type="submit" value="插入" onclick="return true;" /></td>
			</tr>
		</table>
	</form>
</body>

</html>