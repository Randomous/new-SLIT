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
    </head>
    
    <body>
        <jsp:useBean id="mybean2" scope="session" class="WebInput.Input"/>
        <h2><jsp:getProperty name="mybean2" property="help" /></h2>
    <center><form name="loginForm" method="post" action="InputHandler">
    Username: <input type="text" name="name"/> <br/>
        <input type="submit" name="Search" value="Search" /></center>
    <br>
</form>
        
    <form action="${pageContext.request.contextPath}/InputHandler" method="post">
    <center><input type="submit" name="Commands" value="Text Input Commands" />
    <input type="submit" name="Module" value="Module" />
    <input type="submit" name="Students" value="Registered Students" />
    </center>
</form>

    <center>
        <br>
    <div id="asd">
    <form action="InputHandler" method="post">
    Enter student name <input type="text" name="firstname" />
    Enter a description of the student <input type="text" name="studentDesc" />
    <br>
    Enter the mail type <input type="text" name="mailType" />
    Enter mail points <input type="number" name="studentID" min="0" step="1"/>
    <br>
    <input type="submit" name="AddStudent" value="Submit new student" />
    
    </form>
        <br>
        <button onclick="asd(1)">Close without submitting</button>
    </div>

    <button onclick="asd(2)">Add new Student</button>

    <script type="text/javascript">
    function asd(a)
    {
        if(a===1)
        document.getElementById("asd").style.display="none";
        else
        document.getElementById("asd").style.display="block";
    }
    window.onload = asd(1);
    </script>
        </center>

        </body>
    </html>
