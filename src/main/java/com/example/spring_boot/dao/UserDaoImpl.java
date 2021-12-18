package com.example.spring_boot.dao;

import com.example.spring_boot.model.Role;
import com.example.spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private PasswordEncoder passwordEncoder;


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUserById(User user, int id) {
        User user1 = getUser(id);
        user.setId(id);
        user1.setName(user.getName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setAge(user.getAge());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.merge(user1);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.createQuery("delete from User where id=:id").setParameter("id", id).executeUpdate();
    }

    @Override
    public User getUserByName(String name) {

        return entityManager.createQuery("from User where lower(name) like: theName", User.class)
                .setParameter("theName", "%" + name.toLowerCase() + "%")
                .getSingleResult();
    }


    @Override
    public Role getRoleByName(String name) {
        return entityManager.createQuery("from Role where name = :name", Role.class)
                .setParameter("name", name).getSingleResult();
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);

    }
}
