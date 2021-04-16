package com.example.compta.Controllers;

import com.example.compta.Entities.Client;
import com.example.compta.Entities.Comptable;
import com.example.compta.Repositories.ClientRepo;
import com.example.compta.Repositories.ComptableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class MainDashboardController {


    @Autowired
    ComptableRepo comptableRepo; //get comptable repo bean
    @Autowired
    ClientRepo clientRepo;

    @GetMapping(value = "/dashboard/clients")
    public String clientsSection(Principal principal , Model model , HttpSession session){
        Integer comptable_id= (Integer) session.getAttribute("COMPTABLE_ID");



        model.addAttribute("clients_count",comptableRepo.getByComptable_id(comptable_id).getClients().size());
        return "clients";
    }

    @PostMapping(value = "dashboard/clients")
    public String searchClient(Principal principal , Model model , @RequestParam(name = "cin_value", defaultValue = "off") String cin, HttpSession session){
        Integer comptable_id= (Integer) session.getAttribute("COMPTABLE_ID");
        model.addAttribute("clients_count",comptableRepo.getByComptable_id(comptable_id).getClients().size());

        if(!cin.equals("off")){
            try {
                Client client = clientRepo.getByCinFor(cin,comptableRepo.getByComptable_id((Integer)session.getAttribute("COMPTABLE_ID")));
                if (client != null){
                    model.addAttribute("client",client);
                    model.addAttribute("IS_FOUND",true);
                }else{
                    model.addAttribute("NOT_FOUND",true);
                }
            }
            catch (Exception e){
                System.out.println(e);
            }

            return "clients";
        }

        return "redirect:/dashboard/clients";
    }

    @GetMapping(value = "dashboard/add_client")
    public String addClient(){
        return "add_client";
    }

}
