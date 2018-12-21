package by.itsm.patients.web.repository;

import by.itsm.patients.common.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
