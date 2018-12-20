package front.DAO;

import front.models.IEntity;

public interface ICRUDOperations<E extends IEntity> extends IListRepository<E> {
    void create(E e);
    void update(E e);
    void remove(Integer id);
    E find(Integer id);
}
