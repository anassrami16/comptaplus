package com.example.compta.Entities;


import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "client_persone_moral")
public class ClientPersoneMoral {
    @Id
    @Column(name = "nordre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nordre;
    private String rais_soc;
    private String tel;
    private String ice;
    private String tp;
    private String cif;
    private java.sql.Date debut_act;

    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "comptable_id" , nullable = false)
    private Comptable comptable;

    private String reg_com;
    private String aff_cnss;
    private String email;
    private String ville;
    private String adrs;

    public ClientPersoneMoral( String rais_soc, String tel, String ice, String tp, String cif, Date debut_act, Comptable comptable, String reg_com, String aff_cnss, String email, String ville, String adrs) {

        this.rais_soc = rais_soc;
        this.tel = tel;
        this.ice = ice;
        this.tp = tp;
        this.cif = cif;
        this.debut_act = debut_act;
        this.comptable = comptable;
        this.reg_com = reg_com;
        this.aff_cnss = aff_cnss;
        this.email = email;
        this.ville = ville;
        this.adrs = adrs;
    }



    public Integer getNordre() {
        return nordre;
    }

    public void setNordre(Integer nordre) {
        this.nordre = nordre;
    }

    public String getRais_soc() {
        return rais_soc;
    }

    public void setRais_soc(String rais_soc) {
        this.rais_soc = rais_soc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Date getDebut_act() {
        return debut_act;
    }

    public void setDebut_act(Date debut_act) {
        this.debut_act = debut_act;
    }

    public Comptable getComptable() {
        return comptable;
    }

    public void setComptable(Comptable comptable) {
        this.comptable = comptable;
    }

    public String getReg_com() {
        return reg_com;
    }

    public void setReg_com(String reg_com) {
        this.reg_com = reg_com;
    }

    public String getAff_cnss() {
        return aff_cnss;
    }

    public void setAff_cnss(String aff_cnss) {
        this.aff_cnss = aff_cnss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdrs() {
        return adrs;
    }

    public void setAdrs(String adrs) {
        this.adrs = adrs;
    }
}
