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
        <script>
            
            function Order(guestName, entree, side, beverage, dessert) {
                this.guestName = guestName;
                this.entree = entree;
                this.side = side;
                this.beverage = beverage;
                this.dessert = dessert;
            }
                        
            function addOrder() {
                
                var orderForm = document.forms["order"];
                              
                var items=["entree","side","beverage","dessert"];
                
                var orderObj = new Order();
                orderObj.guestName = orderForm["name"].value;
                
                for(i=0; i<items.length;i++){
                    var item = orderForm[items[i]];
                    var itemName = item.options[item.selectedIndex].value;
                    
                    orderObj[items[i]] = itemName;
                }
                                
                var orderText = orderObj.guestName;
                
                for(i=0; i<items.length;i++){
                    var itemName = orderObj[items[i]];
                    if(i == 0) {
                        orderText += ": " + itemName;
                    } else {
                        orderText += ", " + itemName;
                    }
                }
                                                
                var newElement = document.createElement("li");
                newElement.innerHTML = orderText;
                
                var orderList = document.getElementById("orderList")
                
                orderList.appendChild(newElement);
                
                var orders = new Array();
                orders[0] = orderObj;
                
                console.log(orders[0]);
                                            
            }
        </script>
    </head>
    <body>
        <div id ="menuDiv">
            <h1>Menu</h1>

            <form name="order" action="Confirmation" method="POST">
                <table>
                    <tr>
                        <th>Name:</th>
                        <td>
                            <input type="text" name="name" value="Ryan" />            
                        </td>
                    </tr>
                    <tr>
                        <th>Entree:</th>
                        <td>
                            <select name="entree">
                                <c:forEach var="entree" items="${entrees}">
                                    <option value="${entree.name}">${entree.name} - ${entree.price}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Side:</th>
                        <td>
                            <select name="side">
                                <c:forEach var="side" items="${sides}">
                                    <option value="${side.name}">${side.name} - ${side.price}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Beverage:</th>
                        <td>
                            <select name="beverage">
                                <c:forEach var="beverage" items="${beverages}">
                                    <option value="${beverage.name}">${beverage.name} - ${beverage.price}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Dessert:</th>
                        <td>
                            <select name="dessert">
                                <c:forEach var="dessert" items="${desserts}">
                                    <option value="${dessert.name}">${dessert.name} - ${dessert.price}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <button type="button" onclick="addOrder()">Add Order</button>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <button type="submit">Complete Order</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="orderDiv">
            <h1>Orders</h1>
            <ol id="orderList"></ol>
        </div>
    </body>
</html>
