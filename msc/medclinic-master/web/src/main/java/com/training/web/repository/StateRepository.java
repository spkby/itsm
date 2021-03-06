package com.training.web.repository;

import com.training.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "/state")
public interface StateRepository extends JpaRepository<State,Integer> {
}
