<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main Page</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="css/style.css"/>">
</head>
<body>
<%@include file="jsp/header.jsp" %>
<main>
    <div class="row row-container">
        <jsp:include page="jsp/navbar.jsp"/>
        <div class="col s12 l9">
            <h5>Aktualnie prowadzone naprawy</h5>
            <div class="card">
                <div class="card-content">
                    <div class="table-overflow">
                        <table class="highlight centered responsive-table">
                            <thead>
                            <tr>
                                <th>Data przyjęcia do naprawy</th>
                                <th>Data rozpoczęcia naprawy</th>
                                <th>Przypisany do naprawy pracownik</th>
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
                                    <td>${order.employee.firstName} ${order.employee.lastName}</td>
                                    <td>${order.problemDescription}</td>
                                    <td>${order.vehicle.registry} ${order.vehicle.model}</td>
                                    <td>${order.status.title}</td>
                                    <td><a href="/app/orders/details?id=${order.id}" class="tooltipped"
                                           data-position="bottom"
                                           data-tooltip="szczegóły"><i class="material-icons">more</i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="jsp/footer.jsp" %>
<script type="text/javascript" src="<c:url value="js/jquery-3.4.1.slim.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/materialize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/functions.js"/>"></script>
</body>
</html>
