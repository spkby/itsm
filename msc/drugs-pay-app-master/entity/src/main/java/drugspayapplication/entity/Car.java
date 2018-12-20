package drugspayapplication.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car")
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "car_id")))
public class Car extends AbstractEntity{
    @Column(name = "car_name")
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
