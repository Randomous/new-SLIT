<%-- 
    Document   : Teacher
    Created on : 10.nov.2017, 10:01:13
    Author     : Helle K. Trygsland
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
           <script src="javascript.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Teacher Page</title>

</head>
<body>
<center><h2>UiA-SLIT for Lærer</h2></center>
Velkommen <%=request.getAttribute("userName") %>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
</body>
</html>
