package com.example.compta.Entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client_generale")
public class ClientGenerale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nordre")
    private Integer nordre;

    private String email;
    private String tel;
    private String ville;
    private String adrs;

    @OneToMany
    List<Activiter> activiters;

    @PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "clientGenerale" , cascade = CascadeType.ALL)
    private ClientPersoneMoral clientPersoneMorales;


    @PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "clientGenerale" , cascade = CascadeType.ALL)
    private ClientPhysique clientPhysiques;


    @PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "clientGenerale" , cascade = CascadeType.ALL)
    private ClientRevenueFoncier clientRevenueFonciers;

    @PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "clientGenerale" , cascade = CascadeType.ALL)
    private CompteDam compteDam;

    @PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "clientGenerale" , cascade = CascadeType.ALL)
    private CompteDci compteDci;

    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "comptable_id" , nullable = false)
    private Comptable comptable;

    public ClientGenerale() {

    }

    public ClientGenerale(String email, String tel, String ville, String adrs, Comptable comptable) {

        this.email = email;
        this.tel = tel;
        this.ville = ville;
        this.adrs = adrs;

        this.comptable = comptable;
    }


    public Integer getNordre() {
        return nordre;
    }

    public void setNordre(Integer nordre) {
        this.nordre = nordre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public ClientPersoneMoral getClientPersoneMorales() {
        return clientPersoneMorales;
    }

    public void setClientPersoneMorales(ClientPersoneMoral clientPersoneMorales) {
        this.clientPersoneMorales = clientPersoneMorales;
    }

    public ClientPhysique getClientPhysiques() {
        return clientPhysiques;
    }

    public void setClientPhysiques(ClientPhysique clientPhysiques) {
        this.clientPhysiques = clientPhysiques;
    }

    public ClientRevenueFoncier getClientRevenueFonciers() {
        return clientRevenueFonciers;
    }

    public void setClientRevenueFonciers(ClientRevenueFoncier clientRevenueFonciers) {
        this.clientRevenueFonciers = clientRevenueFonciers;
    }

    public CompteDam getCompteDam() {
        return compteDam;
    }

    public void setCompteDam(CompteDam compteDam) {
        this.compteDam = compteDam;
    }

    public CompteDci getCompteDci() {
        return compteDci;
    }

    public void setCompteDci(CompteDci compteDci) {
        this.compteDci = compteDci;
    }

    public Comptable getComptable() {
        return comptable;
    }

    public void setComptable(Comptable comptable) {
        this.comptable = comptable;
    }
}
