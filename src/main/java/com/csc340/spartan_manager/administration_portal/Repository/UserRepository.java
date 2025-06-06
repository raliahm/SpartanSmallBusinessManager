package com.csc340.spartan_manager.administration_portal.Repository;

import com.csc340.spartan_manager.administration_portal.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
