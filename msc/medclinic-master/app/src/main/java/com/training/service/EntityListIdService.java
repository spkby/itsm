package com.training.service;

import com.training.IEntity;

import java.util.List;

public interface EntityListIdService<T extends IEntity> {
    List<T> getAll();

    T findById(Integer id);
}
