/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebInput;

import Content.Module;
import Content.ModuleRegister;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shiwan
 */
@WebServlet(name = "EditModule", urlPatterns = {"/EditModule"})
public class EditModule extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ModuleRegister moduleRegister = new ModuleRegister ();
        
       
        
        
         String goBack = "<center><form name=\"Go back\" action=\"index.jsp\">\n" +
            "<input type=\"submit\" value=\"Gå tilbake\" />\n" +
            "</form></center>";
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditModule</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditModule at " + request.getContextPath() + "</h1>");
            if (request.getParameter("EditModule") != null) {
              //  out.println("<h1>" + moduleRegister.editModule() + "<h1>");
            
            } else if (request.getParameter("AddStudent") != null) {
             //out.println("Please enter the student information\n" + 
               //             "Enter the firstname assosiated with the student");
             String Name = request.getParameter("Name");
             String Number = request.getParameter("Number" );
             String Goal = request.getParameter("Goal");
             String Points = request.getParameter("Points");
             int result = Integer.valueOf(Points);
             int results = Integer.valueOf(Number);
             out.println (moduleRegister.editModule(Name,results,Goal ,result));
            
             
            }
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
