package com.example.jeeproject.config;


import com.example.jeeproject.services.AppAdminUserDetailsService;
import com.example.jeeproject.services.AppUserUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AppUserUserDetailsService appUserDetailsService;
    @Autowired
    private AppAdminUserDetailsService appAdminUserDetailsService;

    @Bean
    SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(requests -> requests
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/app_admins", "/app_users","/add_appAdmin","/add_appUserPost", "/add_appAdminPost", "/add_appUserPost","/delete_appAdmin","/delete_appUser","/update_appUser","/save_updated_appUser","/app").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/index",true)
                        .loginProcessingUrl("/login")
                        .permitAll()
                );
        return http.build();

    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailsService);
        auth.userDetailsService(appAdminUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}

