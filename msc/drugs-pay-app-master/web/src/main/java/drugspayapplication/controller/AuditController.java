package drugspayapplication.controller;

import drugspayapplication.entity.Audit;
import drugspayapplication.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/audit")
public class AuditController {
    private AuditRepository auditRepository;

    @Autowired
    public AuditController(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @GetMapping("/")
    @ResponseBody
    Iterable<Audit> getAll() {
        return auditRepository.findAll();
    }

}
