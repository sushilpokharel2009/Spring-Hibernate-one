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
<h1>My Cart</h1>
<table>
<c:set var="total" value="${0}" />
<c:forEach items="${cartProductList}" var="cartProduct">

<tr>
<td><img alt=""
							src="<c:url value='/photo/${cartProduct.productImage }'/>"
							width="100" height="100"></td>
						<td>${cartProduct.productName }</td>
						<td>${cartProduct.productCode }</td>
						<td>${cartProduct.productPrice}</td>
						<c:set var="total" value="${total + cartProduct.productPrice}" />
</tr>
</c:forEach>
</table>
<br>
<br>
${total}
</body>
</html>