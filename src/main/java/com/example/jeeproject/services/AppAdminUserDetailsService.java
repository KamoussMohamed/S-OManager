package com.example.jeeproject.services;

import com.example.jeeproject.dao.entities.AppAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service

public class AppAdminUserDetailsService implements UserDetailsService {

    @Autowired
    private AppAdminManager appAdminManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppAdmin appAdmin = appAdminManager.findAppAdminByUsername(username);
        if (appAdmin == null) {
            throw new UsernameNotFoundException("AppAdmin with "+username+" as username is not found");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(appAdmin.getUsername())
                .password(appAdmin.getPassword())
                .roles("ADMIN")
                .build();
    }
}
