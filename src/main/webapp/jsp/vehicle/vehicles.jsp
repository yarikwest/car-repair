<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Vehicles <c:if test="${ownerName != null}">of ${ownerName}</c:if></title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="../../css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="../../css/style.css"/>">
</head>
<body>
<%@include file="../header.jsp" %>
<h2>Pojazdy <c:if test="${ownerName != null}">klienta ${ownerName}</c:if></h2>
<hr>
<main>
    <a href="/vehicles/add?ownerId=${ownerId}"
       class="btn-floating btn-large waves-effect waves-light red btn-add tooltipped" data-position="bottom"
       data-tooltip="dodaj"><i
            class="material-icons">add</i></a>
    <table class="highlight centered">
        <thead>
        <tr>
            <th>Marka</th>
            <th>Model</th>
            <th>Rok produkcji</th>
            <th>Nr.rejestracyjny</th>
            <th>Następny przegląd</th>
            <th>Historia napraw</th>
            <th colspan="2">Więcej</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="vehicle" items="${vehicles}" varStatus="iter">
            <tr>
                <td>${vehicle.brand}</td>
                <td>${vehicle.model}</td>
                <td>${vehicle.yearOfProd}</td>
                <td>${vehicle.registry}</td>
                <td>${vehicle.nextInspection}</td>
                <td><a href="/vehicles/history?id=${vehicle.id}&vehicleName=${vehicle.brand} ${vehicle.model}"
                       class="tooltipped" data-position="bottom" data-tooltip="historia"><i
                        class="material-icons">history</i></a></td>
                <td><a href="/vehicles/edit?id=${vehicle.id}" class="tooltipped" data-position="bottom"
                       data-tooltip="edytuj"><i class="material-icons">edit</i></a></td>
                <td>
                    <!-- Modal Trigger -->
                    <a class="modal-trigger tooltipped" href="#modal${iter.index}" data-position="bottom"
                       data-tooltip="usuń"><i class="material-icons">delete</i></a>
                    <!-- Modal Structure -->
                    <div id="modal${iter.index}" class="modal">
                        <div class="modal-content">
                            <h4>Czy napewno chcesz usunąć samochód ${vehicle.brand} ${vehicle.model}?</h4>
                        </div>
                        <div class="modal-footer">
                            <a href="/vehicles/delete?id=${vehicle.id}&ownerId=${ownerId}"
                               class="modal-close waves-effect waves-green btn-flat">Usuń</a>
                        </div>
                    </div>
                </td>
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
