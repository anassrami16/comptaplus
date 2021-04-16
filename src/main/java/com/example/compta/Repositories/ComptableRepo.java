package com.example.compta.Repositories;

import com.example.compta.Entities.Comptable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ComptableRepo extends CrudRepository<Comptable,Integer> {
    @Query("select c from Comptable c where c.email =:email")
    Comptable getByemail(String email);

    @Query("select c from Comptable c where c.passwd =:passwd")
    Comptable getBypasswd(String passwd);

    @Query("select c from Comptable c where c.comptable_id =:id")
    Comptable getByComptable_id(Integer id);

}
