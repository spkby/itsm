package by.itsm.patients.logic.service.domain;

import by.itsm.patients.common.entity.State;
import by.itsm.patients.logic.service.IListService;

public interface IStateService extends IListService<State> {

    State findByCode(String code);

}
