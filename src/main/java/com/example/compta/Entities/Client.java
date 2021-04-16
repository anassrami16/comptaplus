package com.example.compta.Entities;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer client_id;

    private String fname;
    private String lname;



    private String compname;
    private String cin;
    private String tel;
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "comptable_id" , nullable = false)
    private Comptable comptable;

    public Integer getClient_id() {
        return client_id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
    public Comptable getComptable() {
        return comptable;
    }

    public void setComptable(Comptable comptable) {
        this.comptable = comptable;
    }
}
