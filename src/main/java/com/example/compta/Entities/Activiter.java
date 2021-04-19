package com.example.compta.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "activiter")
public class Activiter {

    @Id
    @Column(name = "activiter_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activiter_id;


    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "nordre" , nullable = false)
    private ClientGenerale clientGenerale;

    private Date date;
    private Boolean etats;

}
