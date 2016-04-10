package com.joel.flightreservations.application;

import com.joel.flightreservations.domain.model.user.CreditCard;
import com.joel.flightreservations.domain.model.user.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    List<User> findAll();
    void createUser(User user);
    void createUser();
    void deleteUser();

    void fakeCreateUser();
}
