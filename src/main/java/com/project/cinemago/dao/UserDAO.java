package com.project.cinemago.dao;

import com.project.cinemago.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDAO extends CrudRepository<User, Integer> {

    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    public User findUser(String username, String password);

}
