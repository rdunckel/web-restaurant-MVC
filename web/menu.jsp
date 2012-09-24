<%-- 
    Document   : index
    Created on : Sep 3, 2012, 4:21:24 PM
    Author     : Tivoli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ryan's Place</title>
        <link rel="stylesheet" href="resources/default/1_0/css/menu.css" />
    </head>
    <body>
        <div id="header">
            <h1>Ryan's Place</h1>
        </div>
        <div id ="orderDiv">
            <h1>Menu</h1>

            <form id="order" name="order" action="Confirmation" method="POST">
                <table>
                    <tr>
                        <th>Entree:</th>
                        <td>
                            <c:forEach var="entree" items="${entrees}">
                                <input type="checkbox" name="entrees" value="${entree.name}">${entree.name} - 
                                <fmt:formatNumber value="${entree.price}" type="currency" /><br>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <th>Side:</th>
                        <td>
                            <c:forEach var="side" items="${sides}">
                                <input type="checkbox" name="sides" value="${side.name}">${side.name} - 
                                <fmt:formatNumber value="${side.price}" type="currency" /><br>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <th>Beverage:</th>
                        <td>
                            <c:forEach var="beverage" items="${beverages}">
                                <input type="checkbox" name="beverages" value="${beverage.name}">${beverage.name} - 
                                <fmt:formatNumber value="${beverage.price}" type="currency" /><br>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <th>Dessert:</th>
                        <td>
                            <c:forEach var="dessert" items="${desserts}">
                                <input type="checkbox" name="desserts" value="${dessert.name}">${dessert.name} - 
                                <fmt:formatNumber value="${dessert.price}" type="currency" /><br>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <th>Name:</th>
                        <td>
                            <input type="text" name="name" />            
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <button type="submit">Submit Order</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
