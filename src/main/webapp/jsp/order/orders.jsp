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
<main>
    <div class="row row-container">
        <jsp:include page="../navbar.jsp"/>
        <div class="col s12 l9">
            <h5>Zlecenia <c:if test="${employeeName != null}">pracownika ${employeeName}</c:if>
                <c:if test="${customerName != null}">klienta ${customerName}</c:if></h5>
            <div class="card">
                <div class="card-content">
                    <c:if test="${employeeName == null && customerName == null}">
                        <a href="/orders/add" class="btn-floating btn waves-effect waves-light red btn-add tooltipped"
                           data-position="bottom" data-tooltip="dodaj"><i
                                class="material-icons">add</i></a>
                    </c:if>
                    <div class="table-overflow">
                        <table class="highlight centered responsive-table">
                            <thead>
                            <tr>
                                <th>Data przyjęcia do naprawy</th>
                                <th>Data rozpoczęcia naprawy</th>
                                <th>Opis problemu</th>
                                <th>Pojazd którego dotyczy naprawa</th>
                                <th>Status</th>
                                <th>Szczegóły</th>
                                <c:if test="${employeeName == null}">
                                    <th>Pracownik</th>
                                    <c:if test="${customerName ==null}">
                                        <th colspan="2">Więcej</th>
                                    </c:if>
                                </c:if>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="order" items="${orders}" varStatus="iter">
                                <tr>
                                    <td>${order.acceptRepair}</td>
                                    <td>${order.startRepair}</td>
                                    <td>${order.problemDescription}</td>
                                    <td>${order.vehicle.registry} ${order.vehicle.brand}</td>
                                    <td>${order.status.title}</td>
                                    <td><a href="/orders/details?id=${order.id}" class="tooltipped"
                                           data-position="bottom"
                                           data-tooltip="szczegóły"><i class="material-icons">more</i></a>
                                    </td>
                                    <c:if test="${employeeName == null}">
                                        <td>${order.employee.firstName} ${order.employee.lastName}</td>
                                        <c:if test="${customerName == null}">
                                            <td><a href="/orders/edit?id=${order.id}" class="tooltipped"
                                                   data-position="bottom"
                                                   data-tooltip="edytuj"><i class="material-icons">edit</i></a>
                                            </td>
                                            <td>
                                                <!-- Modal Trigger -->
                                                <a class="modal-trigger tooltipped" href="#modal${iter.index}"
                                                   data-position="bottom"
                                                   data-tooltip="usuń"><i class="material-icons">delete</i></a>
                                                <!-- Modal Structure -->
                                                <div id="modal${iter.index}" class="modal">
                                                    <div class="modal-content">
                                                        <h4>Czy napewno chcesz usunąć zlecenie?</h4>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <a href="/orders/delete?id=${order.id}"
                                                           class="modal-close waves-effect waves-green btn-flat">Usuń</a>
                                                    </div>
                                                </div>
                                            </td>
                                        </c:if>
                                    </c:if>
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
<%@include file="../footer.jsp" %>
<script type="text/javascript" src="<c:url value="../../js/jquery-3.4.1.slim.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../../js/materialize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../../js/functions.js"/>"></script>
</body>
</html>
