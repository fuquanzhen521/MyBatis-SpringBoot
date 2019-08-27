<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学校详细信息页面</title>
</head>
<body>
	学校列表：
	<table width="100%" border=1>
		<tr>
			<td>学校id:
			    ${school.id }</td>
		</tr>
		<tr>
		    <td>学校名称:
		        ${school.name }</td>
		</tr>
		<tr>
		    <td>是否是985院校:
		        <c:if test="${school.jbw==true}">
						<c:out value="是" />
				</c:if> <c:if test="${school.jbw==false}">
						<c:out value="不是" />
				</c:if>
			</td>
		</tr>
		<tr>
		    <td>是否是211院校:
		        <c:if test="${school.eyy==true}">
						<c:out value="是" />
				</c:if> <c:if test="${school.eyy==false}">
						<c:out value="不是" />
				</c:if>
			</td>
		</tr>
		<tr>	
			<td><input type="button" value="返回" onclick="javascript:history.go(-1)"></td>
		</tr>
			  
	</table>
</body>

</html>