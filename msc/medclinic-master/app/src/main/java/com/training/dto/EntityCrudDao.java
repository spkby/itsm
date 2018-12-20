package com.training.dto;

import com.training.IEntity;

public interface EntityCrudDao<T extends IEntity> extends EntityListIdDao<T> {
    void create(T t);

    void update(T t);

    void delete(T t);
}
