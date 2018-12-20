package com.training.web.service;

import com.training.IEntity;
import com.training.web.model.IDto;

import java.util.List;

public interface ICrudService <E extends IEntity, D extends IDto> {
    void save(D dto);
    D find(Integer id);
    List<D> findAll();
}
