$(document).ready(function () {
    $('select').formSelect(); //Initialization for select elements in Form
    $('textarea').characterCounter(); //Initialization for character counter
    $('.modal').modal(); //Initialization to open a modal using a trigger:
    $('.sidenav').sidenav(); //Initialization to open slide out menu
    $('.tooltipped').tooltip(); //Initialization for tooltips
    $('.tabs').tabs(); //Initialization for tabs
    $('.datepicker').datepicker({format: 'yyyy-mm-dd', showClearBtn: true}); //Initialization to open popup calendar
});

//Auto filling of value for costOfWorkHour
$('#employee').change(function () {
    $("#cost_of_work_hour").val($('#employee option:selected').data('costOfWorkHour'));
});

document.getElementById("updateLoginLink").onclick = function () {
    document.getElementById("updateLoginForm").submit();
};
document.getElementById("updatePassLink").onclick = function () {
    document.getElementById("updatePassForm").submit();
};
document.getElementById("updateStatusLink").onclick = function () {
    document.getElementById("updateStatusForm").submit();
};
