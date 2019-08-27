<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/jquery.datetimepicker.css" />
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.datetimepicker.full.js"></script>
<title>插入学生页面</title>
</head>

<body>
	<form
		action="${pageContext.request.contextPath }/student/insertStudent"
		method="post" accept-charset="UTF-8">
		插入选项：
		<table width="100%" border=2>
			<tr>
				<td>学生姓名：<input type="text" name="studentname"></td>
			</tr>
			<tr>
				<td>出生日期： <input type="text" name="birthday" id="datetimepicker4" /> 
				           <input id="open" type="button" value="打开日历" />
					       <input id="close" type="button" value="关闭日历" /> 
					       <input id="reset" type="button" value="重置日历" />
				</td>
			</tr>
			<tr>
				<td>性别： <select name="sex">
						<option selected="selected"></option>
						<option value="1">男</option>
						<option value="2">女</option>
				</select>
				</td>
			</tr>
			<tr>
				<td><input type="hidden" name="schoolid" value="${school.id}">
					<input type="hidden" name="gradeid" value="${grade.id}"> 
					<input type="hidden" name="classid" value="${classInfo.id}"> 
					<input type="submit" value="插入" onclick="return confirm('你确定插入吗');" />
			 &nbsp; <input type="reset"> &nbsp; <input type="button"
					value="返回" onclick="javascript:history.go(-1)"></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
$('#datetimepicker4').datetimepicker();
$('#open').click(function(){
	$('#datetimepicker4').datetimepicker('show');
});
$('#close').click(function(){
	$('#datetimepicker4').datetimepicker('hide');
});
$('#reset').click(function(){
	$('#datetimepicker4').datetimepicker('reset');
});
</script>

</html>
