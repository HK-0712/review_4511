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

@WebServlet(name = "HandleCustomer", urlPatterns = {"/handleCustomer"})
public class HandleCustomer extends HttpServlet {
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

        String action = request.getParameter("action");
        System.out.println("action:"+action);

        if ("list".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            ArrayList customers = db.queryCust();
            // set the result into the attribute
            System.out.println(customers);
            request.setAttribute("customers", customers);
            // redirect the result to the listCustomers.jsp
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/listCustomers.jsp");
            rd.forward(request, response);
        }
        else if ("list2".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            ArrayList customers = db.queryCust();
            // set the result into the attribute
            System.out.println(customers);
            request.setAttribute("customers", customers);
            // redirect the result to the listCustomers.jsp
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/listCustomers2.jsp");
            rd.forward(request, response);
        }
        else if ("edit".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            ArrayList customers = db.queryCust();
            // set the result into the attribute
            System.out.println(customers);
            request.setAttribute("customers", customers);
            // redirect the result to the listCustomers.jsp
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/editCustomer.jsp");
            rd.forward(request, response);
        }
        else if ("editCustomerById".equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            System.out.println(id);
            CustomerBean c  = db.queryCustByID(id);            
            System.out.println(c.getName());
            request.setAttribute("customer", c);
            // redirect the result to the listCustomers.jsp
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/editCustomerById.jsp");
            rd.forward(request, response);
        }        
        else if ("add".equalsIgnoreCase(action)) {
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/addCustomer.jsp");
            rd.forward(request, response);
        }        
        else if ("delete".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            String id = request.getParameter("id");
            if (id != null) {

                int rs = db.delRecord(id);
                // set the result into the attribute
                // redirect the result to the listCustomers.jsp
                ArrayList customers = db.queryCust();
                RequestDispatcher rd;
                rd = getServletContext().getRequestDispatcher("/handleCustomer?action=list2");
                request.setAttribute("customers", customers);
                rd.forward(request, response);
            }

        } else if ("search".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            String name = request.getParameter("name");
            System.out.println(name);
            if (name != null) {
                // set the result into the attribute
                // redirect the result to the listCustomers.jsp
                ArrayList customers = db.queryCustByName(name);
                RequestDispatcher rd;
                rd = getServletContext().getRequestDispatcher("/listCustomers.jsp");
                request.setAttribute("customers", customers);
                rd.forward(request, response);
            }
        } 
        else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
        }
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
