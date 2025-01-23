package com.karan.notes.repository;

import com.karan.notes.entity.PrincipalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<PrincipalUser, Long> {

    Optional<PrincipalUser> findByUsername(String username);

    Optional<PrincipalUser> findByEmail(String email);
}
