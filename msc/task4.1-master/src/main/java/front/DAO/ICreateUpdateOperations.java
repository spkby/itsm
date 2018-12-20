package front.DAO;

import front.models.IEntity;

public interface ICreateUpdateOperations<E extends IEntity> extends IListRepository<E> {
    void create(E e);
    E find(Integer id);
}
