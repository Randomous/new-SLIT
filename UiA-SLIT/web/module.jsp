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
      
            <div id="deleteModule" style="display:none">
        <form action="DeleteModule" method="post"> 
        student navn <input type="text" name="Firstname" />
        <br>
        Modul Nummer <input type="number" name="ModuleNumber" min="0" step="1"/>
        <br>
        <input type="Submit" name="Delete"  value="slett Modul" />

        </form>
<br>
            <button onclick="asd(2, 'deleteModule')">Avbryt sletting</button>
    </div>
            <button id="hidedeleteModule" onclick="asd(1, 'deleteModule)">Slett Modulen</button> 


    <center>
        <br>
        <div id="editModule" style="display:none">
            <form action="${pageContext.request.contextPath}/EditModule" method="post"> 
                Modul Navn <input type="text" name="Name" />
                Modul Nummer <input type="text" name="Number" />
                <br>
                Lærings Mål <input type="text" name="Goal" />
                Maksimum Poeng <input type="number" name="Points" min="0" step="1"/>
                <br>
                <input type="Submit" name="AddStudent" value="Bekreft Endering" />

            </form>
            <br>
            <button onclick="asd(2, 'editModule')">Avbryt Endring</button>
        </div>

        <button id="hide" onclick="asd(1, 'editModule')">Endre modul</button>


        <center>
            <br>
            <div id="createModule" style="display:none">
                <form action="${pageContext.request.contextPath}/CreateModule" method="post"> 
                    Modul <input type="text" name="ModuleName" />
                    Beskrivelse <input type="text" name="ModuleDescription" />
                    <br>
                    Modul Nummer <input type="number" name="ModuleNumber" min="0" step="1"/>
                    <br>
                    <input type="Submit" name="AddModule" value="Opprett ny modul" />

                </form>
                <br>
                <button onclick="asd(2, 'createModule')">Avbryt registrering</button>
            </div>

            <button id="hide" onclick="asd(1, 'createModule')">Opprett Modul</button>


        </center>

        <p>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </p>

</body>
</html>

