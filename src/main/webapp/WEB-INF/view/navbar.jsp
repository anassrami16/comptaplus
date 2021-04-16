<%--
  Created by IntelliJ IDEA.
  User: astro
  Date: 4/15/2021
  Time: 6:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- the root nav bar container -->
<div class="root_nav_bar">
    <div class="profile_picture">

    </div>

    <div class="root_nav_bar_links_container">
        <div class="root_nav_bar_generalinfo_link"><i class="fas fa-user fa-2x"></i></div>
    </div>

</div>

<!-- sub nav bar -->
<div class="sub_nav_bar">
    <!-- the first sub container that containl general info-->
    <div class="generalinfo_section">
        <a class="add_client_button" href="/dashboard/add_client">+ Ajouter un client</a>
        <!-- general info links holder -->
        <div class="sub_nav_bar_generalinfo_links">

            <div class="sub_link_holder">

                <a href="#"><i class="fas fa-info-circle"></i>&nbsp;&nbsp;informations</a>
            </div>
            <div class="sub_link_holder">

                <a href="${pageContext.request.contextPath}/dashboard/clients"><i class="fas fa-user-check"></i>&nbsp;&nbsp;voir mes clients</a>
            </div>

        </div>

    </div>
</div>
