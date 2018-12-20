package by.itsm.patients.logic.repository.domain.impl;

import by.itsm.patients.common.entity.User;
import by.itsm.patients.logic.Utils;
import by.itsm.patients.logic.exception.DatabaseException;
import by.itsm.patients.logic.repository.AbstractCrudRepository;
import by.itsm.patients.logic.repository.domain.IUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Repository
public class UserRepository extends AbstractCrudRepository<User>
        implements IUserRepository {

    public UserRepository() {
        typeClass = User.class;
    }

    @Override
    @Transactional
    public User loggedUser(String name, String hash) {
        try {

            TypedQuery<User> query = em.createQuery("select u from user u where u.name = :name and u.hash = :hash", User.class);
            query.setParameter("name", name);
            query.setParameter("hash", hash);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (DatabaseException e) {
            throw e;
        }
    }
}
