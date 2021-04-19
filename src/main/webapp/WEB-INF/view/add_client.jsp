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
            <div class="add_new_client_form_holder_nav_bar">
                <div class="nav_element clicked_nav_btn" id="nav_btn_1"><p><i class="far fa-building"></i>clientele persone marale</p> </div>
                <div class="nav_element" id="nav_btn_2" style="border-left:2px solid white; border-right:2px solid white;"><p><i class="far fa-user"></i>clientele persone physique</p></div>
                <div class="nav_element" id="nav_btn_3" ><p><i class="fas fa-sign"></i>clientele revenu fonciere</p></div>
            </div>
            <form action="${pageContext.request.contextPath}/dashboard/add_client_person_moral" method="POST" class="add_new_client_form" id="add_new_client_form_1">

                <div class="input_section">
                    <div class="field_holder"><label for="ice" >ICE: </label><input type="text" id="ice" name="ice" class="normal_field"></div>
                    <div class="field_holder"><label for="tp" >TP: </label><input type="text" id="tp" name="tp" class="normal_field"></div>
                    <div class="field_holder"><label for="_if" >CIF: </label><input type="text" id="_if" name="_if" class="normal_field"></div>
                </div>
                <div class="input_section">
                    <div class="field_holder"><label for="debut_act" >Debut Activité: </label><input type="date" id="debut_act" name="debut_act" class="normal_field"></div>
                    <div class="field_holder"><label for="reg_com" >registre commerse: </label><input type="text" id="reg_com" name="reg_com" class="normal_field"></div>
                    <div class="field_holder"><label for="aff_cnss" >affiliation cnss: </label><input type="text" id="aff_cnss" name="aff_cnss" class="normal_field"></div>
                </div>

                <div class="input_section">
                    <div class="field_holder"><label for="email" >email: </label><input type="email" id="email" name="email" class="normal_field"></div>
                    <div class="field_holder"><label for="ville" >Ville: </label><input type="text" id="ville" name="ville" class="normal_field"> </div>
                    <div class="field_holder"><label for="adrs" >Adresse: </label><input type="text" id="adrs" name="adrs" class="normal_field"></div>
                </div>
                <div class="input_section">
                    <div class="field_holder"><label for="rais_soc" >raison socialle</label><input type="text" id="rais_soc" name="rais_soc" class="normal_field"></div>
                    <div class="field_holder"><label for="tel" >tel: </label><input type="tel" id="tel" name="tel" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>
                <div class="input_section">
                    <div class="field_holder"><label for="login_dam" >Login Damancom</label><input type="text" id="login_dam" name="login_dam" class="normal_field"></div>
                    <div class="field_holder"><label for="passwd_dam" >Mot de pass </label><input type="text" id="passwd_dam" name="passwd_dam" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>
                <div class="input_section">
                    <div class="field_holder"><label for="login_dci" >Login DCI</label><input type="text" id="login_dci" name="login_dci" class="normal_field"></div>
                    <div class="field_holder"><label for="passwd_dci" >Mot de pass </label><input type="text" id="passwd_dci" name="passwd_dci" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>
                <button type="submit" form="add_new_client_form_1" class="add_client_button_submit">Ajouter</button>
                <h2>${message}</h2>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>

            <form action="${pageContext.request.contextPath}/dashboard/add_client_person_physique" method="POST" class="add_new_client_form" id="add_new_client_form_2">


                <div class="input_section">
                    <div class="field_holder"><label for="nom" >nom: </label><input type="text" id="nom" name="nom" class="normal_field"></div>
                    <div class="field_holder"><label for="prenom" >prénom: </label><input type="text" id="prenom" name="prenom" class="normal_field"> </div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>

                <div class="input_section">
                    <div class="field_holder"><label for="email" >email: </label><input type="email" id="email_cp" name="email" class="normal_field"></div>
                    <div class="field_holder"><label for="ville" >Ville: </label><input type="text" id="ville_cp" name="ville" class="normal_field"> </div>
                    <div class="field_holder"><label for="adrs" >Adresse: </label><input type="text" id="adrs_cp" name="adrs" class="normal_field"></div>
                </div>
                <div class="input_section">

                    <div class="field_holder"><label for="tel" >tel: </label><input type="tel" id="tel_c" name="tel" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>
                <div class="input_section">

                    <div class="field_holder"><label for="cpu" >CPU: </label><input type="text" id="cpu" name="cpu" class="normal_field"></div>

                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>

                <h2>${message}</h2>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <button type="submit" form="add_new_client_form_2" class="add_client_button_submit">Ajouter</button>
            </form>

            <form action="${pageContext.request.contextPath}/dashboard/add_client_revenu_fonciere" method="POST" class="add_new_client_form" id="add_new_client_form_3">


                <h2>Information locateur(client)</h2>
                <div class="input_section">
                    <div class="field_holder"><label for="nom_locateur" >nom locataire</label><input type="text" id="nom_locateur" name="nom_locateur" class="normal_field"></div>
                    <div class="field_holder"><label for="pre_locateur" >prénom locataire</label><input type="text" id="pre_locateur" name="pre_locateur" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>
                <div class="input_section">
                    <div class="field_holder"><label for="email_crf" >email: </label><input type="email" id="email_crf" name="email" class="normal_field"></div>
                    <div class="field_holder"><label for="ville_crf" >Ville: </label><input type="text" id="ville_crf" name="ville" class="normal_field"> </div>
                    <div class="field_holder"><label for="adrs_crf" >Adresse: </label><input type="text" id="adrs_crf" name="adrs" class="normal_field"></div>
                </div>
                <div class="input_section">
                    <div class="field_holder"><label for="tel_crf" >tel: </label><input type="tel" id="tel_crf" name="tel" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>
                <div class="input_section">
                    <div class="field_holder"><label for="_if_crf" >IF: </label><input type="text" id="_if_crf" name="_if" class="normal_field"></div>
                    <div class="field_holder"><label for="tsc" >TSC: </label><input type="text" id="tsc" name="tsc" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>
                <div class="input_section">
                    <div class="field_holder"><label for="login_dci_crf" >Login DCI</label><input type="text" id="login_dci_crf" name="login_dci" class="normal_field"></div>
                    <div class="field_holder"><label for="passwd_dci" >Mot de pass </label><input type="text" id="passwd_dci_crf" name="passwd_dci" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>
                <h2>Information locataire</h2>
                <div class="input_section">
                    <div class="field_holder"><label for="nom_locataire" >nom locataire</label><input type="text" id="nom_locataire" name="nom_locataire" class="normal_field"></div>
                    <div class="field_holder"><label for="pre_locataire" >prénom locataire</label><input type="text" id="pre_locataire" name="pre_locataire" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>
                <h3>Address locataire</h3>
                <div class="input_section">
                    <div class="field_holder"><label for="ville_loc" >Ville: </label><input type="text" id="ville_loc" name="ville_loc" class="normal_field"> </div>
                    <div class="field_holder"><label for="adrs_loc" >Adresse: </label><input type="text" id="adrs_loc" name="adrs_loc" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>
                <h3>Address Imeuble loyé</h3>
                <div class="input_section">
                    <div class="field_holder"><label for="ville_loy" >Ville: </label><input type="text" id="ville_loy" name="ville_loy" class="normal_field"> </div>
                    <div class="field_holder"><label for="adrs_loy" >Adresse: </label><input type="text" id="adrs_loy" name="adrs_loy" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>
                <h3>Montnat mensuelle/annuelle</h3>
                <div class="input_section">
                    <div class="field_holder"><label for="mnt_men" >Mnt mensuell: (DH)</label><input type="number" id="mnt_men" name="mnt_men" class="normal_field"> </div>
                    <div class="field_holder"><label for="mnt_ann" >Mnt Annuelle: (DH) </label><input type="number" id="mnt_ann" name="mnt_ann" class="normal_field"></div>
                    <div class="field_holder"><label  ></label><input type="hidden" class="normal_field"></div>
                </div>


                <h2>${message}</h2>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <button type="submit" form="add_new_client_form_3" class="add_client_button_submit">Ajouter</button>
            </form>
        </div>

    </div>

</div>

<script src="../../js/app.js" async></script>

</body>

</html>
