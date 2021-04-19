package com.example.compta.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "client_persone_moral")
public class ClientPersoneMoral {

    @Id
    @Column(name = "nordre")
    private Integer nordre;

    private String rais_soc;
    private String ice;
    private String tp;
    private String _if;
    private Date debut_act;
    private String reg_com;
    private String aff_cnss;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "nordre")
    private ClientGenerale clientGenerale;

    public ClientPersoneMoral(String rais_soc, String ice, String tp, String _if, Date debut_act, String reg_com, String aff_cnss , ClientGenerale clientGenerale) {

        this.rais_soc = rais_soc;
        this.ice = ice;
        this.tp = tp;
        this._if = _if;
        this.debut_act = debut_act;
        this.reg_com = reg_com;
        this.aff_cnss = aff_cnss;
        this.clientGenerale = clientGenerale;

    }

    public ClientPersoneMoral() {

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

    public String get_if() {
        return _if;
    }

    public void set_if(String _if) {
        this._if = _if;
    }

    public Date getDebut_act() {
        return debut_act;
    }

    public void setDebut_act(Date debut_act) {
        this.debut_act = debut_act;
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

    public ClientGenerale getClientGenerale() {
        return clientGenerale;
    }

    public void setClientGenerale(ClientGenerale clientGenerale) {
        this.clientGenerale = clientGenerale;
    }
}
