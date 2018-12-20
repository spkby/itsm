package com.training;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "audit")
@Table(name = "audit")
public class AuditOperation implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private boolean status;

    @Column(name = "action")
    private String action;

    public AuditOperation() {
    }

    public AuditOperation(Integer id, Date date, boolean status, String action) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
    public String toString() {
        return "AuditOperation{" +
                "id=" + id +
                ", date=" + date +
                ", status=" + status +
                ", action='" + action + '\'' +
                '}';
    }
}
