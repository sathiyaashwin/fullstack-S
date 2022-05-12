<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello....</title>
</head>
<body>
<h1>${title}</h1>

<form:form method = "post"  modelAttribute="command">

<label>productId</label>
<form:input path="productId"/>
<label>productName</label>
<form:input path="productName"/>
<label>productPrice</label>
<form:input path="price"/>

<input type ="submit" value="Add">

</form:form>

</body>
</html>