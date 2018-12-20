package com.itsm.pub.courses.patients.front.repository;

import com.itsm.pub.courses.patients.common.entities.IEntity;

import java.util.List;

public interface IListRepository<E extends IEntity> {
    List<E> findAll();

    E find(Integer id);
}
