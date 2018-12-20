package front.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "transaction")
@Table(name = "transaction")
public class SellTransaction implements IEntity {

    @Id
    @Column(name = "tr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tr_pat_id")
    private Patient patient;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tr_product_id")
    private Product product;

    @Column(name = "tr_date")
    private LocalDateTime date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tr_user_id")
    private User user;


    public SellTransaction() {
    }

    public SellTransaction(Patient patient, Product product, LocalDateTime date, User user) {
        this.patient = patient;
        this.product = product;
        this.date = date;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
