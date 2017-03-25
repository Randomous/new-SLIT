<%-- 
    Document   : response
    Created on : Feb 22, 2017, 8:15:20 PM
    Author     : Tor Borgen <Tor Borgen at CastleDev>
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="mybean" scope="session" class="WebInput.Input"/>
        <jsp:setProperty name="mybean" property="name" />
    <center><h1><jsp:getProperty name="mybean" property="name" /></h1></center>
        
        
</body>
</html>
