package com.training.dto.impl;

import com.training.dto.EntityUserDao;
import com.training.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements EntityUserDao {

    private final static Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void getRegister(User user) {
        try {
            em.persist(user);
            if (user != null){
                logger.info("Set login, email and password for user.");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Login or password is incorrect");
        }
    }

    @Override
    public User getActiveUser(String name, String password) {
        logger.info("Finding User...");
        TypedQuery<User> query = em.createQuery("select u from users u where u.login = :login and u.password = :password", User.class);
        query.setParameter("login", name);
        query.setParameter("password", password);

        List<User> userList = query.setMaxResults(2).getResultList();
        if (userList.size() > 1) throw new NonUniqueResultException();
        return userList.isEmpty() ? null : userList.get(0);
    }

}
