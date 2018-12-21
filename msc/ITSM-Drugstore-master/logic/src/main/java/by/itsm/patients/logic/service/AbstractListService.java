package by.itsm.patients.logic.service;

import by.itsm.patients.common.entity.IEntity;
import by.itsm.patients.logic.repository.IListRepository;
import by.itsm.patients.logic.exception.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractListService<T extends IEntity> implements IListService<T> {

    @Autowired
    protected IListRepository<T> repositoryList;

    @Transactional
    public T findBy(Integer id) {

        try {
            return repositoryList.find(id);
        } catch (DatabaseException e) {
            throw e;
        }
    }

    @Transactional
    public List<T> findAll() {

        try {
            return repositoryList.findAll();
        } catch (DatabaseException e) {
            throw e;
        }
    }
}
