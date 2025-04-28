package com.nrt.tms.repository;


import com.nrt.tms.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, String> {



    @Query("From ApplicationUser u where u.username=:username")
    Optional<ApplicationUser> findByUsername(@Param("username") String username);
}
