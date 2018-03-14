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
<h1>Product Form</h1>

<form action="add-product" method="post" enctype="multipart/form-data">

Category: 
<select name="category.categoryId">
	<option>Select Category</option>
	<c:forEach items="${categoryList}" var="category">
	<option value="${category.categoryId}">${category.categoryName}</option>
	</c:forEach>
</select>


Product NAme: <input type="text" name="productName">
Product Code: <input type="text" name="productCode">
product Price:<input type="text" name="productPrice">
Product Image:<input type="file" name="image">
<input type="submit" value="save">
</form>



</body>
</html>