package com.training;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "patients")
@Table(name = "patients")
public class Patient implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "phone", nullable = false)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private State state_id;

    public Patient() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public State getState_id() {
        return state_id;
    }

    public void setState_id(State state_id) {
        this.state_id = state_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) &&
                Objects.equals(phone, patient.phone) &&
                Objects.equals(state_id, patient.state_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, state_id);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", state_id=" + state_id +
                '}';
    }
}
