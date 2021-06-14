<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>Products Display</h2>
	<table>
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Price</th>
		</tr>
		<c:forEach var="product" items="${productsListUI}">
			<tr>
				<td><c:out value="${product.productId} "></c:out></td>
				<td><c:out value="${product.productName} "></c:out></td>
				<td><c:out value="${product.price}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	
	 <form action="saveProduct" method="post" modelAttribute="product">
      <table>
        <tr>
          <td>
             Product Id : <input type="text" name="productId" >
          </td>
        </tr>
        <tr>
          <td>
            Product Name : <input type="text" name="productName" >
          </td>
        </tr>
        <tr>
          <td>
            Product Price : <input type="text" name="price" >
          </td>
        </tr>
        <tr>
          <td>
            <input type="submit" value="Save Product">
          </td>
        </tr>
      </table>
    </form>
</body>
</html>
