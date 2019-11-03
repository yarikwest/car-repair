<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Select Report</title>
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
            <h5>Wybór raportu</h5>
            <div class="card">
                <div class="card-content">
                    <form action="/app/reports" method="post" class="container">
                        <div class="row">
                            <div class="input-field col s6">
                                <i class="material-icons prefix">date_range</i>
                                <input id="start_date" type="text" class="datepicker validate" name="start_date"
                                       required pattern="[12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01])">
                                <label for="start_date">Data od</label>
                            </div>
                            <div class="input-field col s6">
                                <i class="material-icons prefix">date_range</i>
                                <input id="end_date" type="text" class="datepicker validate" name="end_date"
                                       required pattern="[12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01])">
                                <label for="end_date">Data do</label>
                            </div>
                        </div>
                        <div class="input-field">
                            <i class="material-icons prefix">assessment</i>
                            <select name="report_type">
                                <option value="report_hours">Raport roboczogodzin</option>
                                <option value="report_profit">Raport zusków</option>
                            </select>
                            <label>Raport</label>
                        </div>
                        <div class="input-item">
                            <button class="btn waves-effect waves-light right" type="submit">
                                Dalej <i class="material-icons right">send</i>
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
