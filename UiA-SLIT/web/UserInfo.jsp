<%-- 
    Document   : UserInfo
    Created on : 10.nov.2017, 10:01:13
    Author     : Helle K. Trygsland
--%>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
<head>  <link rel="stylesheet" type="text/css" href="index.css">
           <script src="javascript.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Teacher Page</title>
 
</head>
<body>
    <div id="banner">
        <img id="bannerimg" src="UiALogo.png">
            <h2 class="header">UiA-SLIT for <% out.println(request.getSession().getAttribute("role")); %></h2>
    </div>
            <div id="rolecheck">
                <p>
Logget inn som <%=request.getSession().getAttribute("userName") %>
<br>
Med rolle: <% out.println(request.getSession().getAttribute("role")); %>
<br>
Og brukerID <% out.println(request.getSession().getAttribute("userID")); %>
<br>
<a id="logout" href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
                </p>
            </div>
<jsp:include page="SidenavMenu.jsp" />
 
</body>
</html>