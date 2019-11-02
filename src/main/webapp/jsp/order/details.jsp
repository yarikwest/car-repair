<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order Details</title>
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
        <jsp:include page="/jsp/navbar.jsp"/>
        <div class="col s12 l9">
            <h5>Szczegóły zlecenia</h5>
            <div class="card">
                <div class="row row-margin0">
                    <div class="col s5">
                        <span>Numer zlecenia: ${order.id}</span>
                    </div>
                    <div class="card-tabs col s7">
                        <ul class="tabs tabs-fixed-width ">
                            <li class="tab"><a href="#details">Szczegóły</a></li>
                            <li class="tab"><a href="#employee">Pracownik</a></li>
                            <li class="tab"><a href="#customer">Klient</a></li>
                            <li class="tab"><a href="#vehicle">Samochód</a></li>
                        </ul>
                    </div>
                </div>
                <div class="divider"></div>
                <div class="card-content">
                    <div id="details">
                        <div class="row">
                            <div class="col s4">
                                <span>Data przyjęcia do naprawy</span><br>
                                <strong>${order.acceptRepair}</strong>
                            </div>
                            <div class="col s4">
                                <span>Planowana data rozpoczęcia naprawy</span><br>
                                <strong>${order.planStartRepair}</strong>
                            </div>
                            <div class="col s4">
                                <span>Data rozpoczęcia naprawy</span><br>
                                <strong>${order.startRepair}</strong>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s4">
                                <span>Przypisany do naprawy pracownik</span><br>
                                <strong>${order.employee.firstName} ${order.employee.lastName}</strong>
                            </div>
                            <div class="col s4">
                                <span>Status</span><br>
                                <strong>${order.status.title}</strong>
                            </div>
                            <div class="col s4">
                                <span>Pojazd którego dotyczy naprawa</span><br>
                                <strong>${order.vehicle.model} ${order.vehicle.registry}</strong>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s4">
                                <span>Data zakończenia naprawy</span><br>
                                <strong>${order.endRepair}</strong>
                            </div>
                            <div class="col s4">
                                <span>Opis problemu</span><br>
                                <strong>${order.problemDescription}</strong>
                            </div>
                            <div class="col s4">
                                <span>Opis naprawy</span><br>
                                <strong>${order.repairDescription}</strong>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s4">
                                <span>Koszt naprawy dla klienta</span><br>
                                <strong>${order.costOfRepair}</strong>
                            </div>
                            <div class="col s4">
                                <span>Koszt wykorzystanych części</span><br>
                                <strong>${order.costOfParts}</strong>
                            </div>
                            <div class="col s4">
                                <span>Koszt roboczogodziny</span><br>
                                <strong>${order.costOfWorkHour}</strong>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s4">
                                <span>Ilość roboczogodzin</span><br>
                                <strong>${order.numberWorkHour}</strong>
                            </div>
                        </div>
                    </div>
                    <div id="employee">
                        <div class="row">
                            <div class="col s4">
                                <span>Imię</span><br>
                                <strong>${order.employee.firstName}</strong>
                            </div>
                            <div class="col s4">
                                <span>Nazwisko</span><br>
                                <strong>${order.employee.lastName}</strong>
                            </div>
                            <div class="col s4">
                                <span>Dane adresowe</span><br>
                                <strong>${order.employee.address}</strong>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s4">
                                <span>Nr telefon</span><br>
                                <strong>${order.employee.telephone}</strong>
                            </div>
                            <div class="col s4">
                                <span>Notatka</span><br>
                                <strong>${order.employee.note}</strong>
                            </div>
                            <div class="col s4">
                                <span>Koszt roboczogodziny</span><br>
                                <strong>${order.employee.costOfWorkHour}</strong>
                            </div>
                        </div>
                    </div>
                    <div id="customer">
                        <div class="row">
                            <div class="col s4">
                                <span>Imię</span><br>
                                <strong>${customer.firstName}</strong>
                            </div>
                            <div class="col s4">
                                <span>Nazwisko</span><br>
                                <strong>${customer.lastName}</strong>
                            </div>
                            <div class="col s4">
                                <span>Data urodzenia</span><br>
                                <strong>${customer.dateOfBirth}</strong>
                            </div>
                        </div>
                    </div>
                    <div id="vehicle">
                        <div class="row">
                            <div class="col s4">
                                <span>Marka</span><br>
                                <strong>${order.vehicle.brand}</strong>
                            </div>
                            <div class="col s4">
                                <span>Model</span><br>
                                <strong>${order.vehicle.model}</strong>
                            </div>
                            <div class="col s4">
                                <span>Rok produkcji</span><br>
                                <strong>${order.vehicle.yearOfProd}</strong>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s4">
                                <span>Numer rejestracyjny</span><br>
                                <strong>${order.vehicle.registry}</strong>
                            </div>
                            <div class="col s4">
                                <span>Data kolejnego przeglądu technicznego</span><br>
                                <strong>${order.vehicle.nextInspection}</strong>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="divider"></div>
                    <div class="card-action">
                        <div class="row row-margin0">
                            <div class="col offset-s11">
                                <a href="/orders/edit?id=${order.id}" class="tooltipped" data-position="bottom"
                                   data-tooltip="edytuj"><i class="material-icons">edit</i></a>
                            </div>
                        </div>
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
