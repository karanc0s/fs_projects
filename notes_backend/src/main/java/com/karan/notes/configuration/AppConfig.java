package com.karan.notes.configuration;

import com.karan.notes.entity.PrincipalUser;
import com.karan.notes.exception.UserNotFoundException;
import com.karan.notes.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
@AllArgsConstructor
public class AppConfig {

    private final UserRepository userRepo;

    @Bean
    public UserDetailsService userDetailsService() {
        return usrName -> {
            Optional<PrincipalUser> user = userRepo.findByUsername(usrName);
            if(user.isEmpty()){
                throw new UserNotFoundException("User not found with userName: " + usrName);
            }
            return user.get();
        };
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider(
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService
    ) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager getAuthenticationManager(
           AuthenticationConfiguration configuration
    ) throws Exception{
        return configuration.getAuthenticationManager();
    }
}