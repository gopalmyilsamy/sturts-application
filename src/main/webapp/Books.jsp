<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1 align="center">Welcome</h1>
	<div align="center"><input type="button" name="addBook" value="Add New Book"/></div><br>
	<table width="40%" align="center" border="1" cellspacing="0">
		<tr bgcolor="#00FFFF">
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Book Author</th>
			<th>Book Price</th>
			<th colspan="2">Actions</th>
		</tr>
		<s:iterator value="books">
			<tr>
				<td><s:property value="bookId" /></td>
				<td><s:property value="bookName" /></td>
				<td><s:property value="bookAuthor" /></td>
				<td><s:property value="bookPrice" /></td>
				<td><input type="button" name="update" value="update"></td>
				<td><input type="button" name="delete" value="delete"></td>
			</tr>
		</s:iterator>
	</table>

</body>
</html>