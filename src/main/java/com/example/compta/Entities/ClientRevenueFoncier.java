package com.example.compta.Entities;

import javax.persistence.*;

@Entity
@Table(name = "client_revenue_foncier")
public class ClientRevenueFoncier {

    @Id
    @Column(name = "nordre")
    private Integer nordre;

    private String _if;
    private String tsc;
    private String nom_locataire;
    private String prenom_locataire;
    private String ville_loyer;
    private String adrs_loyer;
    private Integer mnt_men;
    private Integer mnt_ann;
    private String adrs_loc;
    private String ville_loc;
    private String nom_locateur;
    private String prenom_locateur;

    @OneToOne
    @MapsId
    @JoinColumn(name = "nordre")
    private ClientGenerale clientGenerale;

    public ClientRevenueFoncier(String _if, String tsc, String nom_locataire, String prenom_locataire, String ville_loyer, String adrs_loyer, Integer mnt_men, Integer mnt_ann, String adrs_loc, String ville_loc, ClientGenerale clientGenerale,String nom_locateur,String prenom_locateur) {
        this._if = _if;
        this.tsc = tsc;
        this.nom_locataire = nom_locataire;
        this.prenom_locataire = prenom_locataire;
        this.ville_loyer = ville_loyer;
        this.adrs_loyer = adrs_loyer;
        this.mnt_men = mnt_men;
        this.mnt_ann = mnt_ann;
        this.adrs_loc = adrs_loc;
        this.ville_loc = ville_loc;
        this.clientGenerale = clientGenerale;
        this.nom_locateur=nom_locateur;
        this.prenom_locateur=prenom_locateur;
    }

    public ClientRevenueFoncier(){

    }
    public Integer getNordre() {
        return nordre;
    }

    public void setNordre(Integer nordre) {
        this.nordre = nordre;
    }

    public String get_if() {
        return _if;
    }

    public void set_if(String _if) {
        this._if = _if;
    }

    public String getTsc() {
        return tsc;
    }

    public void setTsc(String tsc) {
        this.tsc = tsc;
    }

    public String getNom_locataire() {
        return nom_locataire;
    }

    public void setNom_locataire(String nom_locataire) {
        this.nom_locataire = nom_locataire;
    }

    public String getPrenom_locataire() {
        return prenom_locataire;
    }

    public void setPrenom_locataire(String prenom_locataire) {
        this.prenom_locataire = prenom_locataire;
    }

    public String getVille_loyer() {
        return ville_loyer;
    }

    public void setVille_loyer(String ville_loyer) {
        this.ville_loyer = ville_loyer;
    }

    public String getAdrs_loyer() {
        return adrs_loyer;
    }

    public void setAdrs_loyer(String adrs_loyer) {
        this.adrs_loyer = adrs_loyer;
    }

    public Integer getMnt_men() {
        return mnt_men;
    }

    public void setMnt_men(Integer mnt_men) {
        this.mnt_men = mnt_men;
    }

    public Integer getMnt_ann() {
        return mnt_ann;
    }

    public void setMnt_ann(Integer mnt_ann) {
        this.mnt_ann = mnt_ann;
    }

    public String getAdrs_loc() {
        return adrs_loc;
    }

    public void setAdrs_loc(String adrs_loc) {
        this.adrs_loc = adrs_loc;
    }

    public String getVille_loc() {
        return ville_loc;
    }

    public void setVille_loc(String ville_loc) {
        this.ville_loc = ville_loc;
    }

    public ClientGenerale getClientGenerale() {
        return clientGenerale;
    }

    public void setClientGenerale(ClientGenerale clientGenerale) {
        this.clientGenerale = clientGenerale;
    }
}
