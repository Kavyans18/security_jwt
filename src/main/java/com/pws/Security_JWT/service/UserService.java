package com.pws.Security_JWT.service;

import java.util.List;
import com.pws.Security_JWT.entity.User;
public interface UserService {

    User saveUser(User user);
    User updateUser(User user, int id);
    User getUserById(int id);
    List<User> getAll();
    void deleteUser(int id);
}

