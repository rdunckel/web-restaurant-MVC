<%-- 
    Document   : confirmation
    Created on : Sep 3, 2012, 5:30:19 PM
    Author     : Tivoli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="date" value="${now}" pattern="MMMM dd, yyyy" />
<fmt:formatDate var="time" value="${now}" pattern="h:mm a" />

<c:set var="requestContextPath" value="${pageContext.request.contextPath}"/>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Confirmation</title>
        <link rel="stylesheet" href="menu.css" />
    </head>
    <body>
        <h1>Thank you for your order, ${name}!</h1>
        <p>You placed the following order on <span class="timestamp">${date} at ${time}</span>:</p>

        <ul>
            <li><span class="itemLabel">Entree:</span><span class="menuItem">${entree}</span></li>
            <li><span class="itemLabel">Side</span><span class="menuItem">${side}</span></li>
            <li><span class="itemLabel">Beverage:</span><span class="menuItem">${beverage}</span></li>
            <li><span class="itemLabel">Dessert:</span><span class="menuItem">${dessert}</span></li>
        </ul>

        <a href="${requestContextPath}/Menu">Return Home</a>

    </body>
</html>
