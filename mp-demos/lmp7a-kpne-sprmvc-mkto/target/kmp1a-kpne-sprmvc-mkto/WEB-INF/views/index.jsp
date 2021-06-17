<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Products Catalog</title>
</head>
<body>
<c:if test="${products.size() > 0}">
	<table>
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Price</th>
			<th>Available</th>
			<th>Created On</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td><c:out value="${product.productId}" /></td>
				<td><c:out value="${product.productName}" /></td>
				<td><c:out value="${product.price}" /></td>
				<td><c:out value="${product.available}" /></td>
				<td><c:out value="${product.createdOn}" /></td>
				<th><form action="deleteProduct">
					<input type="hidden" name="productId"
						   value="${product.productId}" />
					<button type="submit">Remove Product</button>
				</form></th>
			</tr>
		</c:forEach>
	</table>
	<br/><br/>
</c:if>

	<c:if test="${not empty errors}">
		<p style="color: red"><b>Error(s)</b>: ${errors}</p>
	</c:if>
	<br/><br/>
	<form action="saveProduct" method="post">
		<table>
			<tr>
				<td>Product Id : <input type="text" name="productId" value="1"></input>
				</td>
			</tr>
			<tr>
				<td>Product Name: <input type="text" name="productName" value="P1"></input>
				</td>
			</tr>
			<tr>
				<td>Price: <input type="text" name="price" value="5"></input>
				</td>
			</tr>
			<tr>
				<td>Available: <select name="available">
						<option value="Yes">Yes</option>
						<option value="No">No</option>
				</select>
				</td>
			</tr>
		</table>
		<input type="submit" value="Add Product">
	</form>

	<br/><br/> Accessed @ ${serverTime}
</body>
</html>

<!-- 	<form action="saveProduct" method="post" modelAttribute="product">
<table>
<tr>
<td>Product Id : <input type="text" name="productId"></input>
</td>
</tr>
<tr>
<td>Product Name: <input type="text" name="productName"></input>
</td>
</tr>
<tr>
<td>Description : <input type="text" name="price"></input>
</td>
</tr>
<tr>
<td>Available: <select name="available">
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
</td>
</tr>
</table>
<input type="submit" value="Add Product">
</form> -->