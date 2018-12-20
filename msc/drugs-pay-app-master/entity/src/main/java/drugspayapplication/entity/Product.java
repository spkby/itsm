package drugspayapplication.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "db_product_info")
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "Dpr_Id")))
public class Product extends AbstractEntity {

    @Column(name = "Dpr_Name")
    private String name;

    @Column(name = "Dpr_Dsi_State")
    private Long state;

    public Product(String name, Long state) {
        this.name = name;
        this.state = state;
    }

    public Product(Long id, String name, Long state) {
        super(id);
        this.name = name;
        this.state = state;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(state, product.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
