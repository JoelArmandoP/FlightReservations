package com.joel.flightreservations.application.ejb;

import com.joel.flightreservations.application.UserService;
import com.joel.flightreservations.domain.model.user.CreditCard;
import com.joel.flightreservations.domain.model.user.User;
import com.joel.flightreservations.domain.model.user.UserRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@Stateless
public class UserServiceBean implements UserService, Serializable{
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(
            UserServiceBean.class.getName());
    private User user = new User();

    @Override
    public void createUser(User user) {
        em.persist(user);
    }

    @Override
    public void createUser() {
        em.persist(user);
    }

    @Override
    public User findByUsername(String username) {
        User user;

        try {
            user = em.createNamedQuery("User.findByUsername",
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
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    @Override
    public void deleteUser() {
    }

    @Override
    public void fakeCreateUser() {

    }
}
