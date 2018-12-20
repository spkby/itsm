package com.itsm.pub.courses.patients.web.service.converter;

import com.itsm.pub.courses.patients.common.entities.IEntity;
import com.itsm.pub.courses.patients.web.model.IDto;

public interface Converter<E extends IEntity, D extends IDto> {

    D convert(E entity);

    E convert(D dto);
}
