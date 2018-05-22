package com.gkenna.tullamoreqa.domain.service;

import com.gkenna.tullamoreqa.domain.User;
import com.gkenna.tullamoreqa.domain.repositories.UserRepository;
import com.gkenna.tullamoreqa.domain.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public void editUser(User user) {

    }

    @Override
    public boolean doesUserExist(User user) {
        return false;
    }

    @Override
    public boolean doesUserExist(long id) {
        return false;
    }

    @Override
    public User getUser(String id) {
        return null;
    }

    @Override
    public User[] getAllUsers() {
        return new User[0];
    }
}
