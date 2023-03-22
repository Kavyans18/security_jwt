package com.pws.Security_JWT.repository;

import com.pws.Security_JWT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    com.pws.Security_JWT.entity.User findByUserName(String username);

}
