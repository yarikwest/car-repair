<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
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
            <h5>Użytkownicy</h5>
            <div class="card">
                <div class="card-content">
                    <a href="/app/users/add"
                       class="btn-floating btn waves-effect waves-light red btn-add tooltipped"
                       data-position="bottom" data-tooltip="dodaj"><i
                            class="material-icons">add</i></a>
                    <div class="table-overflow">
                        <table class="highlight centered responsive-table">
                            <thead>
                            <tr>
                                <th>Login</th>
                                <th>Jest adminem</th>
                                <th colspan="2">Więcej</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${users}" varStatus="iter">
                                <tr>
                                    <td>${user.login}</td>
                                    <td>${user.admin}</td>
                                    <td>
                                        <a href="/app/users/edit?id=${user.id}" class="tooltipped"
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
                                                <h4>Czy napewno chcesz usunąć
                                                    użytkownika ${user.login}?</h4>
                                            </div>
                                            <div class="modal-footer">
                                                <a href="/app/users/delete?id=${user.id}"
                                                   class="modal-close waves-effect waves-green btn-flat">Usuń</a>
                                            </div>
                                        </div>
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
