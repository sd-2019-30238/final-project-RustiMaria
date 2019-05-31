package com.project.cinemago.cqrs.queries.user;

import com.project.cinemago.dao.UserDAO;
import com.project.cinemago.models.User;

import java.sql.SQLException;

public class FindUser {

    private static UserDAO user;

    public static User findUser(String username, String password) throws SQLException {

        return user.findUser(username, password);

    }

}
