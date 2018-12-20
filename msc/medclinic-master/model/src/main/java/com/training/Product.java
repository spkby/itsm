package com.training;

import javax.persistence.*;

@Entity(name = "products")
@Table(name = "products")
public class Product implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private State state_id;

    public Product(Integer id, String name, State state_id) {
        this.id = id;
        this.name = name;
        this.state_id = state_id;
    }

    public Product() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state_id;
    }

    public void setState(State state_id) {
        this.state_id = state_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state_id +
                '}';
    }
}
