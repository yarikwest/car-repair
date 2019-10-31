//Initialization for select elements in Form
$(document).ready(function () {
    $('select').formSelect();
});

//Initialization to open slide out menu
$(document).ready(function () {
    $('.sidenav').sidenav();
});

//Initialization to open a modal using a trigger:
$(document).ready(function () {
    $('.modal').modal();
});

//Initialization to open popup calendar
$(document).ready(function(){
    $('.datepicker').datepicker({format: 'yyyy-mm-dd', showClearBtn: true});
});

//Initialization for tooltips
$(document).ready(function(){
    $('.tooltipped').tooltip();
});
