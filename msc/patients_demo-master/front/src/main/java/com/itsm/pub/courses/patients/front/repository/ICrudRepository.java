package com.itsm.pub.courses.patients.front.repository;

import com.itsm.pub.courses.patients.common.entities.IEntity;

public interface ICrudRepository<E extends IEntity> extends IListRepository<E> {
    void create(E e);
    void update(E e);
    void delete(E e);
}
