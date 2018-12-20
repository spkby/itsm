package front.DAO.impl;

import front.DAO.AbstractCRUDOperations;
import front.models.Patient;
import front.utils.annotation.AuditEntityType;
import front.utils.annotation.AuditOperationType;
import front.utils.annotation.Auditable;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PatientDAO extends AbstractCRUDOperations<Patient> implements IPatientDAO {

    protected Class<Patient> getEntityClass() {
        return null;
    }

    @Override
    @Auditable(AUDIT_TYPE = AuditOperationType.CREATE, ENTITY_TYPE = AuditEntityType.PATIENT)
    public void create(Patient patient) {
        em.persist(patient);
    }

    @Override
    @Auditable(AUDIT_TYPE = AuditOperationType.UPDATE,ENTITY_TYPE = AuditEntityType.PATIENT)
    public void update(Patient patient) {
        em.merge(patient);
    }

    @Override
    @Auditable(AUDIT_TYPE = AuditOperationType.DELETE, ENTITY_TYPE = AuditEntityType.PATIENT)
    public void remove(Integer id) {
        Patient patient = em.find(Patient.class, id);
        em.remove(patient);
    }

    @Override
    @Auditable(AUDIT_TYPE = AuditOperationType.FIND, ENTITY_TYPE = AuditEntityType.PATIENT)
    public List<Patient> findAll() {
        return null;
    }

    @Override
    @Auditable(AUDIT_TYPE = AuditOperationType.FIND, ENTITY_TYPE = AuditEntityType.PATIENT)
    public Patient find(Integer id) {
        return em.find(Patient.class, id);
    }

    @Auditable(AUDIT_TYPE = AuditOperationType.FIND, ENTITY_TYPE = AuditEntityType.PATIENT)
    public Patient findPatientByPhoneNumber(Integer patientPhone) {
        TypedQuery<Patient> query = em.createQuery("select p from patient p where pat_phone = :patientPhone", Patient.class);
        query.setParameter("patientPhone", patientPhone);
        return query.getSingleResult();
    }

}
