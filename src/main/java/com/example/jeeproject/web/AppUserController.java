package com.example.jeeproject.web;


import com.example.jeeproject.dao.entities.AppUser;
import com.example.jeeproject.services.AppUserManager;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class AppUserController {

    @Autowired
    private AppUserManager appUserManager;

    @GetMapping("/index")
    public String index(HttpSession session, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        session.setAttribute("username", username);
        model.addAttribute("username", username); // Add username to the model
        return "index";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/app_users")
    public String app_users(Model model) {
        List<AppUser> appUsersList = appUserManager.getAllAppUsers();
        model.addAttribute("appUsersList", appUsersList);
        return "app_users";
    }
    @GetMapping("/add_appUser")
    public String add_app_user(Model model) {
        model.addAttribute("appUser", new AppUser());
        return "add_appUser";
    }
    @PostMapping("/add_appUserPost")
    public String add_app_userPost(Model model, @RequestParam(name = "appUserName")String appUserName, @RequestParam(name = "appUserPassword") String appUserPassword, @RequestParam(name = "appUserEmail") String appUserEmail, @RequestParam(name = "inAppUserRole") String inAppUserRole) {
        AppUser appUser = new AppUser();
        appUser.setUsername(appUserName);
        appUser.setPassword(appUserPassword);
        appUser.setEmail(appUserEmail);
        appUser.setInAppRole(inAppUserRole);
        appUserManager.addAppUser(appUser);
        return "redirect:/app_users";
    }
    @GetMapping("/delete_appUser")
    public String delete_app_user(Model model, @RequestParam(name = "appUserId") Integer appUserId){
        appUserManager.deleteAppUserById(appUserId);
        return "redirect:/app_users";
    }


}
