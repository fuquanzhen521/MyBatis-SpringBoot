<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
		<h1 style="text-align: center">欢迎来到首页</h1>
		<table width="100%" border=1>
		    <tr>
		         <td><a
					href="${pageContext.request.contextPath }/school/list">学校信息</a></td>
				 <td><a
					href="${pageContext.request.contextPath }/course/list">课程信息</a></td>
		    </tr>
		</table>
</body>
</html>