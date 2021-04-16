package com.example.compta.SecurityConfig;

import com.example.compta.Entities.Comptable;
import com.example.compta.Repositories.ComptableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private ComptableRepo comptableRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Comptable comptable = comptableRepo.getByemail(s);

        if(comptable == null){
            throw new UsernameNotFoundException("user not found");
        }

        return new MyUserDetails(comptable);
    }
}
