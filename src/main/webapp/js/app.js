window.onload= function(){
    document.querySelector('.loading_page').style.display="none";
};


let nav_bnts = document.querySelector(".add_new_client_form_holder_nav_bar").children;
let clicked_btn = document.querySelector(".clicked_nav_btn");
let displayed_form = document.querySelector("#add_new_client_form_1");

for (let index = 0; index < nav_bnts.length; index++) {
    nav_bnts[index].addEventListener('click',function(){
        clicked_btn.classList.remove("clicked_nav_btn");
        nav_bnts[index].classList.add("clicked_nav_btn");
        clicked_btn = nav_bnts[index];

        displayed_form.style.display="none";
        let new_displayed_form = document.querySelector("#add_new_client_form_"+(index+1));
        new_displayed_form.style.display="flex";
        displayed_form = new_displayed_form;
    });

}
