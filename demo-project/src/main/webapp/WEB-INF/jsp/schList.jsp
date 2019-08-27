<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询学校页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/school/select"
		method="post" accept-charset="UTF-8">
		查询条件：
		<table width="100%" border=2>
			<tr>
				<td>学校名称：<input type="text" name="schname" value="${school.name}"></td>
				<td>是否985： <select name="jbw">
						<option <c:if test="${school.jbw==null}">selected</c:if>></option>
						<option value="true"
							<c:if test="${school.jbw==true}">selected</c:if>>是</option>
						<option value="false"
							<c:if test="${school.jbw==false}">selected</c:if>>不是</option>
				          </select>
				</td>

				<td>是否211： <select name="eyy">
						<option <c:if test="${school.eyy==null}">selected</c:if>></option>
						<option value="true"
							<c:if test="${school.eyy==true}">selected</c:if>>是</option>
						<option value="false"
							<c:if test="${school.eyy==false}">selected</c:if>>不是</option>
			              </select>
				</td>

				<td><input type="reset"></td>
				<td><input type="submit" value="查询" /></td>
			</tr>
		</table>

	</form>
	<pre>
    </pre>
	学校列表：
	<table width="100%" border=1>
		<tr>
			<td>学校id</td>
			<td>学校名称</td>
			<td>修改操作</td>
			<td>删除操作</td>
			<td>详细信息查看</td>
			<td>查看年级信息</td>
		</tr>
		<c:forEach items="${schoolList}" var="school">
			<tr>
				<td>${school.id }</td>
				<td>${school.name }</td>
				<td><a
					href="${pageContext.request.contextPath }/school/update?id=${school.id}">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/school/delete?id=${school.id}"
					onclick="return confirm('你确定要删除数据吗');">删除</a></td>
				<td><a
					href="${pageContext.request.contextPath }/school/detailed?id=${school.id}">详细信息</a></td>
				<td><a
					href="${pageContext.request.contextPath }/school/maintain?id=${school.id}">查看</a></td>
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
	       window.location.href = '${pageContext.request.contextPath }/school/list?page='+pageSize; 
	       } 
   </script>
   
	<pre>
    </pre>

	<!-- 插入  -->
	<form action="${pageContext.request.contextPath }/school/insert"
		method="post" accept-charset="UTF-8">
		<table width="100%" border=2>
			<tr>
				<td><input type="submit" value="插入" onclick="return true;" /></td>
			</tr>
		</table>
	</form>
</body>

</html>