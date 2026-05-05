<%-- 
    Document   : editCustomerById
    Created on : 2016年11月14日, 下午04:48:01
    Author     : 231W7
--%>

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
            CustomerBean c = (CustomerBean)request.getAttribute("customer");
        %>
        
        <h1>Edit Customer</h1>
        <form  method="GET" action="handleEdit">
            <input type="hidden" name="action"  value="add" />

            <p><label for="id">id</label> <input type="text" name="id" value="<%=c.getCustid()%>" /></p>
            <p><label for="name">name</label><input type="text"  name="name" id="name" value="<%=c.getName()%>" /></p>
            <p><label for="tel">tel</label><input name="tel"  type="text" value="<%=c.getTel()%>" /></p>
            <p><label for="age">age</label><input name="age"  type="text" value="<%=c.getAge()%>" /></p>
            <p class="submit"><input type="submit" value="Submit" /></p>

        </form>

    <a href="index.jsp">Back to index</a>
    </body>
</html>
