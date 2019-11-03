<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Employee</title>
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
            <h5>Edytuj pracownika</h5>
            <div class="card">
                <div class="card-content">
                    <form action="/app/employees/edit" method="post" class="container">
                        <div class="row">
                            <div class="input-field col s6">
                                <i class="material-icons prefix">account_circle</i>
                                <input id="first_name" type="text" class="validate" name="first_name"
                                       value="${employee.firstName}"
                                       required>
                                <label for="first_name">Imię</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate" name="last_name"
                                       value="${employee.lastName}"
                                       required>
                                <label for="last_name">Nazwisko</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">home</i>
                                <input id="address" type="text" class="validate" name="address"
                                       value="${employee.address}">
                                <label for="address">Adres</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">phone</i>
                                <input id="telephone" type="text" class="validate" name="telephone"
                                       value="${employee.telephone}"
                                       pattern="\+?[0-9 ]{1,19}">
                                <label for="telephone">Telefon</label>
                                <span class="helper-text" data-error="wrong" data-success="right">numer typu +48 123 456 789 lub 123456789</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">note</i>
                                <input id="note" type="text" class="validate" name="note" value="${employee.note}">
                                <label for="note">Notatka</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">attach_money</i>
                                <input id="cost_of_work_hour" type="number" step="0.01" min="0.01" class="validate"
                                       name="cost_of_work_hour" value="${employee.costOfWorkHour}">
                                <label for="cost_of_work_hour">Koszt roboczogodziny</label>
                            </div>
                        </div>
                        <input type="hidden" name="id" value="${employee.id}">
                        <button class="btn waves-effect waves-light right" type="submit">
                            Zapisz <i class="material-icons right">send</i>
                        </button>
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
