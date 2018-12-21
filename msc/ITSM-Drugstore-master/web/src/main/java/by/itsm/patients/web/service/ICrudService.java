package by.itsm.patients.web.service;

import by.itsm.patients.common.entity.IEntity;
import by.itsm.patients.web.model.IDto;

import java.util.List;

public interface ICrudService<E extends IEntity, D extends IDto> {
    void save(D dto);

    D find(Integer id);

    List<D> findAll();
}
