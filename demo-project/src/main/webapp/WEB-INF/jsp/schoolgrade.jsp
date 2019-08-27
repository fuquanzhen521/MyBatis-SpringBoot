<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看年级页面</title>
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
			</tr>
		</table>
	</form>

	<pre>
	</pre>

	<form action="${pageContext.request.contextPath }/grade/select"
		method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td>年级名称：<input type="text" name="gradename" value="${grade.name}"></td>
				<td><input type="reset"></td>
				<td><input type="submit" value="查询" onclick="return true;" /></td>
			</tr>
		</table>
	</form>

	<pre>
	</pre>

	年级列表：
	<table width="100%" border=1>
		<tr>
			<td>年级id</td>
			<td>年级名称</td>
			<td>修改操作</td>
			<td>删除操作</td>
			<td>详细信息查看</td>
			<td>查看班级信息</td>
		</tr>
		<c:forEach items="${gradeList }" var="grade">
			<tr>
				<td>${grade.id }</td>
				<td>${grade.name }</td>
				<td><a
					href="${pageContext.request.contextPath }/grade/update?id=${grade.id}&schoolId=${school.id}">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/grade/delete?id=${grade.id}&schoolId=${school.id}"
					onclick="return confirm('你确定要删除数据吗');">删除</a></td>
				<td><a
					href="${pageContext.request.contextPath }/grade/detailed?id=${grade.id}">详细信息</a></td>	
				<td><a
					href="${pageContext.request.contextPath }/grade/maintain?id=${grade.id}&schoolId=${school.id}">查看</a></td>
				<!-- <a href="javascript:var x=10;alert(x)">...</a> -->
			</tr>
		</c:forEach>
	</table>
	
	<!-- 分页  -->
	<div align="right">
	   <input type="button" value="上一页" onclick="javascript:history.go(-1)">   
	   <input type="button" id="modify" value="下一页" onclick="myFunction(${page})">
	</div>    
         
   <script>
       function myFunction(page){
    	   var pageSize=page+1;
    	   alert(pageSize);
	       window.location.href = '${pageContext.request.contextPath }/school/maintain?page='+pageSize; 
	       } 
   </script>
	<pre>
	</pre>

	<!-- 插入  -->
	<form action="${pageContext.request.contextPath }/grade/insert"
		method="post" accept-charset="UTF-8">
		<table width="100%" border=1>
			<tr>
				<td><input type="hidden" name="schoolId" value="${school.id}">
				<input type="submit" value="插入" onclick="return true;" /></td>
			</tr>
		</table>
	</form>

</body>

</html>