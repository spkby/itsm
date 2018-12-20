package front.DAO.impl;

import front.DAO.ICRUDOperations;
import front.models.State;

public interface IStateDAO extends ICRUDOperations<State> {

    State findStateByName(String sateName);
}
