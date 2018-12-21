package by.itsm.patients.logic.repository;

import by.itsm.patients.common.entity.IEntity;

import java.util.List;

public interface IListRepository<T extends IEntity> {

    T find(Integer id);

    List<T> findAll();

}
