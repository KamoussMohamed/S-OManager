package com.example.jeeproject.dao.repositories;

import com.example.jeeproject.dao.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    public AppUser findByEmail(String email);
    public AppUser findByUsername(String username);
    public AppUser findAppUserById(Integer id);
}
