<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改班级页面</title>
</head>

<body>
	<form action="${pageContext.request.contextPath }/class/updateClass"
		method="post" accept-charset="UTF-8">
		修改选项：
		<table width="100%" border=2>
		    <tr>
				<td><input type="hidden" name="schoolId" value="${school.id}">
				<input type="hidden" name="gradeId" value="${grade.id}">
				<input type="hidden" name="classId" value="${classInfo.id }">
				班级名称：<input type="text" name="classname" value="${classInfo.name }"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="sch_id" value="${classInfo.sch_id}">
				<input type="hidden" name="gra_id" value="${classInfo.gra_id}">
				<input type="submit" value="更新" onclick="return confirm('你确定要更新数据吗');" />
				&nbsp;
				<input type="reset">
				&nbsp;
				<input type="button" value="返回" onclick="javascript:history.go(-1)">
				</td>
			</tr>

		</table>
	</form>
</body>

</html>