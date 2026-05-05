<%-- 
    Document   : searchEvents
    Created on : 2026年5月4日, 下午07:20:19
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Find Your event</h1>
        <form action="searchEventServlet" method="get">
            Select Venue: <select name="venue">
                <option value="Convention Center">Convention Center</option>
                <option value="Harbour Park">Harbour Park</option>
                <option value="City Gallery">City Gallery</option>
            </select>
            <input type="submit" value="FIND EVENTS">
        </form>
    </body>
</html>
