package com.csc340.spartan_manager.administration_portal.Repository;

import com.csc340.spartan_manager.administration_portal.Entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser,Integer> {
    // This method will retrieve users by adminId
    List<AdminUser> getAdminUsersById(Long adminId);

    @Query(value = "select * from admin_users a where a.adminId>= ?1", nativeQuery = true)
    List<AdminUser> findById(Long adminId);

    List<AdminUser> getAdminUsersByAdminUsername(String adminUsername);
}
