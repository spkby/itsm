package drugspayapplication.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "db_transaction")
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "Dtr_Id")))
public class Transaction extends AbstractEntity {

    @ManyToOne(targetEntity = Patient.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Dtr_Dpi_Patient")
    private Patient patient;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Dtr_Dpr_Product")
    private Product product;

    @Column(name = "Dtr_Date")
    private LocalDate date;

    public Transaction(Patient patient, Product product, LocalDate date) {
        this.patient = patient;
        this.product = product;
        this.date = date;
    }

    public Transaction(Long id, Patient patient, Product product, LocalDate date) {
        super(id);
        this.patient = patient;
        this.product = product;
        this.date = date;
    }

    public Transaction() {
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(patient, that.patient) &&
                Objects.equals(product, that.product) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(patient, product, date);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "patient=" + patient +
                ", product=" + product +
                ", date=" + date +
                '}';
    }
}


