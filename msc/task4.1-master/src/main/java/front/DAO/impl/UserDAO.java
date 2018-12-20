package front.DAO.impl;

import front.DAO.AbstractCRUDOperations;
import front.models.User;
import front.utils.UserHelper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAO extends AbstractCRUDOperations<User> implements IUserDAO {
    @Override
    public void create(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void remove(Integer id) {
        User user = find(id);
        em.remove(user);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User find(Integer id) {
        return em.find(User.class,id);
    }

    @Transactional
    public boolean verifyUserByLoginAndPassword(String userLogin, String password) {
        TypedQuery<User> query = em.createQuery("select u from user u where user_login = :userLogin", User.class);
        query.setParameter("userLogin", userLogin);

        User user = query.getSingleResult();

        if (user.getPassword().equals(password)){
            System.out.println("Credentials is valid");
            UserHelper.setCurrentUser(user);
            System.out.println("You successfully logged in as the following user: "
                    + UserHelper.getCurrentUser().getUserLogin());
            return true;
        } else {
            return false;
        }
    }
}
