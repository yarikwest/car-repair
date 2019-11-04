<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Error Page</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/materialize.min.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body class="teal">
<main>
    <div class="container row">
        <div class="col m6 offset-m3 l6 offset-l3 xl4 offset-xl4 s10 offset-s1 card card-login z-depth-4">
            <div class="card-title card-title-login teal darken-1 white-text">
                <h6 class="center flow-text">Nie ma takiej strony</h6>
            </div>
            <div class="card-content">
                <div class="row">
                    <a href="/app" class="waves-effect waves-light btn col s12 m8 l6 offset-m2 offset-l3">Na główną</a>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="footer.jsp" %>
<script type="text/javascript" src="<c:url value="/js/jquery-3.4.1.slim.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/materialize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/functions.js"/>"></script>
</body>
</html>
