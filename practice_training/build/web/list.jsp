<%-- 
    Document   : list.jsp
    Created on : 2026年5月4日, 下午10:41:55
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- (e)(i) hints: import necessary class using directive -->
<%@page import="java.util.ArrayList, com.bean.EventBean" %>

<!-- (e)(i) Use JSP Action to get the forwarded arraylist -->
<jsp:useBean id="events" type="java.util.ArrayList" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event List</title>
    </head>
    <body>
        <h2>EventSphere - Book Your Experience</h2>
        
        <p>Venue: <%= request.getParameter("venue") %></p>
        
        <table border="1" cellpadding="2" cellspacing="0">
            <tr>
                <th>Event Name</th>
                <th>Date</th>
                <th>Price</th>
                <th>Seat</th>
            </tr>
            <%
                // (e)(ii) Use Script to display the event
                // (e)(iii) Calculate the total seats available
                int totalSeats = 0;
                
                if (events != null) {
                    // Because JSP useBean with ArrayList doesn't know the generic type <EventBean>, 
                    // we need to cast it when pulling out items.
                    for (int i = 0; i < events.size(); i++) {
                        EventBean ev = (EventBean) events.get(i);
                        totalSeats += ev.getSeatsAvailable(); // Accumulate total seats
                        
                        // Output the table rows
                        out.println("<tr>");
                        out.println("<td>" + ev.getEventName() + "</td>");
                        out.println("<td>" + ev.getEventDate() + "</td>");
                        out.println("<td>" + ev.getTicketPrice() + "</td>");
                        out.println("<td>" + ev.getSeatsAvailable() + "</td>");
                        out.println("</tr>");
                    }
                }
            %>
        </table>
        
        <p>
            <!-- (e)(iii) display using Expression -->
            Total seats: <%= totalSeats %>
        </p>
        
        <a href="searchEvents.jsp">Back to Search</a>
    </body>
</html>
