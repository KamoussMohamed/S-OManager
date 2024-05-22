package com.example.jeeproject.services;


import com.example.jeeproject.dao.entities.AppAdmin;
import com.example.jeeproject.dao.repositories.AppAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppAdminService implements AppAdminManager{

    @Autowired
    private AppAdminRepository appAdminRepository;

    @Override
    public AppAdmin findAppAdminByUsername(String username) {
        return appAdminRepository.findByUsername(username);
    }

    @Override
    public AppAdmin addAppAdmin(AppAdmin appAdmin) {
        return appAdminRepository.save(appAdmin);
    }

    @Override
    public AppAdmin updateAppAdmin(AppAdmin appAdmin) {
        return appAdminRepository.save(appAdmin);
    }

    @Override
    public void deleteAppAdminById(Integer appAdminId) {
        appAdminRepository.deleteById(appAdminId);
    }

    @Override
    public List<AppAdmin> getAllAppAdmins() {
        return appAdminRepository.findAll();
    }

    @Override
    public AppAdmin getAppAdminById(Integer appAdminId) {
        return appAdminRepository.findAppAdminById(appAdminId);
    }
}
