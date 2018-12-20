package by.itsm.patients.console.menu.util;

import by.itsm.patients.common.entity.IEntity;

public interface ConsoleFactory<E extends IEntity> {

    E create();

    void update(E entity);
}
