<%-- 
    Document   : DeliveryModule
    Created on : Dec 12, 2017, 2:07:54 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Innelvering</title>
    </head>
    <body>
        
       
     
        <center>
           
            <div>
                <form action="Delivery.jsp" method="post"> 
                    Modul text <input type="text" name="D_Text"/>
                    <br>
                    Youtube Link <input type="text" name="D_YouTubeLink"/>
                    <br>
                    Github Link <input type="text" name="D_GitHubLink"/>
                    <br>
                    Upload date <input type="text" name="D_UploadDate"/> 
                    <br>
                    Comments <input type="text" name="D_CommentStudent"/> 
                    <br>
                    
                    <input type="Submit" name="AddDelivery" value="Lever Modul" />
                </form>
                <br>
            </div>
            <br>
        </center>
    <br>
   
     <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </body>
</html>
