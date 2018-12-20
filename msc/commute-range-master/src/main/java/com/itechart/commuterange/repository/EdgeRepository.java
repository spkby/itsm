package com.itechart.commuterange.repository;

import com.itechart.commuterange.domain.Edge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdgeRepository extends CrudRepository<Edge, Long> {
}
