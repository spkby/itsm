package by.itsm.patients.logic.service;

import by.itsm.patients.common.entity.IEntity;

import java.util.List;

public interface IListService<T extends IEntity> {

    T findBy(Integer id);

    List<T> findAll();

}
