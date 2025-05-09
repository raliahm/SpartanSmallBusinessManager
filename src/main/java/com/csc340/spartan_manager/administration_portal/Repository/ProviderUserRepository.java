package com.csc340.spartan_manager.administration_portal.Repository;

import com.csc340.spartan_manager.administration_portal.Entity.ProviderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.ArrayList;

public interface ProviderUserRepository extends JpaRepository<ProviderUser, Integer> {



    List<ProviderUser> getProviderUsersByProviderUsername(String username);

}
