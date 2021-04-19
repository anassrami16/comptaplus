package com.example.compta.Entities;


import javax.persistence.*;

@Entity
@Table(name = "compte_dci")
public class CompteDci {

    @Id
    @Column(name = "nordre")
    private Integer nordre;

    private String login;
    private String passwd;

    @OneToOne
    @MapsId
    @JoinColumn(name = "nordre")
    private ClientGenerale clientGenerale;

    public CompteDci() {
    }

    public CompteDci(String login, String passwd, ClientGenerale clientGenerale) {
        this.login = login;
        this.passwd = passwd;
        this.clientGenerale = clientGenerale;
    }

    public Integer getNordre() {
        return nordre;
    }

    public void setNordre(Integer nordre) {
        this.nordre = nordre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public ClientGenerale getClientGenerale() {
        return clientGenerale;
    }

    public void setClientGenerale(ClientGenerale clientGenerale) {
        this.clientGenerale = clientGenerale;
    }
}
