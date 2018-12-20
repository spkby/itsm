package drugspayapplication.entity;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "db_audit_operation")
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "Dao_Id")))
public class Audit extends AbstractEntity {

    @Column(name = "Dao_Date")
    private LocalDate date;

    @Column(name = "Dao_Status")
    private boolean status;

    @Column(name = "Dao_Action")
    private String action;

    public Audit(LocalDate date, boolean status, String action) {
        this.date = date;
        this.status = status;
        this.action = action;
    }

    public Audit(Long id, LocalDate date, boolean status, String action) {
        super(id);
        this.date = date;
        this.status = status;
        this.action = action;
    }

    public Audit() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audit audit = (Audit) o;
        return status == audit.status &&
                Objects.equals(date, audit.date) &&
                Objects.equals(action, audit.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, status, action);
    }

    @Override
    public String toString() {
        return "Audit{" +
                "date=" + date +
                ", status=" + status +
                ", action='" + action + '\'' +
                '}';
    }
}