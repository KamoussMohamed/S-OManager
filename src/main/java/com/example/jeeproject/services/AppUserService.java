package com.example.jeeproject.services;

import com.example.jeeproject.dao.entities.AppUser;
import com.example.jeeproject.dao.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AppUserService implements AppUserManager{

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public AppUser findAppUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public AppUser addAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public void deleteAppUserById(Integer id) {
        appUserRepository.deleteById(id);
    }

    @Override
    public AppUser updateAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser findAppUserById(Integer id) {
        return appUserRepository.findAppUserById(id);
    }
}
