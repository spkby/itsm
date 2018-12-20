package com.training.service.impl;

import com.training.dto.EntityCrudDao;
import com.training.dto.EntityListIdDao;
import com.training.IEntity;
import com.training.service.EntityCrudService;
import com.training.service.EntityListIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractServiceIml<T extends IEntity> implements EntityCrudService<T>, EntityListIdService<T> {

    private EntityCrudDao<T> crudDao;
    private EntityListIdDao<T> listIdDao;

    public AbstractServiceIml(EntityCrudDao<T> crudDao, EntityListIdDao<T> listIdDao) {
        this.crudDao = crudDao;
        this.listIdDao = listIdDao;
    }

    public AbstractServiceIml() {
    }

    @Override
    @Transactional
    public void create(T t) {
        crudDao.create(t);
    }

    @Override
    @Transactional
    public void update(T t) {
        crudDao.update(t);
    }

    @Override
    @Transactional
    public void delete(T t) {
        crudDao.delete(t);
    }

    @Override
    public List<T> getAll() {
        return listIdDao.getAll();
    }

    @Override
    public T findById(Integer id) {
        return listIdDao.findById(id);
    }
}
