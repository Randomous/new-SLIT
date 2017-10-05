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
<center>
            <form action="${pageContext.request.contextPath}/CreateModule" method="post">
    
    <input type="submit" name="Module" value="Opprett ny modul" />
  
    </center>
</form>
        </p>
        
           <center>
        <br>
    <div id="asd" style="display:none">
        <form action="CreateModule" method="post"> 
        Modul <input type="text" name="ModuleName" />
        Beskrivelse <input type="text" name="ModuleDescription" />
        <br>
        Modul Nummer <input type="number" name="ModuleNumber" min="0" step="1"/>
        <br>
        <input type="Submit" name="AddModule" value="Opprett ny modul" />

        </form>
            <br>
            <button onclick="asd(2)">Avbryt registrering</button>
    </div>

    <button id="hide" onclick="asd(1)">Opprett ny modul</button>

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
        
        <p>
<center><form name="Go back" action="index.jsp">
        <input type="submit" value="Gå tilbake"/> </form></center>
        </p>
    </body>
</html>
