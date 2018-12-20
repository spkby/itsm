package front.repository;

import front.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {

    List<User> findByUserEmail(String userEmail);
}
