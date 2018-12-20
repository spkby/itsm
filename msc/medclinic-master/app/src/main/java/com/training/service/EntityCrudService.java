package com.training.service;

import com.training.IEntity;

public interface EntityCrudService<T extends IEntity> extends EntityListIdService<T> {
    void create(T t);

    void update(T t);

    void delete(T t);
}
