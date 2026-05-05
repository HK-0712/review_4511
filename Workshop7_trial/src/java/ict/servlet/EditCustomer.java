/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.db.CustomerDB;
import ict.bean.CustomerBean;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author 231W7
 */
@WebServlet(name = "EditCustomer", urlPatterns = {"/handleEdit"})
public class EditCustomer extends HttpServlet {
    private CustomerDB db;

    public void init() {
        //String url = "jdbc:derby://localhost/ITP4912_DB";
        //String username = "APP";
        //String password = "APP";
        String username = this.getServletContext().getInitParameter("dbUser");
        String password = this.getServletContext().getInitParameter("dbPassword");
        String url = this.getServletContext().getInitParameter("dbUrl");
        
        System.out.println("new database");
        db = new CustomerDB(url, username, password);

        //boolean isAdded = custDb.addRecord("1", "peter", "12345688", 21);
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        // get the parameter from users
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        int age = Integer.parseInt(request.getParameter("age"));

        // update the database operations
        CustomerBean c  = db.queryCustByID(id);
        if (c !=null) {
            
            c.setCustid(id);
            c.setName(name);
            c.setTel(tel);
            c.setAge(age);
            db.editRecord(c);
        } else {
            db.addRecord(id, name, tel, age);
            // redirect the result
        }
        response.sendRedirect("handleCustomer?action=list");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
