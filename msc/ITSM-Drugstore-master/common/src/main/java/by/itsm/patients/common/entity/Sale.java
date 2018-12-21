package by.itsm.patients.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "sale")
@Table(name = "sale")
public class Sale implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    private User updatedBy;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }


    public Sale(Patient patient, Product product) {
        this.patient = patient;
        this.product = product;
    }

    public Sale(LocalDateTime date, Patient patient, Product product) {
        this.date = date;
        this.patient = patient;
        this.product = product;
    }
}
