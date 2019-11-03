<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Report Profit</title>
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
            <h5>Raport zysków</h5>
            <div class="card">
                <div class="card-content">
                    <div class="row">
                        <div class="col s9 offset-s1">
                            <canvas id="myChart"></canvas>
                        </div>
                        <div class="col s2 gradient-45deg-purple-amber">
                            <div class="card teal lighten-1 white-text">
                                <p>Suma zysków:</p>
                                <div class="divider"></div>
                                <p class="right-align">${sum}</p>
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
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script type="text/javascript" src="<c:url value="../../js/materialize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="../../js/functions.js"/>"></script>
<script>
    let tab = [];
    <c:forEach var="i" items="${map.keySet()}">
    tab.push("${i}");
    </c:forEach>
    var ctx = document.getElementById('myChart').getContext('2d');
    var chart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: tab,
            datasets: [{
                label: 'Profit',
                backgroundColor: 'rgba(38, 166, 154, 0.2)',
                borderColor: 'rgb(38, 166, 154)',
                borderWidth: 1,
                pointBackgroundColor: 'rgb(38, 166, 154)',
                data: ${map.values()}
            }]
        },
        options: {}
    });
</script>
</body>
</html>
