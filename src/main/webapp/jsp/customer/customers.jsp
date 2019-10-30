<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="../../css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="../../css/style.css"/>">
</head>
<body>
<%@include file="../header.jsp" %>
<h2>Klienci</h2>
<hr>
<main>
    <a href="/customers/add" class="btn-floating btn-large waves-effect waves-light red btn-add"><i
            class="material-icons">add</i></a>
    <table class="highlight centered">
        <thead>
        <tr>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Data urodzenia</th>
            <th>Pojazdy</th>
            <th>Zlecenia</th>
            <th colspan="2">Więcej</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}" varStatus="iter">
            <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.dateOfBirth}</td>
                <td><a href="/vehicles?ownerId=${customer.id}&ownerName=${customer.firstName} ${customer.lastName}"><i
                        class="material-icons">directions_car</i></a></td>
                <td><a href="/orders?customerId=${customer.id}"><i class="material-icons">visibility</i></a></td>
                <td><a href="/customers/edit?id=${customer.id}"><i class="material-icons">edit</i></a></td>
                <td>
                    <!-- Modal Trigger -->
                    <a class="modal-trigger" href="#modal${iter.index}"><i class="material-icons">delete</i></a>
                    <!-- Modal Structure -->
                    <div id="modal${iter.index}" class="modal">
                        <div class="modal-content">
                            <h4>Czy napewno chcesz usunąć klienta ${customer.firstName} ${customer.lastName}?</h4>
                        </div>
                        <div class="modal-footer">
                            <a href="/customers/delete?id=${customer.id}"
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
