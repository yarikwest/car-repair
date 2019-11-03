<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History <c:if test="${vehicleName != null}">of ${vehicleName}</c:if></title>
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
            <h5>Historia <c:if test="${vehicleName != null}">samochodu ${vehicleName}</c:if></h5>
            <div class="card">
                <div class="card-content">
                    <div class="table-overflow">
                        <table class="highlight centered">
                            <thead>
                            <tr>
                                <th>Data rozpoczęcia naprawy</th>
                                <th>Opis naprawy</th>
                                <th>Szczegóły</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="order" items="${orders}">
                                <tr>
                                    <td>${order.startRepair}</td>
                                    <td>${order.repairDescription}</td>
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
<%@include file="../footer.jsp" %>
<script type="text/javascript" src="<c:url value="../../js/jquery-3.4.1.slim.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../../js/materialize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../../js/functions.js"/>"></script>
</body>
</html>
