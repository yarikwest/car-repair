<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Vehicle</title>
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
            <h5>Edytuj pojazd</h5>
            <div class="card">
                <div class="card-content">
                    <form action="/app/vehicles/edit" method="post" class="container">
                        <div class="input-field">
                            <input id="brand" type="text" class="validate" name="brand" value="${vehicle.brand}">
                            <label for="brand">Marka</label>
                        </div>
                        <div class="input-field">
                            <input id="model" type="text" class="validate" name="model" value="${vehicle.model}">
                            <label for="model">Model</label>
                        </div>
                        <div class="input-field">
                            <input id="year_of_prod" type="number" min="1901" max="2155" class="validate"
                                   name="year_of_prod"
                                   value="${vehicle.yearOfProd}">
                            <label for="year_of_prod">Rok produkcji</label>
                        </div>
                        <div class="input-field">
                            <input id="registry" type="text" class="validate" name="registry"
                                   value="${vehicle.registry}">
                            <label for="registry">Nr.rejestracyjny</label>
                        </div>
                        <div class="input-field">
                            <input id="next_inspection" type="text" class="datepicker" name="next_inspection"
                                   value="${vehicle.nextInspection}">
                            <label for="next_inspection">Następny przegląd</label>
                        </div>
                        <div class="input-field">
                            <input type="hidden" name="owner_id" value="${vehicle.ownerId}">
                            <button class="btn waves-effect waves-light right" type="submit" name="id"
                                    value="${vehicle.id}">
                                Zapisz <i class="material-icons right">send</i>
                            </button>
                        </div>
                    </form>
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
