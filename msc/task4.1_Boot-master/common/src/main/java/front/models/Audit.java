package front.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "audit")
@Table(name = "audit")
public class Audit implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id")
    private int id;

    @Column(name = "audit_status")
    private int auditStatus;

    @Column(name = "audit_action")
    private String auditAction;

    @Column(name = "audit_date")
    private LocalDateTime auditDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audit_user_id")
    private User auditUser;


    @Column(name = "audit_entity_type")
    private String auditEntityType;

    public Audit() {
    }

    public Audit(int auditStatus, String auditAction, LocalDateTime auditDate, User auditUser, String auditEntityType) {
        this.auditStatus = auditStatus;
        this.auditAction = auditAction;
        this.auditDate = auditDate;
        this.auditUser = auditUser;
        this.auditEntityType = auditEntityType;
    }

    public String getAuditEntityType() {
        return auditEntityType;
    }

    public void setAuditEntityType(String auditEntityType) {
        this.auditEntityType = auditEntityType;
    }

    public LocalDateTime getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(LocalDateTime auditDate) {
        this.auditDate = auditDate;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(int auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditAction() {
        return auditAction;
    }

    public void setAuditAction(String auditAction) {
        this.auditAction = auditAction;
    }

    public User getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(User auditUser) {
        this.auditUser = auditUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
