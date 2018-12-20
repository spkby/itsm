package com.itsm.pub.courses.patients.web.service;

import com.itsm.pub.courses.patients.common.entities.IEntity;
import com.itsm.pub.courses.patients.web.model.IDto;

import java.util.List;

public interface ICrudService<E extends IEntity, D extends IDto> {
    void save(D dto);

    D find(Integer id);

    List<D> findAll();
}
