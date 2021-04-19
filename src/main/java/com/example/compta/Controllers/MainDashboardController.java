package com.example.compta.Controllers;

import com.example.compta.Entities.*;
import com.example.compta.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.sql.Date;
import java.util.List;

@Controller
public class MainDashboardController {


    @Autowired
    ComptableRepo comptableRepo; //get comptable repo bean
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    ClientPersoneMoralRepo clientPersoneMoralRepo;
    @Autowired
    ClientGeneraleRepo clientGeneraleRepo;
    @Autowired
    ClientPhysiqueRepo clientPhysiqueRepo;

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

    @PostMapping(value = "dashboard/add_client_person_moral")
    public String addClientMorale(@RequestParam(name = "rais_soc" ,defaultValue = "off") String rais_soc,
                            @RequestParam(name = "tel" ,defaultValue = "off") String tel,
                            @RequestParam(name = "ice" ,defaultValue = "off") String ice,
                            @RequestParam(name = "tp" ,defaultValue = "off") String tp,
                            @RequestParam(name = "_if" ,defaultValue = "off") String _if,
                            @RequestParam(name = "debut_act" ,defaultValue = "off") String debut_act,
                            @RequestParam(name = "reg_com" ,defaultValue = "off") String reg_com,
                            @RequestParam(name = "aff_cnss" ,defaultValue = "off") String aff_cnss,
                            @RequestParam(name = "email" ,defaultValue = "off") String email,
                            @RequestParam(name = "ville" ,defaultValue = "off") String ville,
                            @RequestParam(name = "adrs" ,defaultValue = "off") String adrs,
                            @RequestParam(name ="login_dam",defaultValue = "off") String login_dam,
                            @RequestParam(name ="passwd_dam",defaultValue = "off") String passwd_dam,
                            @RequestParam(name ="login_dci",defaultValue = "off") String login_dci,
                            @RequestParam(name ="passwd_dci",defaultValue = "off") String passwd_dci
                            , HttpSession session,
                            Model model){
        String[] params = {rais_soc , tel , ice, tp , _if , debut_act , reg_com , aff_cnss , email ,ville , adrs,login_dam,passwd_dam,login_dci,passwd_dci};
        boolean paramCond = true;
        for (String param:params
             ) {
            if (param.equals("off")){
                paramCond = false;
                break;
            }
        }

        try {
            if (paramCond){
                //converting string date value stored in param to java.sql.Date
                Date date_debut_act = Date.valueOf(debut_act);
                //creating clientGenerale and clientPersoneMoral instance
                ClientGenerale clientGenerale = new ClientGenerale(email,tel,ville,adrs,(Comptable)session.getAttribute("COMPTABLE"));
                ClientPersoneMoral clientPersoneMoral = new ClientPersoneMoral(rais_soc,ice,tp,_if,date_debut_act,reg_com,aff_cnss,clientGenerale);
                CompteDci compteDci = new CompteDci(login_dci,passwd_dci,clientGenerale);
                CompteDam compteDam = new CompteDam(login_dam,passwd_dam,clientGenerale);

                clientGenerale.setCompteDci(compteDci);
                clientGenerale.setCompteDam(compteDam);
                clientGenerale.setClientPersoneMorales(clientPersoneMoral);
                //saving objects to database
                clientGeneraleRepo.save(clientGenerale);
                model.addAttribute("message","données enregistrées, avec succès\n");
                return "add_client";
            }
            model.addAttribute("message","erreur! donnée incorrect");
            return "add_client";

        }catch (Exception e){
            System.out.println(e);
            model.addAttribute("message","erreur! donnée incorrect");
            return "add_client";
        }

    }
    @PostMapping(value = "dashboard/add_client_person_physique")
    public String addClientPhysique(@RequestParam(name = "nom" ,defaultValue = "off") String nom,
                                    @RequestParam(name = "prenom" ,defaultValue = "off") String prenom,
                                    @RequestParam(name = "email" ,defaultValue = "off") String email,
                                    @RequestParam(name = "ville" ,defaultValue = "off") String ville,
                                    @RequestParam(name = "adrs" ,defaultValue = "off") String adrs,
                                    @RequestParam(name = "tel" ,defaultValue = "off") String tel,
                                    @RequestParam(name = "cpu" ,defaultValue = "off") String cpu,Model model,HttpSession session){
        String[] params = {nom , prenom , email , ville , adrs , tel , cpu};
        boolean paramCond = true;
        for (String param:params
        ) {
            if (param.equals("off")){
                paramCond = false;
                break;
            }
        }
        try {
            if(paramCond){
                ClientGenerale clientGenerale = new ClientGenerale(email,tel,ville,adrs,(Comptable)session.getAttribute("COMPTABLE"));
                ClientPhysique clientPhysique = new ClientPhysique(nom,prenom,cpu,clientGenerale);
                clientGenerale.setClientPhysiques(clientPhysique);
                clientGeneraleRepo.save(clientGenerale);
                model.addAttribute("message","données enregistrées, avec succès\n");
                return "add_client";
            }
            else{
                model.addAttribute("message","erreur! donnée incorrect");
                return "add_client";
            }
        }catch (Exception e){
            model.addAttribute("message","erreur! Une erreur c'est produit durant l'insertion des données");
            return "add_client";
        }
    }


    @PostMapping(value = "dashboard/add_client_revenu_fonciere")
    public String addClientRevenuFonciere(@RequestParam(name = "nom_locateur" ,defaultValue = "off") String nomLocateur,
                                          @RequestParam(name = "pre_locateur" ,defaultValue = "off") String preLocateur,
                                          @RequestParam(name = "nom_locataire" ,defaultValue = "off") String nomLocataire,
                                          @RequestParam(name = "pre_locataire" ,defaultValue = "off") String preLocataire,
                                          @RequestParam(name = "email" ,defaultValue = "off") String email,
                                          @RequestParam(name = "ville" ,defaultValue = "off") String ville,
                                          @RequestParam(name = "adrs" ,defaultValue = "off") String adrs,
                                          @RequestParam(name = "tel" ,defaultValue = "off") String tel,
                                          @RequestParam(name = "_if" ,defaultValue = "off") String _if,
                                          @RequestParam(name = "login_dci" ,defaultValue = "off") String login_dci,
                                          @RequestParam(name = "passwd_dci" ,defaultValue = "off") String passwd_dci,
                                          @RequestParam(name = "ville_loc" ,defaultValue = "off") String villeLoc,
                                          @RequestParam(name = "adrs_loc" ,defaultValue = "off") String adrsLoc,
                                          @RequestParam(name = "ville_loy" ,defaultValue = "off") String villeLoy,
                                          @RequestParam(name = "adrs_loy" ,defaultValue = "off") String adrsLoy,
                                          @RequestParam(name = "mnt_men" ,defaultValue = "off") String mnt_men,
                                          @RequestParam(name = "mnt_ann" ,defaultValue = "off") String mnt_ann,
                                          @RequestParam(name = "tsc" ,defaultValue = "off") String tsc,Model model,HttpSession session){
        String[] params = {nomLocateur,preLocateur,email,ville,adrs,tel,_if,login_dci,passwd_dci,villeLoc,adrsLoc,villeLoc,villeLoy,adrsLoy,mnt_men,mnt_ann,tsc};
        boolean paramCond = true;
        for (String param:params
        ) {
            if (param.equals("off")){
                paramCond = false;
                break;
            }
        }
        try {
            if(paramCond){
                ClientGenerale clientGenerale = new ClientGenerale(email,tel,ville,adrs,(Comptable)session.getAttribute("COMPTABLE"));
                ClientRevenueFoncier clientRevenueFoncier = new ClientRevenueFoncier(_if,tsc,nomLocataire,preLocataire,villeLoy,adrsLoy,Integer.parseInt(mnt_men),Integer.parseInt(mnt_ann),adrsLoc,villeLoc,clientGenerale,nomLocateur,preLocateur);
                CompteDci compteDci = new CompteDci(login_dci,passwd_dci,clientGenerale);
                clientGenerale.setCompteDci(compteDci);
                clientGenerale.setClientRevenueFonciers(clientRevenueFoncier);

                clientGeneraleRepo.save(clientGenerale);
                model.addAttribute("message","données enregistrées, avec succès\n");
                return "add_client";
            }
            else{
                model.addAttribute("message","erreur! donnée incorrect");
                return "add_client";
            }
        }catch (Exception e){
            model.addAttribute("message","erreur! Une erreur c'est produit durant l'insertion des données");
            return "add_client";
        }
    }

}
