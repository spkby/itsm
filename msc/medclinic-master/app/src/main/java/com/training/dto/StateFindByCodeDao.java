package com.training.dto;

import com.training.State;

public interface StateFindByCodeDao extends EntityCrudDao<State> {
    State findByCode(String name);
}
