package by.itsm.patients.web.repository;

import by.itsm.patients.common.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "/state")
public interface StateRepository extends JpaRepository<State, Integer> {

}
