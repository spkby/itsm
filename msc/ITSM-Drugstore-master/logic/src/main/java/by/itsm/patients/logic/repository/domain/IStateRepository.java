package by.itsm.patients.logic.repository.domain;

import by.itsm.patients.common.entity.State;
import by.itsm.patients.logic.repository.IListRepository;

public interface IStateRepository extends IListRepository<State> {

    State findByCode(String code);
}
