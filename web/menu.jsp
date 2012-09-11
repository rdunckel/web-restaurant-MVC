<%-- 
    Document   : index
    Created on : Sep 3, 2012, 4:21:24 PM
    Author     : Tivoli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ryan's Restaurant</title>
        <link rel="stylesheet" href="menu.css" />
    </head>
    <body>
        <h1>Menu</h1>

        <form id="order" action="Confirmation" method="POST">
            <table>
                <tr>
                    <th>Name:</th>
                    <td>
                        <input type="text" name="name" />
                    </td>
                </tr>
                <tr>
                    <th>Entree:</th>
                    <td>
                        <select name="entree">
                            <c:forEach var="entree" items="${entrees}">
                                <option value="${entree.name}">${entree.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Beverage:</th>
                    <td>
                        <select name="beverage">
                            <c:forEach var="beverage" items="${beverages}">
                                <option value="${beverage.name}">${beverage.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Dessert:</th>
                    <td>
                        <select name="dessert">
                            <c:forEach var="dessert" items="${desserts}">
                                <option value="${dessert.name}">${dessert.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <button type="submit">Place Order</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
