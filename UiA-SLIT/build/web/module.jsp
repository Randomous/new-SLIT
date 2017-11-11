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
 <jsp:include page="Teacher.jsp" />

        <title>Moduler</title>
    </head>
    <body>
        <h1><center>Her er modulene og alt du kan gjøre med dem</center></h1>

        
   <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <br>
  <br>
  <a href="module.jsp">Endre/oppdatere</a>
  <a href="Users.jsp"> Brukere</a>
  <a href="Modules.jsp">Moduler</a> 
  <a href="Deliverable.jsp">Innlevering</a>
</div>
        
        <br>
    <center>
        <br>
        <div id="editModule" style="display:none">
            <form action="${pageContext.request.contextPath}/EditModule" method="post"> 
                Modul Navn <input type="text" name="ModuleName" />
                Modul Tittel <input type="text" name="ModuleTittle" />
                <br>
                <br>
                Modul Beskrivelse      <input type="text" name="ModuleDescription" />
                <br>
                <br>
                Læringsmål Tittel      <input type="text" name="LearningGoalsTittle" />
                <br>
                <br>
                Læringsmål Beskrivelse <input type="text" name="LearningGoalsDescription"/>
                <br>
                <br>
                Modul Nummer           <input type="text" name="ModuleNumber" />
                <br>
                <br>
                <input type="Submit" name="AddStudent" value="Bekreft Endering" />

            </form>
            <br>
            <button onclick="asd(2, 'editModule')">Avbryt Endring</button>
        </div>

        <button id="hideeditModule" onclick="asd(1, 'editModule')">Endre modul</button>

        <br>
        <center>
            <br>
            <div id="createModule" style="display:none">
                <form action="CreateModule.jsp" method="post"> 
                    Modul Navn <input type="text" name="ModuleName" placeholder="ModuleName" />
                    Modul Tittel <input type="text" name="Tittle" placeholder=" ModuleDescription" />
                    <br>
                    Modul Beskrivelse <input type="text" name="Description"/>
                    <br>
                    <input type="Submit" name="AddModule" value="Opprett ny modul" />

                </form>
                <br>
                <button onclick="asd(2, 'createModule')">Avbryt registrering</button>
            </div>

            <button id="hidecreateModule" onclick="asd(1, 'createModule')">Opprett Modul</button>

            <br>
        </center>
            
            <center>
                <br>
            <div id="CreateLearningGoals" style="display:none">
                <form action="LearningGoals.jsp" method="post"> 
                    Læringsmål Tittel <input type="text" name="LearningGoalsTittle"/>
                    Læringsmål Beskrivelse <input type="text" name="LearningGoalsDescription"/>
                    Modul Nummer <input type="text" name="ModuleNumber"/>
                    <br>
                    <input type="Submit" name ="AddLearningGoals" value="opprett læringsmål" />
                </form>
                <br>
                <button onclick="asd(2, 'AddlearningGoals')">Avbryt registrering</button>
            </div>
                
                <button id="hideCreateLearningGoals" onclick="asd(1, 'CreateLearningGoals')">Opprett LæringsMål</button>

            <br>
        </center>
            <br>
            
            
            <div id="deleteModule" style="display:none">
               <form action="${pageContext.request.contextPath}/DeleteModule" method="post"> 
                  student navn <input type="text" name="Firstname" />
                  <br>
                  Modul Nummer <input type="number" name="ModuleNumber" min="0" step="1"/>
                  <br>
                  <input type="Submit" name="Delete"  value="slett Modul" />

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

