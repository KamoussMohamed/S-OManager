package com.example.jeeproject.services;

import com.example.jeeproject.dao.entities.AppUser;

import java.util.List;

public interface AppUserManager {
    public AppUser findAppUserByUsername(String username);
    public AppUser addAppUser(AppUser appUser);
    public void deleteAppUserById(Integer id);
    public AppUser updateAppUser(AppUser appUser);
    public List<AppUser> getAllAppUsers();
    public AppUser findAppUserById(Integer id);
}
