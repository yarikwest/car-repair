<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="hide-on-med-and-down col l3">
    <div class="card horizontal grey lighten-2">
        <div class="card-image">
            <img src="/images/baseline_account_box_black_48dp.png">
        </div>
        <div class="card-content">
            <p class="flow-text">${user.login}</p>
            <c:if test="${user.admin}">
                <span>Administrator</span>
            </c:if>
        </div>
    </div>
    <div class="collection collection-own">
        <a href="/app" class="collection-item collection-item-own"><i
                class="material-icons">home</i><span>Home</span></a>
        <a href="/app/orders" class="collection-item collection-item-own"><i
                class="material-icons">library_books</i>Zlecenia</a>
        <a href="/app/customers" class="collection-item collection-item-own"><i class="material-icons">group</i>Klienci</a>
        <c:if test="${user.admin}">
            <a href="/app/employees" class="collection-item collection-item-own"><i
                    class="material-icons">assignment_ind</i>Pracownicy</a>
            <a href="/app/reports" class="collection-item collection-item-own"><i
                    class="material-icons">insert_chart</i>Raporty</a>
        </c:if>
        <a href="/app/users<c:if test="${!user.admin}">/details</c:if>" class="collection-item collection-item-own"><i
                class="material-icons">settings</i>Ustawienia
            konta</a>
    </div>
</div>
