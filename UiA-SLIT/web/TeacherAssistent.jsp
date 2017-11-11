<%-- 
    Document   : TeacherAssistent
    Created on : 10.nov.2017, 10:02:04
    Author     : Helle K. Trygsland
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Teacher Assistent Page</title>
</head>
<body>
<center><h2>UiA-SLIT for Hjelpelærer</h2></center>
Velkommen <%=request.getAttribute("userName") %>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
</body>
</html>
