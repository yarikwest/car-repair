<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit User ${userEdit.login}</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body>
<%@include file="../header.jsp" %>
<main>
    <div class="row row-container">
        <jsp:include page="../navbar.jsp"/>
        <div class="col s12 l9">
            <h5>Edytuj użytkownika ${userEdit.login}</h5>
            <div class="card">
                <div class="card-content">
                    <h5 class="red-text">${error}</h5>
                    <div class="row">
                        <div class="col s8 l6 offset-l3 offset-s2">
                            <div class="card">
                                <form action="/app/users/details/change-login" method="post" id="updateLoginForm">
                                    <div class="card-content">
                                        <span class="card-title">Login</span>
                                        <input type="text" name="login" value="${userEdit.login}" required>
                                        <input type="hidden" name="id" value="${userEdit.id}" required>
                                    </div>
                                    <div class="card-action">
                                        <a href="#" id="updateLoginLink">Zmień login</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s8 l6 offset-l3 offset-s2">
                            <div class="card">
                                <form action="/app/users/details/change-password" method="post" id="updatePassForm">
                                    <div class="card-content">
                                        <span class="card-title">Hasło</span>

                                        <input id="oldPassword" type="password" class="validate" name="oldPassword"
                                               required>
                                        <label for="oldPassword">Stare hasło</label>

                                        <input id="password" type="password" class="validate" name="password" required>
                                        <label for="password">Hasło</label>

                                        <input id="password2" type="password" class="validate" name="password2"
                                               required>
                                        <label for="password2">Powtórz hasło</label>

                                        <input type="hidden" name="id" value="${userEdit.id}" required>
                                    </div>
                                    <div class="card-action">
                                        <a href="#" id="updatePassLink">Zmień hasło</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s8 l6 offset-l3 offset-s2">
                            <div class="card">
                                <form action="/app/users/details/change-status" method="post" id="updateStatusForm">
                                    <div class="card-content">
                                        <span class="card-title">Jest adminem</span>
                                        <p>
                                            <label for="admin">
                                                <input type="checkbox" id="admin" name="admin" value="true"/>
                                                <span></span>
                                            </label>
                                        </p>
                                        <input type="hidden" name="id" value="${userEdit.id}" required>
                                    </div>
                                    <div class="card-action">
                                        <a href="#" id="updateStatusLink">Zmień status</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="../footer.jsp" %>
<script type="text/javascript" src="<c:url value="/js/jquery-3.4.1.slim.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/materialize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/functions.js"/>"></script>
</body>
</html>
