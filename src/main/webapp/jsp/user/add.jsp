<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add User</title>
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
            <h5>Dodaj użytkownika</h5>
            <div class="card">
                <div class="card-content">
                    <h5 class="red-text">${error}</h5>
                    <form action="/app/users/add" method="post" class="container">
                        <div class="row">
                            <div class="input-field col s12 l6 offset-l3">
                                <i class="material-icons prefix">account_circle</i>
                                <input id="login" type="text" class="validate" name="login" required>
                                <label for="login">Login</label>
                            </div>
                            <div class="input-field col s12 l6 offset-l3">
                                <i class="material-icons prefix">lock_outline</i>
                                <input id="password" type="password" class="validate" name="password" required>
                                <label for="password">Hasło</label>
                            </div>
                            <div class="input-field col s12 l6 offset-l3">
                                <i class="material-icons prefix">lock</i>
                                <input id="password2" type="password" class="validate" name="password2" required>
                                <label for="password2">Powtórz hasło</label>
                            </div>
                            <div class="input-field col s12 l6 offset-l3">
                                <p>
                                    <label for="admin">
                                        <input type="checkbox" id="admin" name="admin" value="true"/>
                                        <span>Jest adminem</span>
                                    </label>
                                </p>
                            </div>
                            <div class="input-item col s12">
                                <button class="btn waves-effect waves-light right" type="submit">
                                    Zapisz <i class="material-icons right">send</i>
                                </button>
                            </div>
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
