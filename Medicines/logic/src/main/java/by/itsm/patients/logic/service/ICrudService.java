package by.itsm.patients.logic.service;

import by.itsm.patients.common.entity.IEntity;

public interface ICrudService<T extends IEntity> extends IListService<T> {

    void update(T t);

    void create(T t);

    void delete(T t);

}
