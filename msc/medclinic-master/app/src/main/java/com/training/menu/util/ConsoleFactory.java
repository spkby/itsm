package com.training.menu.util;

import com.training.IEntity;

public interface ConsoleFactory<T extends IEntity> {
    T create();
    void update(T t);
}


