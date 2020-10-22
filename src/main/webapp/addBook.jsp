<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Book</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div align="center">
		<h2>Add New Book</h2>
		<s:form action="addAction">
		<table width="40%" align="center" border="1" cellspacing="0">
		<tr>
			<td><s:textfield name="bookId" label="Book Id"/></td>
		</tr>
		<tr>
			<td><s:textfield name="bookName" label="Book Name"/></td>
		</tr>
		<tr>
			<td><s:textfield name="bookAuthor" label="Book Author"/></td>
		</tr>
		<tr>
			<td><s:textfield name="bookPrice" label="Book Price"/></td>
		</tr>
		</table>
			<div align="center"><s:submit value="Add Book"/></div>
		</s:form>
	</div>
</body>
</html>