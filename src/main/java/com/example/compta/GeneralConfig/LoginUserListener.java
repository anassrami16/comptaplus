package com.example.compta.GeneralConfig;

import com.example.compta.Repositories.ComptableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpSession;
import java.security.Principal;


public class LoginUserListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    public ComptableRepo comptableRepo;
    @Autowired
    public HttpSession session;


    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent ) {
        Object principal = authenticationSuccessEvent.getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        session.setAttribute("COMPTABLE_ID" , comptableRepo.getByemail(username).getComptable_id());
        session.setAttribute("COMPTABLE",comptableRepo.getByemail(username));
    }
}
