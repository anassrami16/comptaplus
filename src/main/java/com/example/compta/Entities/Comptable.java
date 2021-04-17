package com.example.compta.Entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "comptable")
public class Comptable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comptable_id")
    private Integer comptable_id;

    private String email;
    private String fname;
    private String lname;
    private String passwd;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "comptable" , cascade = CascadeType.ALL)
    private List<Client> clients;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "comptable" , cascade = CascadeType.ALL)
    private List<ClientPersoneMoral> clientPersoneMorals;



    public Integer getComptable_id() {
        return comptable_id;
    }




    public void setComptable_id(Integer comptable_id) {
        this.comptable_id = comptable_id;
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
