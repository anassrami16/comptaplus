package com.example.compta.Entities;

import javax.persistence.*;

@Entity
@Table(name = "client_physique")
public class ClientPhysique {
    @Id
    @Column(name = "nordre")
    private Integer nordre;

    private String nom;
    private String prenom;
    private String cpu;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "nordre")
    private ClientGenerale clientGenerale;

    public ClientPhysique(String nom, String prenom, String cpu,ClientGenerale clientGenerale) {
        this.nom=nom;
        this.prenom=prenom;
        this.cpu=cpu;
        this.clientGenerale = clientGenerale;
    }

    public Integer getNordre() {
        return nordre;
    }

    public void setNordre(Integer nordre) {
        this.nordre = nordre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public ClientGenerale getClientGenerale() {
        return clientGenerale;
    }

    public void setClientGenerale(ClientGenerale clientGenerale) {
        this.clientGenerale = clientGenerale;
    }
}
