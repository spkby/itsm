package front.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "state")
@Table(name = "state")
public class State implements IEntity {

    @Id
    @Column(name = "st_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "st_code")
    private Integer code;

    @Column(name = "st_name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "st_createdByUser_id")
    private User CreatedByUser;

    @Column(name = "st_createdDate")
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "st_updatedByUser_id")
    private User ModifiedByUser;

    @Column(name = "st_updatedDate")
    private LocalDateTime updatedDate;


    public State() {
    }

    public State(Integer code, String name, User createdByUser, LocalDateTime createdDate, User modifiedByUser, LocalDateTime updatedDate) {
        this.code = code;
        this.name = name;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(id, state.id) &&
                Objects.equals(code, state.code) &&
                Objects.equals(name, state.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name);
    }
}
