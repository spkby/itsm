package drugspayapplication.entity;
import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "db_state_info")
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "Dsi_Id")))
public class State extends AbstractEntity {

    @Column(name = "Dsi_Code")
    private String code;

    @Column(name = "Dsi_Name")
    private String name;

    public State(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public State() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        State state = (State) o;
        return Objects.equals(code, state.code) &&
                Objects.equals(name, state.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

    @Override
    public String toString() {
        return "State{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
