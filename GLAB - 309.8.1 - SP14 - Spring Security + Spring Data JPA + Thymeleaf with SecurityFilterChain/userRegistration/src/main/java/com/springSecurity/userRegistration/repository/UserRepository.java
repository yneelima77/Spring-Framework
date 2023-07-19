package com.springSecurity.userRegistration.repository;

import com.springSecurity.userRegistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //RoleRepository class by extending the JpaRepository interface.
// This is a Spring Data interface and gives us all the CRUD operations automatically
    public User findUserByEmail(String email);

    public User findUserByUserName(String name);

}
