package com.itsm.pub.courses.patients.web.repository;

import com.itsm.pub.courses.patients.common.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "/state")
public interface StateRepository extends JpaRepository<State, Integer> {

}
