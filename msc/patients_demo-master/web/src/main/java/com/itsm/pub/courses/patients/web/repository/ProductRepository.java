package com.itsm.pub.courses.patients.web.repository;

import com.itsm.pub.courses.patients.common.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
