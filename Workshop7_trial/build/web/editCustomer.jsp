<%-- 
    Document   : editCustomer
    Created on : 2016年11月14日, 下午03:22:12
    Author     : 231W7
--%>
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
        out.println("<h1>Edit Customer</h1>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>CustId</th><th>name</th><th>tel</th><th>age</th>");
        out.println("</tr>");
        
        for (CustomerBean c:customer) {
            out.println("<tr>");
            out.println("<td>" + c.getCustid() + "</td>");
            out.println("<td>" + c.getName() + "</td>");
            out.println("<td>" + c.getTel() + "</td>");
            out.println("<td>" + c.getAge() + "</td>");
            out.println("</tr>");            
        }
        out.println("</table>");     
%>

        <form  method="GET" action="handleEdit">
            <input type="hidden" name="action"  value="add" />

            <p><label for="id">id</label> <input type="text" name="id" value="" /></p>
            <p><label for="name">name</label><input type="text"  name="name" id="name" value="" /></p>
            <p><label for="tel">tel</label><input name="tel"  type="text" value="" /></p>
            <p><label for="age">age</label><input name="age"  type="text" value="" /></p>
            <p class="submit"><input type="submit" value="Submit" /></p>

        </form>

    <a href="index.jsp">Back to index</a>
    </body>
</html>
