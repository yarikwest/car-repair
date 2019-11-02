<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Order</title>
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
            <h5>Dodaj zlecenie</h5>
            <div class="card">
                <div class="card-content">
                    <form action="/orders/add" method="post" class="container">
                        <div class="row">
                            <div class="input-field col m12 l6">
                                <i class="material-icons prefix">date_range</i>
                                <input id="accept_repair" type="text" class="datepicker validate" name="accept_repair"
                                       required
                                       pattern="[12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01])">
                                <label for="accept_repair">Data przyjęcia do naprawy</label>
                            </div>
                            <div class="input-field col m12 l6">
                                <i class="material-icons prefix">date_range</i>
                                <input id="plan_start_repair" type="text" class="datepicker validate"
                                       name="plan_start_repair" required
                                       pattern="[12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01])">
                                <label for="plan_start_repair">Planowana data rozpoczęcia naprawy</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col m12 l6">
                                <i class="material-icons prefix">assignment_turned_in</i>
                                <select name="status">
                                    <option value="" selected>Wybierz status</option>
                                    <c:forEach var="status" items="${statuses}">
                                        <option value="${status.id}">${status.title}</option>
                                    </c:forEach>
                                </select>
                                <label>Status</label>
                            </div>
                            <div class="input-field col m12 l6">
                                <i class="material-icons prefix">date_range</i>
                                <input id="start_repair" type="text" class="datepicker" name="start_repair">
                                <label for="start_repair">Data rozpoczęcia naprawy</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col m12 l6">
                                <i class="material-icons prefix">person</i>
                                <select id="employee" name="employee">
                                    <option value="" selected>Wybierz pracownika</option>
                                    <c:forEach var="employee" items="${employees}">
                                        <option value="${employee.id}"
                                                data-cost-of-work-hour="${employee.costOfWorkHour}">${employee.firstName} ${employee.lastName}</option>
                                    </c:forEach>
                                </select>
                                <label for="employee">Przypisany do naprawy pracownik</label>
                            </div>
                            <div class="input-field col m12 l6">
                                <i class="material-icons prefix">attach_money</i>
                                <input id="cost_of_work_hour" type="text" class="validate" name="cost_of_work_hour"
                                       placeholder="Koszt roboczogodziny" readonly>
                                <label for="cost_of_work_hour">Koszt roboczogodziny</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col m12 l6">
                                <i class="material-icons prefix">directions_car</i>
                                <select name="vehicle">
                                    <option value="" selected>Wybierz samochód</option>
                                    <c:forEach var="vehicle" items="${vehicles}">
                                        <option value="${vehicle.id}">${vehicle.model} ${vehicle.registry}</option>
                                    </c:forEach>
                                </select>
                                <label>Pojazd którego dotyczy naprawa</label>
                            </div>
                            <div class="input-field col m12 l6">
                                <i class="material-icons prefix">description</i>
                                <textarea class="materialize-textarea" name="problem_description"
                                          id="problem_description"
                                          data-length="255"></textarea>
                                <label for="problem_description">Opis problemu</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col m12 l6">
                                <i class="material-icons prefix">date_range</i>
                                <input id="end_repair" type="text" class="datepicker" name="end_repair">
                                <label for="end_repair">Data zakończenia naprawy</label>
                            </div>
                            <div class="input-field col m12 l6">
                                <i class="material-icons prefix">description</i>
                                <textarea class="materialize-textarea" name="repair_description" id="repair_description"
                                          data-length="255"></textarea>
                                <label for="repair_description">Opis naprawy</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col m12 l6 xl4">
                                <i class="material-icons prefix">attach_money</i>
                                <input id="cost_of_repair" type="number" min="0.01" step="0.01" class="validate"
                                       name="cost_of_repair">
                                <label for="cost_of_repair">Koszt naprawy dla klienta</label>
                            </div>
                            <div class="input-field col m12 l6 xl4">
                                <i class="material-icons prefix">attach_money</i>
                                <input id="cost_of_parts" type="number" min="0.01" step="0.01" class="validate"
                                       name="cost_of_parts">
                                <label for="cost_of_parts">Koszt wykorzystanych części</label>
                            </div>
                            <div class="input-field col m12 l6 xl4">
                                <i class="material-icons prefix">access_time</i>
                                <input id="number_work_hour" type="number" min="0" step="0.25" class="validate"
                                       name="number_work_hour">
                                <label for="number_work_hour">Ilość roboczogodzin</label>
                            </div>
                        </div>
                        <div class="input-field">
                            <button class="btn waves-effect waves-light right" type="submit">
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
