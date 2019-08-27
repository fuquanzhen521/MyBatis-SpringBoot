<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师详细信息页面</title>
</head>
<body>
	教师列表：
	<table width="100%" border=1>
		<tr>
			<td>教师id:
			    ${teacher.id }</td>
		</tr>
		<tr>
		    <td>教师姓名:
		        ${teacher.name }</td>
		</tr>
		<tr>
		   <td>课程id:
		        ${teacher.cid }
		   </td>
		</tr>
		<tr>	
			<td><input type="button" value="返回" onclick="javascript:history.go(-1)"></td>
		</tr>
			  
	</table>
</body>

</html>