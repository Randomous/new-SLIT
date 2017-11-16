<%-- 
    Document   : SidenavMenu
    Created on : Nov 12, 2017, 4:00:43 PM
    Author     : root
--%>

<%@page import="java.lang.CharSequence"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="mySidenav" class="vertical-menu">
  <!--<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>-->
  <a href="index.jsp" class="active">Hjem</a>   
    <!--<p> Moduler</p>-->
    <a href="deliveryQueue.jsp">Leveringskø</a>
      <a href="Modules.jsp">Moduler</a> 
  <%
      String sesRole = request.getSession().getAttribute("role").toString();
                String checkRole = "Lærer";
                String checkRoleTA = "Hjelpelærer";
            if( checkRole.equals(sesRole) || checkRoleTA.equals(sesRole)) { 
        if (sesRole.equals(checkRole)) {
      %>
  <a href="module.jsp">Endre/oppdatere</a>
  <% }
  %>
  <a href="Deliverable.jsp">Innlevering</a>
  <!--<p> Brukere</p>-->
      <a href="Users.jsp"> Brukere</a>
      <% } 
      %>
  
</div>

<!-- Use any element to open the sidenav -->
<!--
<div class="vertical-menu">
  <a href="index.jsp" class="active">Home</a>
  <a href="module.jsp">Rediger Moduler</a>
  <a href="deliveryQueue.jsp">Leveringskø</a>
  <a href="Deliverable.jsp">Inlevering</a>
  <a href="Modules.jsp">Moduler</a>
  <a href="Users.jsp">Brukere</a>
</div>
-->
<!--
<span onclick="openNav()">
    <button>Meny</button>
</span>
-->
<!-- Add all page content inside this div if you want the side nav to push page content to the right (not used if you only want the sidenav to sit on top of the page -->
<!--<div id="main">-->
<!--    <button id="test" name="bla" value="meny"></button>-->


