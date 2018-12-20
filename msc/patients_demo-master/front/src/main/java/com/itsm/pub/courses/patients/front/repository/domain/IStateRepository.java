package com.itsm.pub.courses.patients.front.repository.domain;

import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.front.repository.IListRepository;

public interface IStateRepository extends IListRepository<State> {

    State findByCode(String code);
}
