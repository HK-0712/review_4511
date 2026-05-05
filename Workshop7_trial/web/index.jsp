<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to the ICT</h1>
        <ul>
            <li><a href="handleCustomer?action=add">add Customrer</a></li>
            <li><a href="handleCustomer?action=edit">edit Customrer</a></li>
            <li><a href="handleCustomer?action=list">list Customrer</a></li>
            <li><a href="handleCustomer?action=list2">list Customrer v2</a></li>
            <li>search Customrer
                <form method="GET" action="handleCustomer">
                    <input type="hidden" name="action" value="search"/>
                    <input type="text" name='name' value="" />
                    <input type="submit" />
                </form>                
            </li>
        </ul>
    </body>
</html>
