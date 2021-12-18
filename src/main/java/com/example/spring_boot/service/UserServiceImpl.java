package com.example.spring_boot.service;

import com.example.spring_boot.dao.UserDao;
import com.example.spring_boot.model.Role;
import com.example.spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user, int id) {
        userDao.updateUserById(user, id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public User getUserByName(String name) {
        return (User) userDao.getUserByName(name);
    }

    @Transactional
    @Override
    public Role getRoleByName(String name) {
        return userDao.getRoleByName(name);
    }

    @Transactional
    @Override
    public void addRole(Role role) {
        userDao.addRole(role);
    }
}
