<%--
  Created by IntelliJ IDEA.
  User: astro
  Date: 4/16/2021
  Time: 6:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Espace Client</title>

    <link href="../../css/style.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
          integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
</head>

<body>
<div class="loading_page">
    <div class="loader"></div>
</div>
<!-- the main container that hold everything-->
<div class="root_container">
    <%@include file="navbar.jsp"%>
    <div class="work_area">

        <div class="add_new_client_form_holder">
            <form action="" method="POST" class="add_new_client_form" id="add_new_client_form">

                <label for="client_fname_field">nom</label>
                <input type="text" id="client_fname_field" name="client_fname" class="normal_field" >

                <label for="client_lname_field">prénom</label>
                <input type="text" id="client_lname_field" name="client_lname" class="normal_field">

                <label for="client_entreprise_field">entreprise</label>
                <input type="text" id="client_entreprise_field" name="client_entreprise" class="normal_field">

                <label for="client_tel_field">tel</label>
                <input type="tel" id="client_tel_field" name="client_tel" class="normal_field">

                <label for="client_cin_field">nom</label>
                <input type="text" id="client_cin_field" name="client_cin" class="normal_field">

                <button type="submit" form="add_new_client_form" class="add_client_button_submit">Ajouter</button>
            </form>
        </div>

    </div>
</div>

<script src="../../js/app.js" async></script>

</body>

</html>
