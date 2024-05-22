package com.example.jeeproject.services;

import com.example.jeeproject.dao.entities.AppAdmin;

import java.util.List;

public interface AppAdminManager {
    public AppAdmin findAppAdminByUsername(String username);
    public AppAdmin addAppAdmin(AppAdmin appAdmin);
    public AppAdmin updateAppAdmin(AppAdmin appAdmin);
    public void deleteAppAdminById(Integer appAdminId);
    public List<AppAdmin> getAllAppAdmins();
    public AppAdmin getAppAdminById(Integer appAdminId);
}
