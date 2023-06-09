package com.example.springsecurity.repository;

import com.example.springsecurity.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    @Query("Select u from Users u where u.username=?1")
    public Users findByUsername(String username);

}
