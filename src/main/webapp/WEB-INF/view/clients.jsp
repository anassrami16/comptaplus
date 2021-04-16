<%--
  Created by IntelliJ IDEA.
  User: astro
  Date: 4/15/2021
  Time: 6:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- loading page -->
<div class="loading_page">
    <div class="loader"></div>
</div>
<!-- the main container that hold everything-->
<div class="root_container">

    <%@ include file="navbar.jsp"%>
    <div class="work_area">
        <div class="root_total_client_holder">
            <div class="total_client_title">
                <h2>Nombre Total des client</h2>
            </div>
            <div class="total_client_holder">
                <h2 class="total_client">${clients_count}</h2>
            </div>
        </div>

        <div class="client_search_area_holder">

            <form class="search_input_holder" action="/dashboard/clients" method="post" id="search_form">

                <div class="search_icon"><i class="fa fa-search"></i></div>
                <input type="search" class="search_input" id="search_input" placeholder="recherche par cin"
                       form="search_form" name="cin_value">
                <button href="#" class="search_button" type="submit" form="search_form">rechercher</button>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>

            <div class="result_area_holder">
                <c:choose>
                    <c:when test="${NOT_FOUND}"><div class="client_not_found"><h3>aucun client n'est trouver</h3></div></c:when>
                    <c:when test="${IS_FOUND}">
                        <div class="client_view">
                            <div class="client_profile_icon"></div>
                            <div class="personal_info">
                                <h5>nom: ${client.fname}</h5>
                                <h5>prénom: ${client.lname}</h5>
                            </div>
                            <div class="personal_info">
                                <h5>tel: ${client.tel}</h5>
                                <h5>entreprise: ${client.compname}</h5>
                            </div>
                        </div>
                    </c:when>
                </c:choose>

            </div>
        </div>
    </div>
</div>

<script src="../../js/app.js" async></script>
</body>

</html>
