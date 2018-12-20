package by.itsm.patients.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "audit")
@Table(name = "audit")
public class AuditOperation implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private LocalDateTime date;

    private boolean success;

    @Type(type = "text")
    private String action;

    public AuditOperation(boolean success, String action) {
        this.date = LocalDateTime.now();
        this.success = success;
        this.action = action;
    }
}
