<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:if test="${not empty orders}">
        <table border="1" width="700">
            <thead>
            <tr>
                <th>Menu ID</th>
                <th>Dish Name</th>
                <th>Dish Price</th>
                <th>Quantity</th>
                <th>Sum</th>
            </tr>
            </thead>
            <tbody>
                <c:set var="totalSum" value="0" />
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td>${order.ordersPrimaryKey.ordersMenu.menuId}</td>
                        <td>${order.ordersPrimaryKey.ordersMenu.menuDish.dishName}</td>
                        <td>${order.ordersPrimaryKey.ordersMenu.menuPrice}</td>
                        <td>${order.ordersQuantity}</td>
                        <td>${order.ordersPrimaryKey.ordersMenu.menuPrice * order.ordersQuantity}</td>
                        <c:set var="totalSum" value="${totalSum + order.ordersPrimaryKey.ordersMenu.menuPrice * order.ordersQuantity}" />
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="4" align="right"><strong>Total sum:</strong></td>
                    <td>${totalSum}</td>
                </tr>
            </tbody>
        </table>
    </c:if>
</body>
</html>
