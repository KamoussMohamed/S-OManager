package com.example.jeeproject.web;

import com.example.jeeproject.dao.entities.AppAdmin;
import com.example.jeeproject.services.AppAdminManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class AppAdminController {
    @Autowired
    private AppAdminManager appAdminManager;

    @GetMapping("/app_admins")
    public String app_users(Model model) {
        List<AppAdmin> appAdminsList = appAdminManager.getAllAppAdmins();
        model.addAttribute("appAdminsList", appAdminsList);
        return "app_admins";
    }
    @GetMapping("/add_appAdmin")
    public String add_app_user(Model model) {
        model.addAttribute("appAdmin", new AppAdmin());
        return "add_appAdmin";
    }
    @PostMapping("/add_appAdminPost")
    public String add_app_userPost(Model model, @RequestParam(name = "appAdminName")String appAdminName, @RequestParam(name = "appAdminPassword") String appAdminPassword, @RequestParam(name = "appAdminEmail") String appAdminEmail) {
        AppAdmin appAdmin = new AppAdmin();
        appAdmin.setUsername(appAdminName);
        appAdmin.setPassword(appAdminPassword);
        appAdmin.setEmail(appAdminEmail);
        appAdminManager.addAppAdmin(appAdmin);
        return "redirect:/app_admins";
    }
    @GetMapping("/delete_appAdmin")
    public String delete_app_user(Model model, @RequestParam(name = "appAdminId") Integer appAdminId){
        appAdminManager.deleteAppAdminById(appAdminId);
        return "redirect:/app_admins";
    }
}
