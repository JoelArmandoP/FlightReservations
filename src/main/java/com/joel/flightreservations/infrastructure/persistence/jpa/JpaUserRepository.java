package com.joel.flightreservations.infrastructure.persistence.jpa;

import com.joel.flightreservations.domain.model.user.User;
import com.joel.flightreservations.domain.model.user.UserRepository;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class JpaUserRepository implements UserRepository, Serializable {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(
            JpaUserRepository.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User find(String username) {
        User user;

        try {
            user = entityManager.createNamedQuery("User.findByUsername",
                    User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            logger.log(Level.FINE, "Find called on non-existant username.", e);
            user = null;
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return entityManager.createNamedQuery("User.findAll", User.class)
                .getResultList();
    }

    @Override
    public void store(User user) {
        entityManager.persist(user);
    }
}
