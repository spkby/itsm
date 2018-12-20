package com.training.service;

import com.training.State;

public interface StateFindByNameService extends EntityCrudService<State> {
    State findByName(String name);
}
