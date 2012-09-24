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
        <link rel="stylesheet" href="resources/default/1_0/css/menu.css" />
    </head>
    <body>
        <h1>Thank you for your order ${name}!</h1>
        <p>You placed the following order on <span class="timestamp">${date} at ${time}</span>:</p>

        <table id="confirmation">
            <tr>
                <th>Entrees:</th>
                <td>
                    <ul>
                        <c:if test="${empty entrees}">None</c:if>
                        <c:forEach items="${entrees}" varStatus="loop">
                            <li>${entrees[loop.index]}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
            <tr>
                <th>Sides:</th>
                <td>
                    <ul>
                        <c:if test="${empty sides}">None</c:if>
                        <c:forEach items="${sides}" varStatus="loop">
                            <li>${sides[loop.index]}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
            <tr>
                <th>Beverages:</th>
                <td>
                    <ul>
                        <c:if test="${empty beverages}">None</c:if>
                        <c:forEach items="${beverages}" varStatus="loop">
                            <li>${beverages[loop.index]}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
            <tr>
                <th>Desserts:</th>
                <td>
                    <ul>
                        <c:if test="${empty desserts}">None</c:if>
                        <c:forEach items="${desserts}" varStatus="loop">
                            <li>${desserts[loop.index]}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
            <tr>
                <th>Order Total:</th>
                <td>
                    <fmt:formatNumber value="${orderTotal}" type="currency" />
                </td>
            </tr>
        </table>

        <p><a href="${requestContextPath}/Menu">Return Home</a></p>

    </body>
</html>
