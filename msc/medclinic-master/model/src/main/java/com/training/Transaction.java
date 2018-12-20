package com.training;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "transaction")
@Table(name = "transaction")
public class Transaction implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product_id;

    private Date date;

    public Transaction(Integer id, Patient patient_id, Product product_id, Date date) {
        this.id = id;
        this.patient_id = patient_id;
        this.product_id = product_id;
        this.date = date;
    }

    public Transaction() {

    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Patient patient_id) {
        this.patient_id = patient_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", patient_id=" + patient_id +
                ", product_id=" + product_id +
                ", date=" + date +
                '}';
    }
}
