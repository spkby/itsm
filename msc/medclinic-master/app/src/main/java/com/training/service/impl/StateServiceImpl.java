package com.training.service.impl;

import com.training.dto.StateFindByCodeDao;
import com.training.State;
import com.training.service.StateFindByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StateServiceImpl extends AbstractServiceIml<State> implements StateFindByNameService {

    @Autowired
    private StateFindByCodeDao findByCode;

    @Override
    public State findByName(String name) {
        return findByCode.findByCode(name);
    }
}
