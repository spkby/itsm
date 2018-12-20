package drugspayapplication.entity;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "db_patient_info")
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "Dpi_Id")))
public class Patient extends AbstractEntity {

    @Column(name = "Dpi_Phone")
    private Long phone;

    @Column(name = "Dpi_Dsi_State")
    private Long state;

    public Patient(Long phone, Long state) {
        this.phone = phone;
        this.state = state;
    }

    public Patient(Long id, Long phone, Long state) {
        super(id);
        this.phone = phone;
        this.state = state;
    }

    public Patient() {
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(phone, patient.phone) &&
                Objects.equals(state, patient.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, state);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "phone=" + phone +
                ", state=" + state +
                '}';
    }
}
