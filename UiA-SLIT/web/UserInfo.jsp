<%-- 
    Document   : Teacher
    Created on : 10.nov.2017, 10:01:13
    Author     : Helle K. Trygsland
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
<head>  <link rel="stylesheet" type="text/css" href="index.css">
           <script src="javascript.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>SLIT for <% out.println(request.getSession().getAttribute("role")); %> </title>

</head>
<body>
<center><h2>UiA-SLIT for <% out.print(request.getSession().getAttribute("role")); %></h2></center>
<center>Logget inn som <% out.print(request.getSession().getAttribute("userName")); %>
Med rolle: <% out.print(request.getSession().getAttribute("role")); %>
Og brukerID <% out.print(request.getSession().getAttribute("userID")); %>
</center>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
<jsp:include page="SidenavMenu.jsp" />
</body>
</html>
