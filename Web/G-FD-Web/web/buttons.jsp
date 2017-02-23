<%-- 
    Document   : Buttons
    Created on : Feb 23, 2017, 1:36:52 AM
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
          <jsp:useBean id="mybean" scope="session" class="Test.Test"/>
        <jsp:setProperty name="mybean" property="name" />
    <center><h1><jsp:getProperty name="mybean" property="name" /></h1></center>
    </body>
</html>
