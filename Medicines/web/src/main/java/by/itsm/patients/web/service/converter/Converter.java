package by.itsm.patients.web.service.converter;

import by.itsm.patients.common.entity.IEntity;
import by.itsm.patients.web.model.IDto;

public interface Converter<E extends IEntity, D extends IDto> {

    D convert(E entity);

    E convert(D dto);
}
