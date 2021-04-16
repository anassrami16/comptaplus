package com.example.compta.Repositories;

import com.example.compta.Entities.Client;
import com.example.compta.Entities.Comptable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Client,Integer> {

    Client getByComptable(Comptable comptable);

    @Query("select c from Client c where c.cin=:cin and c.comptable=:comptable")
    Client getByCinFor(String cin , Comptable comptable);
}
