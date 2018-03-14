<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/signup">Sign Up</a>
<br><br><br><br>

Welcone : ${verifiedGeneralUser.generalUserName }

<br><br><br><br>
	<h1>Home</h1>
	<table width="900"> 

		<tr>
			<td width="300">Category: <c:forEach items="${categoryList}" var="category">
			<table>
					<tr>
						<td><a href="${pageContext.request.contextPath}/home/${category.categoryId}">${category.categoryName}</a></td>
					</tr>
					</table>
				</c:forEach>
			</td>

			<td width="500"><c:forEach items="${productList}" var="product">
				<table>
				
					<tr>
						<td>${product.productName }</td>
						<td>${product.productCode }</td>
						<td>${product.productPrice}</td>
						<td><img alt=""
							src="<c:url value='/photo/${product.productImage }'/>"
							width="100" height="100"></td>
							<td><a href="${pageContext.request.contextPath}/add-cart/${product.productId}">Add To Cart</a></td>
					</tr>
					</table>
				</c:forEach>
				</td>

		</tr>




	</table>
</body>
</html>