package drugspayapplication.repository;

import drugspayapplication.entity.Audit;
import org.springframework.data.repository.CrudRepository;

public interface AuditRepository extends CrudRepository<Audit, Long> {
}
