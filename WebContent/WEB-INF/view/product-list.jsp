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
<h1>Product List</h1>

<table>
<c:forEach items="${productL }" var="product">
<tr>
<td>${product.productName }</td>
<td>${product.productCode }</td>
<td>${product.productPrice}</td>
<td><img alt="" src="<c:url value='/photo/${product.productImage }'/>" width="100" height="100"> </td>
</tr>

</c:forEach>


</table>

</body>
</html>