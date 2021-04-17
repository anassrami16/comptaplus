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

                <div class="input_section">
                    <div class="field_holder"><label for="ice" >ICE: </label><input type="text" id="ice" name="ice" class="normal_field"></div>
                    <div class="field_holder"><label for="tp" >TP: </label><input type="text" id="tp" name="tp" class="normal_field"></div>
                    <div class="field_holder"><label for="cif" >CIF: </label><input type="text" id="cif" name="cif" class="normal_field"></div>
                </div>

                <div class="input_section">
                    <div class="field_holder"><label for="debut_act" >Debut Activité: </label><input type="date" id="debut_act" name="debut_act" class="normal_field"></div>
                    <div class="field_holder"><label for="reg_com" >registre commerse: </label><input type="text" id="reg_com" name="reg_com" class="normal_field"></div>
                    <div class="field_holder"><label for="aff_cnss" >affiliation cnss: </label><input type="text" id="aff_cnss" name="aff_cnss" class="normal_field"></div>
                </div>

                <div class="input_section">
                    <div class="field_holder"><label for="email" >email: </label><input type="email" id="email" name="email" class="normal_field"></div>
                    <div class="field_holder"><label for="ville" >Ville: </label><input type="tel" id="ville" name="ville" class="normal_field"> </div>
                    <div class="field_holder"><label for="adrs" >Adresse: </label><input type="text" id="adrs" name="adrs" class="normal_field"></div>
                </div>
                <div class="lone_input_section">
                    <div class="field_holder"><label for="rais_soc" >raison socialle</label><input type="text" id="rais_soc" name="rais_soc" class="normal_field"></div>
                    <div class="field_holder"><label for="tel" >tel: </label><input type="tel" id="tel" name="tel" class="normal_field"></div>

                </div>

                <button type="submit" form="add_new_client_form" class="add_client_button_submit">Ajouter</button>
                <h2>${message}</h2>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>
        </div>

    </div>
</div>

<script src="../../js/app.js" async></script>

</body>

</html>
