<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Category List</h1>

<table>
<c:forEach items="${categoryList}" var="category"> 

<tr>
<td>${category.categoryId}</td>
<td>${category.categoryName}</td>
<td><a href="edit-category?categoryId=${category.categoryId}">Edit</a></td>
<td><a href="${pageContext.request.contextPath}/delete-category/${category.categoryId}">Delete</a></td>
</tr>

</c:forEach>

</table>

</body>
</html>