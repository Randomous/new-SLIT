
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="InputAndResponses.Start"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="mybean2" scope="session" class="WebInput.Input"/>
        <h2><jsp:getProperty name="mybean2" property="help" /></h2>
        <h3> 
        </h3>
        <h1><center>Enter a firstname to search for</center></h1>
    <center><form name="Name input form" action="response.jsp">
            <input type="text" name="name" />
            <input type="submit" value="OK" />
        </form></center>
</body>
</html>
