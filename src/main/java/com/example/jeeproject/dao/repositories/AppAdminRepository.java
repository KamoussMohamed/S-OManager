package com.example.jeeproject.dao.repositories;

import com.example.jeeproject.dao.entities.AppAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppAdminRepository extends JpaRepository<AppAdmin, Integer> {
    public AppAdmin findByUsername(String username);
    public AppAdmin findAppAdminById(Integer id);
}
