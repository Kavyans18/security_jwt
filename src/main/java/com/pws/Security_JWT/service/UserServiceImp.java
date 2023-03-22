package com.pws.Security_JWT.service;

import com.pws.Security_JWT.entity.User;
import com.pws.Security_JWT.exception.IdNotFoundException;
import com.pws.Security_JWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Repository
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository repository;
    @Override
    public User saveUser(User user) {

        return repository.save(user);
    }
    @Override
    public User updateUser(User user, int id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        User us = optional.get();
        us.setId(user.getId());
        us.setUserName(user.getUserName());
        us.setPassword(user.getPassword());
        us.setEmail(user.getEmail());
        return repository.save(us);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()) {
            throw new IdNotFoundException("Invalid User ID");
        }
        return optional.get();
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteUser(int id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()) {
            throw new IdNotFoundException("Invalid User ID");
        }
        User us = optional.get();
        repository.delete(us);
    }
}
