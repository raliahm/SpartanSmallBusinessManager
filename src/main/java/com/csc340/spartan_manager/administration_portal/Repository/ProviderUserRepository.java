package com.csc340.spartan_manager.administration_portal.Repository;

import com.csc340.spartan_manager.administration_portal.Entity.ProviderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProviderUserRepository extends JpaRepository<ProviderUser, Integer> {


    @Query(value = "select * from provider_usesrs p where p.providerId>= ?1", nativeQuery = true)
    List<ProviderUser> findByProviderId(int providerId);

    List<ProviderUser> getProviderUsersByProviderUsername(String username);

}
