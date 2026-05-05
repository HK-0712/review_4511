<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.CustomerBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
<%
        ArrayList<CustomerBean> customer = (ArrayList<CustomerBean>) request.getAttribute("customers");
        out.println("<h1>List Customer</h1>");
        out.println("<table border='1'   >");
        out.println("<tr>");
        out.println("<th>CustId</th><th>name</th><th>tel</th><th>age</th>");
        out.println("</tr>");
        
        for (CustomerBean c:customer) {
            out.println("<tr>");
            out.println("<td>" + c.getCustid() + "</td>");
            out.println("<td>" + c.getName() + "</td>");
            out.println("<td>" + c.getTel() + "</td>");
            out.println("<td>" + c.getAge() + "</td>");
            out.println("<td><a href=\"handleCustomer?action=delete&id=" + c.getCustid() + "\">delete</td>");
            out.println("<td><a href=\"handleCustomer?action=editCustomerById&id=" + c.getCustid() + "\">edit</td>");
            out.println("</tr>");            
        }
        out.println("</table>");            
        out.println("<p />");            
%>

    <a href="index.jsp">Back to index</a>
    </body>
</html>
