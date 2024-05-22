package com.example.jeeproject.services;

import com.example.jeeproject.dao.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class AppUserUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserManager appUserManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserManager.findAppUserByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("AppUser not found with username: "+username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .roles("USER")
                .build();
    }
}
