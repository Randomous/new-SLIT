/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listdemo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import listdemo.db.StudentManagerLocal;


/**
 *
 * @author evenal
 */
@WebServlet("/deletestudent")
public class DeleteStudentServlet extends HttpServlet
        implements StringConstants
{

    @EJB
    StudentManagerLocal studentMgr;

    protected void doIt(HttpServletRequest req, HttpServletResponse resp)
            throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String idPar = req.getParameter(ID);
        long id = Long.valueOf(idPar);
        System.out.format("DeleteStudent.doIt(%d)\n", id);
        studentMgr.removeStudent(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("studentlist");

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException ioe) {
            ioe.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        doIt(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doIt(req, resp);
    }
}
