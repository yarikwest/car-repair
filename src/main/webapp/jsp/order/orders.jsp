<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Orders <c:if test="${employeeName != null}">of ${employeeName}</c:if>
        <c:if test="${customerName != null}">of ${customerName}</c:if></title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="../../css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="../../css/style.css"/>">
</head>
<body>
<%@include file="../header.jsp" %>
<h2>Zlecenia <c:if test="${employeeName != null}">pracownika ${employeeName}</c:if>
    <c:if test="${customerName != null}">klienta ${customerName}</c:if></h2>
<hr>
<main>
    <table class="highlight centered">
        <thead>
        <tr>
            <th>Data przyjęcia do naprawy</th>
            <th>Data rozpoczęcia naprawy</th>
            <c:if test="${employeeName == null}">
                <th>Pracownik</th>
            </c:if>
            <th>Opis problemu</th>
            <th>Pojazd którego dotyczy naprawa</th>
            <th>Status</th>
            <th>Szczegóły</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.acceptRepair}</td>
                <td>${order.startRepair}</td>
                <c:if test="${employeeName == null}">
                    <td>${order.employee.firstName} ${order.employee.lastName}</td>
                </c:if>
                <td>${order.problemDescription}</td>
                <td>${order.vehicle.registry} ${order.vehicle.brand}</td>
                <td>${order.status.title}</td>
                <td><a href="/orders/details?id=${order.id}" class="tooltipped" data-position="bottom"
                       data-tooltip="szczegóły"><i class="material-icons">more</i></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<hr>
<%@include file="../footer.jsp" %>
<script type="text/javascript" src="<c:url value="../../js/jquery-3.4.1.slim.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../../js/materialize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../../js/functions.js"/>"></script>
</body>
</html>