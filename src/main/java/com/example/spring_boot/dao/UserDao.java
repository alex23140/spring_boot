package com.example.spring_boot.dao;

import com.example.spring_boot.model.Role;
import com.example.spring_boot.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUser(int id);

    void updateUserById(User user, int id);

    void saveUser(User user);

    void deleteUser(int id);

    UserDetails getUserByName(String s);

    Role getRoleByName(String name);

    void addRole(Role role);

}
