package front.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "product")
@Table(name = "product")
public class Product implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_st_id")
    private State state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_createdByUser_id")
    private User CreatedByUser;

    @Column(name = "product_createdDate")
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_updatedByUser_id")
    private User ModifiedByUser;

    @Column(name = "product_updatedDate")
    private LocalDateTime updatedDate;

    public Product() {
    }

    public Product(String name, State state, User createdByUser, LocalDateTime createdDate, User modifiedByUser, LocalDateTime updatedDate) {
        this.name = name;
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
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}