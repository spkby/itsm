package drugspayapplication.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "db_user")
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "Dur_Id")))
public class User extends AbstractEntity {

    @Column(name = "Dur_Name")
    private String name;

    @Column(name = "Dur_Email")
    private String email;

    @Column(name = "Dur_Password")
    private String password;

    @Column(name = "Dur_Salt")
    private String salt;

    public User(String name, String email, String password, String salt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(salt, user.salt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, salt);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
