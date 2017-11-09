<%-- 
    Document   : module
    Created on : Oct 2, 2017, 5:18:31 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="javascript.js" type="text/javascript"></script>

        <title>Moduler</title>
    </head>
    <body>
       
        <h1><center>Her er modulene og alt du kan gjøre med dem</center></h1>
       
            
    <div id="first">
    </div>
    <div id="second">
    </div>
    <div id="title">
    </div>
        
        
        <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <br>
  <br>
  <a href="module.jsp">Moduler</a>
  <a href="Users.jsp"> Brukere</a>
  <a href="Modules.jsp">Moduler(database)</a> 
  <a href="Deliverable.jsp">Deliverable</a>
  <a href="#">Ikke</a>
</div>
        <br>
    <center>
        <br>
        <div id="editModule" style="display:none">
            
            <form action="${pageContext.request.contextPath}/EditModule" method="post"> 
               <div id ="text">
                Modul Navn <input type="text" name="Name" />
                Modul Nummer <input type="text" name="Number" />
                <br>
                Lærings Mål <input type="text" name="Goal" />
                Maksimum Poeng <input type="number" name="Points" min="0" step="1"/>
                <br>
                <input type="Submit" name="AddStudent" value="Bekreft Endering" />
                </div>
            </form>
                 
            <br>
            <button onclick="asd(2, 'editModule')">Avbryt Endring</button>
        </div>

        <button id="hideeditModule" onclick="asd(1, 'editModule')">Endre modul</button>

        <br>
        <center>
            <br>
            <div id="createModule" style="display:none">
                <form action="${pageContext.request.contextPath}/CreateModule" method="post"> 
                     <div id ="text">
                    Modul <input type="text" name="ModuleName" />
                    Beskrivelse <input type="text" name="ModuleDescription" />
                    <br>
                    Modul Nummer <input type="number" name="ModuleNumber" min="0" step="1"/>
                    <br>
                    <input type="Submit" name="AddModule" value="Opprett ny modul" /> 
                     </div>  
                </form>
                <br>
                <button onclick="asd(2, 'createModule')">Avbryt registrering</button>
            </div>

            <button id="hidecreateModule" onclick="asd(1, 'createModule')">Opprett Modul</button>

            <br>
        </center>
            <br>
            <div id="deleteModule" style="display:none">
               <form action="${pageContext.request.contextPath}/DeleteModule" method="post"> 
                    <div id ="text">
                  Modul ID <input type="number" name="ModuleNumber" min="0" step="1"/>
                  <br>
                  <input type="Submit" name="Delete"  value="slett Modul" />
                   </div>
               </form>
                 <br>
                 <button onclick="asd(2, 'deleteModule')">Avbryt sletting</button>
            </div>
                 <button id="hidedeleteModule" onclick="asd(1, 'deleteModule')">Slett Modulen</button> 
                
        <p>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </p>

</body>
</html>

