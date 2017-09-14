  <%-- 
    Document   : FullApp
    Created on : Feb 23, 2017, 1:36:52 AM
    Author     : Tor Borgen <Tor Borgen at CastleDev>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    </head>
    
    <body>
        <jsp:useBean id="mybean2" scope="session" class="WebInput.Input"/>
        <h2><jsp:getProperty name="mybean2" property="help" /></h2>
    <center><form name="loginForm" method="post" action="InputHandler">
        Brukernavn:</font> <input type="text" name="name"/> <br/>
        <input type="submit" name="Search" value="Søk" /></center>
    <br>
</form>
        
    <form action="${pageContext.request.contextPath}/InputHandler" method="post">
    <center><input type="submit" name="Commands" value="Tekst kommandoer" />
    <input type="submit" name="Module" value="Modul" />
    <input type="submit" name="Students" value="Studenter" />
    </center>
</form>

    <center>
        <br>
    <div id="asd" style="display:none">
        <form action="InputHandler" method="post"> 
        Student navn <input type="text" name="Courses" />
        Velg fag <input type="text" name="Modules" />
        <br>
        Velg antall godkjente moduler <input type="text" name="Delivery" />
        Hvor mange poeng har du fått? <input type="number" name="Mark" min="0" step="1"/>
        <br>
        <input type="Submit" name="AddStudent" value="Legg til student" />

        </form>
            <br>
            <button onclick="asd(2)">Avbryt registrering</button>
    </div>

    <button id="hide" onclick="asd(1)">Registrer ny student</button>

    <script type="text/javascript">
    function asd(a)
    {
        if(a===1){
            document.getElementById("asd").style.display="block";
            $('#hide').hide();
        }
        else {
            $("#asd").hide();
            $("#hide").show();
            
        
        }
    }
    </script>
        </center>

        </body>
    </html>
