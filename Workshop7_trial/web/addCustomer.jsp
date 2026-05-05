<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Customer</h1>
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
