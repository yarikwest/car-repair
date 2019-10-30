<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Customer</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="../../css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="../../css/style.css"/>">
</head>
<body>
<%@include file="../header.jsp" %>
<h2>Edytuj klienta</h2>
<hr>
<main>
    <form action="/customers/edit" method="post" class="container">
        <div class="input-field col s6">
            <i class="material-icons prefix">account_circle</i>
            <input id="first_name" type="text" class="validate" name="first_name" value="${customer.firstName}" required>
            <label for="first_name">Imię</label>
        </div>
        <div class="input-field col s6">
            <i class="material-icons prefix">account_box</i>
            <input id="last_name" type="text" class="validate" name="last_name" value="${customer.lastName}" required>
            <label for="last_name">Nazwisko</label>
        </div>
        <div class="input-field col s6">
            <i class="material-icons prefix">date_range</i>
            <input id="date_of_birth" type="text" class="datepicker" name="date_of_birth" value="${customer.dateOfBirth}">
            <label for="date_of_birth">Data urodzenia</label>
        </div>
        <input type="hidden" name="id" value="${customer.id}">
        <button class="btn waves-effect waves-light right" type="submit">
            Zapisz <i class="material-icons right">send</i>
        </button>
    </form>
</main>
<hr>
<%@include file="../footer.jsp" %>
<script type="text/javascript" src="<c:url value="../../js/jquery-3.4.1.slim.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../../js/materialize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../../js/functions.js"/>"></script>
</body>
</html>
