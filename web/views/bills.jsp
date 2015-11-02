<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <c:if test="${not empty bills}">
            <table border="1" width="700">
                <thead>
                <tr>
                    <th>Bill ID</th>
                    <th>Desk</th>
                    <th>Client</th>
                    <th>Discount</th>
                    <th>Employee</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${bills}" var="bill">
                    <tr>
                        <td><a href="orders/${bill.billId}">${bill.billId}</a></td>
                        <td>${bill.billDesk.deskName}</td>
                        <td>${bill.billClient.clientLastName} ${bill.billClient.clientFirstName}</td>
                        <td>${bill.billClient.clientDiscount.discountValue}%</td>
                        <td>${bill.billEmployee.employeeLastName} ${fn:substring({bill.billEmployee.employeeFirstName}, 1, 2)}.</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>