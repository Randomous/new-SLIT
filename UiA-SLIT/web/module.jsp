<%-- 
    Document   : module
    Created on : Oct 2, 2017, 5:18:31 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Moduler</title>
    </head>
    <body>
        <h1><center>Her er modulene og alt du kan gjøre med dem</center></h1>
        
        <p>
            <form action="${pageContext.request.contextPath}/InputHandler" method="post">
    <center><input type="submit" name="Commands" value="Endre modul" />
    <input type="submit" name="Module" value="Lag modul" />
    <input type="submit" name="Students" value="Godkjenn modul" />
    </center>
</form>
        </p>
        
        <p>
<center><form name="Go back" action="index.jsp">
        <input type="submit" value="Gå tilbake"/> </form></center>
        </p>
    </body>
</html>
