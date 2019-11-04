<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="teal darken-1">
    <div class="nav-wrapper">
        <a href="#" data-target="side-out" class="sidenav-trigger"><i class="material-icons">menu</i></a>
        <a href="/app" class="brand-logo center"><i class="material-icons">directions_car</i>- repair CRM</a>
        <ul class="right">
            <c:if test="${user != null}">
                <li><a href="/logout"><i class="material-icons left">format_indent_decrease</i>Logout</a></li>
            </c:if>
        </ul>
    </div>
</nav>
<ul class="sidenav" id="side-out">
    <li>
        <div class="teal">
            <div class="user-view">
                <img src="/images/baseline_account_box_black_48dp.png" class="circle">
                <h5>${user.login}</h5>
                <c:if test="${user.admin}">
                    <span>Administrator</span>
                </c:if>
            </div>
        </div>
    </li>
    <li>
        <a href="/app"><i class="material-icons">home</i><span>Home</span></a>
    </li>
    <li>
        <a href="/app/orders"><i class="material-icons">library_books</i>Zlecenia</a>
    </li>
    <li>
        <a href="/app/customers"><i class="material-icons">group</i>Klienci</a>
    </li>
    <c:if test="${user.admin}">
        <li>
            <a href="/app/employees"><i class="material-icons">assignment_ind</i>Pracownicy</a></li>
        <li>
            <a href="/app/reports"><i class="material-icons">insert_chart</i>Raporty</a>
        </li>
    </c:if>
    <li>
        <a href="/app/users<c:if test="${!user.admin}">/details</c:if>"><i class="material-icons">settings</i>Ustawienia
            konta</a>
    </li>
</ul>
