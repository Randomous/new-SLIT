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
 <jsp:include page="UserInfo.jsp" />

        <title>Moduler</title>
    </head>
    <body>
        
        <h1 class="TextFormat">Her er modulene og alt du kan gjøre med dem</h1>

        
        
        <br>
    <center>
        <br>
     
        <div> Velg en funksjon </div>
        
           
</center>
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
                    Modul Nummer <input type="text" name="M_ID"/>
                    <br>
                    <input type="Submit" name ="AddLearningGoals" value="opprett læringsmål" />
                </form>
                <br>
                <button onclick="asd(2, 'CreateLearningGoals')">Avbryt registrering</button>
            </div>
                
                <button id="hideCreateLearningGoals" onclick="asd(1, 'CreateLearningGoals')">Opprett LæringsMål</button>

            <br>
        </center>
            <br>
            
            <center>
            <div id="deleteModule" style="display:none">
               <form action="DeleteModule.jsp" method="post"> 
           
                  Modul Nummer <input type="text" name="M_ID" min="0" step="1"/>
                  <br>
                  <input type="Submit" name="Delete"  value="slett Modul" />

               </form>
                 <br>
                 <button onclick="asd(2, 'deleteModule')">Avbryt sletting</button>
            </div>
                 <button id="hidedeleteModule" onclick="asd(1, 'deleteModule')">Slett Modulen</button> 
              </center>
        <p>
           

        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </p>
</body>
</html>

