package front.repository;

import front.models.State;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StateRepository extends CrudRepository<State,Integer> {

    List<State> findByName(String productName);
}
