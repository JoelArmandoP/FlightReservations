package com.joel.flightreservations.domain.model.user;

import java.util.List;

/**
 * Interface to Users
 */
public interface UserRepository {
    User find(String username);

    List<User> findAll();
}
