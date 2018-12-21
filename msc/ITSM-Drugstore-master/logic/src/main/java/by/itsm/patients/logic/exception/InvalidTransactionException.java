package by.itsm.patients.logic.exception;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.common.entity.Product;

import java.time.LocalDateTime;

public class InvalidTransactionException extends RuntimeException {

    private Product product;
    private Patient patient;
    private LocalDateTime date;

    public InvalidTransactionException(Patient patient, Product product) {
        this.product = product;
        this.patient = patient;
        date = LocalDateTime.now();
    }

    public Product getProduct() {
        return product;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date + "|" + patient + "|" + product;
    }
}
