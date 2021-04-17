package com.example.compta.Controllers;

import com.example.compta.Entities.Client;
import com.example.compta.Entities.ClientPersoneMoral;
import com.example.compta.Entities.Comptable;
import com.example.compta.Repositories.ClientPersoneMoralRepo;
import com.example.compta.Repositories.ClientRepo;
import com.example.compta.Repositories.ComptableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainDashboardController {


    @Autowired
    ComptableRepo comptableRepo; //get comptable repo bean
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    ClientPersoneMoralRepo clientPersoneMoralRepo;
    @GetMapping(value = "/")
    public String dashboard(){
        return "redirect:/dashboard/clients";
    }
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

        }
        else{

            List<Client> clients = comptableRepo.getByComptable_id((Integer)session.getAttribute("COMPTABLE_ID")).getClients();
            model.addAttribute("clients",clients);
            model.addAttribute("ALL_CLIENT",true);

        }
        return "clients";


    }

    @GetMapping(value = "dashboard/add_client")
    public String getaddClientView(){
        return "add_client";
    }

    @PostMapping(value = "dashboard/add_client")
    public String addClient(@RequestParam(name = "rais_soc" ,defaultValue = "off") String rais_soc,
                            @RequestParam(name = "tel" ,defaultValue = "off") String tel,
                            @RequestParam(name = "ice" ,defaultValue = "off") String ice,
                            @RequestParam(name = "tp" ,defaultValue = "off") String tp,
                            @RequestParam(name = "cif" ,defaultValue = "off") String cif,
                            @RequestParam(name = "debut_act" ,defaultValue = "off") String debut_act,
                            @RequestParam(name = "reg_com" ,defaultValue = "off") String reg_com,
                            @RequestParam(name = "aff_cnss" ,defaultValue = "off") String aff_cnss,
                            @RequestParam(name = "email" ,defaultValue = "off") String email,
                            @RequestParam(name = "ville" ,defaultValue = "off") String ville,
                            @RequestParam(name = "adrs" ,defaultValue = "off") String adrs
                            , HttpSession session,
                            Model model){
        String[] params = {rais_soc , tel , ice, tp , cif , debut_act , reg_com , aff_cnss , email ,ville , adrs};
        boolean paramCond = true;
        for (String param:params
             ) {
            if (param.equals("off")){
                paramCond = false;
                System.out.println(param);
                break;
            }
        }
        if (paramCond){
            String[] date = debut_act.split("-",3);

            int year = Integer.parseInt(date[0]);
            int mounth = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            ClientPersoneMoral clientPersoneMoral = new ClientPersoneMoral(rais_soc,tel,ice,tp,cif,new java.sql.Date(year,mounth,day),(Comptable)session.getAttribute("COMPTABLE"),adrs,reg_com,aff_cnss,email,ville);
            clientPersoneMoralRepo.save(clientPersoneMoral);
            model.addAttribute("message","données enregistrées, avec succès\n");
            return "add_client";
        }
        model.addAttribute("message","erreur! donnée incorrect");
        return "add_client";

    }

}
