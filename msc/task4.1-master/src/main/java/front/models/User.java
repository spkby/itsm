package front.models;

import javax.persistence.*;


@Entity(name = "user")
@Table(name = "user")
public class User implements IEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String password;

    public User(String userEmail, String password, String userLogin) {
        this.userEmail = userEmail;
        this.password = password;
        this.userLogin = userLogin;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
