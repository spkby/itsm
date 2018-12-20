package com.training.web.service.converter;

import com.training.IEntity;
import com.training.web.model.IDto;

public interface Converter<E extends IEntity,D extends IDto> {
    D convert(E entity);
    E convert(D dto);
}
