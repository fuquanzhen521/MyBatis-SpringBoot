<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看班级页面</title>
</head>

<body>
	<form action="${pageContext.request.contextPath }/grade/maintain"
		method="post" accept-charset="UTF-8">
		查看选项：
		<table width="100%" border=2>
			<tr>
				<td><input type="hidden" name="schoolId" value="${school.id}">
					学校名称：<input type="text" name="schname" value="${school.name}"
					readonly="readonly"></td>
				<td><input type="hidden" name="gradeId" value="${grade.id}">
					年级名称：<input type="text" name="gradename" value="${grade.name}"
					readonly="readonly"></td>
			</tr>
		</table>
	</form>

	<pre>
    </pre>

	<form action="${pageContext.request.contextPath }/class/select"
		method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td><input type="hidden" name="schoolId" value="${school.id}">
					<input type="hidden" name="gradeId" value="${grade.id}">
					班级名称：<input type="text" name="classname" value="${classInfo.name}"></td>
				<td><input type="reset"></td>
				<td><input type="submit" value="查询" onclick="return true;" /></td>
			</tr>
		</table>
	</form>

	<pre>
    </pre>

	班级列表：
	<table width="100%" border=1>
		<tr>
			<td>班级id</td>
			<td>班级名称</td>
			<td>修改操作</td>
			<td>删除操作</td>
			<td>详细信息查看</td>
			<td>查看学生信息</td>
		</tr>
		<c:forEach items="${classList }" var="classInfo">
			<tr>
				<td>${classInfo.id }</td>
				<td>${classInfo.name }</td>
				<td><a
					href="${pageContext.request.contextPath }/class/update?id=${classInfo.id}&schoolId=${school.id}&gradeId=${grade.id}">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/class/delete?id=${classInfo.id}&schoolId=${school.id}&gradeId=${grade.id}"
					onclick="return confirm('你确定要删除数据吗');">删除</a></td>
				<td><a
					href="${pageContext.request.contextPath }/class/detailed?id=${classInfo.id}&schoolId=${school.id}&gradeId=${grade.id}">详细信息</a></td>
				<td><a
					href="${pageContext.request.contextPath }/class/maintain?id=${classInfo.id}&schoolId=${school.id}&gradeId=${grade.id}">查看</a></td>
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

	<%-- <!-- 插入  -->
	<form>
		<table width="100%" border=2>
			<tr>
				<td><a
					href="${pageContext.request.contextPath }/class/insert?schoolId=${school.id}&gradeId=${grade.id}">插入</a></td>
			</tr>
		</table>
	</form> --%>

	<!-- 插入  -->
	<form action="${pageContext.request.contextPath }/class/insert"
		method="post" accept-charset="UTF-8">
		<table width="100%" border=1>
			<tr>
				<td><input type="hidden" name="schoolId" value="${school.id}">
					<input type="hidden" name="gradeId" value="${grade.id}"> <input
					type="submit" value="插入" onclick="return true;" /></td>
			</tr>
		</table>
	</form>

</body>

</html>