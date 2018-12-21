package by.itsm.patients.logic.repository;

import by.itsm.patients.common.entity.IEntity;

public interface ICrudRepository<T extends IEntity> extends IListRepository<T> {

    void create(T t);
    void update(T t);
    void delete(T t);

}
