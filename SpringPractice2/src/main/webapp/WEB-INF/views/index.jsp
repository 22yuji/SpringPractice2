<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Spring Practice 2</title>
	</head>
	<body>
		<form:form action="result" modelAttribute="index">
		  <div>
		  	<label>名前：</label>
		  	<form:input path="name" /><br>
		  	<label>商品：</label>
		    <form:select path="id">
		      <form:options items="${productList}" itemLabel="productName" itemValue="productId" />
		    </form:select>
		  </div>
		  <form:button>送信</form:button>
		</form:form>
	</body>
</html>