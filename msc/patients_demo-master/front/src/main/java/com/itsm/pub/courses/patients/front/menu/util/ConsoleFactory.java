package com.itsm.pub.courses.patients.front.menu.util;

import com.itsm.pub.courses.patients.common.entities.IEntity;

public interface ConsoleFactory<E extends IEntity> {
    E create();

    void update(E entity);
}
