package front.DAO;

import front.models.IEntity;

import java.util.List;

public interface IListRepository<E extends IEntity> {
    List<E> findAll();
    E find(Integer id);
}
