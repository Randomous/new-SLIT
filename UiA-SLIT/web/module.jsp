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
                <script src="javascript.js" type="text/javascript"></script>

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
        
        <center>
        <br>
        
    <div id="asd" style="display:none">
        <form action="InputHandler" method="post"> 
        Navn <input type="text" name="Firstname" />
        Etternavn <input type="text" name="Surname" />
        <br>
        Epost <input type="text" name="Mail" />
        StudentID <input type="number" name="StudentID" min="0" step="1"/>
        <br>
        <input type="Submit" name="AddStudent" value="Legg til student" />

        </form>
            <br>
            <button onclick="asd(2)">Avbryt registrering</button>
    </div>

    <button id="hide" onclick="asd(1)">Registrer ny student</button>
    
</center>
        
        
    </body>
</html>

