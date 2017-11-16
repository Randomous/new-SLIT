 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 
    <head>
 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
 
        <title>UiA-SLIT</title>
       
    </head>
<jsp:include page="UserInfo.jsp" /> 
    <div class="wrapperofwrapper"> 
    <div class="wrapper">
 
    <body>
        <div id="title">
            <jsp:useBean id="mybean2" scope="session" class="WebInput.Input"/>
        </div>
        
        <div id="userSearch"> 
        <h2>Studentsøk</h2>
<!--    <center><form id="userform" name="loginForm" method="post" action="InputHandler">
            Brukernavn:</font> <input type="text" name="name"/> <br/>
        <input type="submit" name="Search" value="Søk" /></center>
    <br>
</form>-->
 
     
    
<form name="userSearch" method="post" action="UserSearch.jsp">
            Student navn</font> <input type="text" name="name"/>
        <input type="submit" name="Search" value="Søk" />
</form>
      </div>
    </div>
    </div>
 
</body>
 