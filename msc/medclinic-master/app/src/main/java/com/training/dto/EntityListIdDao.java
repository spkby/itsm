package com.training.dto;

import com.training.IEntity;

import java.util.List;

public interface EntityListIdDao<T extends IEntity> {
    List<T> getAll();

    T findById(Integer id);
}
