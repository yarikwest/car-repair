<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign In</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/style.css"/>">
</head>
<body class="teal">
<main>
    <div class="container row">
        <div class="col m6 offset-m3 l6 offset-l3 xl4 offset-xl4 s10 offset-s1 card card-login z-depth-4">
            <div class="card-title card-title-login teal darken-1 white-text">
                <h6 class="center flow-text">Sign in to CRM</h6>
            </div>
            <div class="card-content">
                <form action="/login" method="post">
                    <c:if test="${foul}">
                        <div class="row red-text">
                            <h5>Niepoprawy login lub hasło</h5>
                        </div>
                    </c:if>
                    <div class="input-field">
                        <i class="material-icons prefix">account_box</i>
                        <input type="text" name="login" id="login" class="validate">
                        <label for="login">Login</label>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">lock</i>
                        <input type="password" name="password" id="password">
                        <label for="password">Password</label>
                    </div>
                    <div class="card-action">
                        <button class="btn col s12 m12 l12 xl12 waves-effect waves-light" type="submit" name="submit">
                            Sign in
                        </button>
                    </div>
                    <br>
                </form>
            </div>
        </div>
    </div>
</main>
<%@include file="footer.jsp" %>
<script type="text/javascript" src="<c:url value="../js/jquery-3.4.1.slim.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../js/materialize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../js/functions.js"/>"></script>
</body>
</html>
