package front.models;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity(name = "patient")
@Table(name = "patient")
public class Patient  implements Serializable, IEntity{

    @Id
    @Column(name = "pat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pat_phone")
    private int phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pat_st_id")
    private State state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pat_createdByUser_id")
    private User CreatedByUser;

    @Column(name = "pat_createdDate")
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pat_updatedByUser_id")
    private User ModifiedByUser;

    @Column(name = "pat_updatedDate")
    private LocalDateTime updatedDate;


    public Patient() {
    }

    public Patient(int phone, State state, User createdByUser, LocalDateTime createdDate, User modifiedByUser, LocalDateTime updatedDate) {
        this.phone = phone;
        this.state = state;
        CreatedByUser = createdByUser;
        this.createdDate = createdDate;
        ModifiedByUser = modifiedByUser;
        this.updatedDate = updatedDate;
    }

    public User getCreatedByUser() {
        return CreatedByUser;
    }

    public void setCreatedByUser(User createdByUser) {
        CreatedByUser = createdByUser;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getModifiedByUser() {
        return ModifiedByUser;
    }

    public void setModifiedByUser(User modifiedByUser) {
        ModifiedByUser = modifiedByUser;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", phone=" + phone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                phone == patient.phone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone);
    }
}
