package by.itsm.patients.logic.service.domain.impl;

import by.itsm.patients.common.entity.State;
import by.itsm.patients.logic.exception.DatabaseException;
import by.itsm.patients.logic.repository.domain.IStateRepository;
import by.itsm.patients.logic.service.AbstractListService;
import by.itsm.patients.logic.service.domain.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StateService extends AbstractListService<State> implements IStateService {

    @Autowired
    private IStateRepository stateRepository;

    @Override
    @Transactional
    public State findByCode(String code) {
        try {
            return stateRepository.findByCode(code);
        } catch (DatabaseException e) {
            throw e;
        }
    }
}
