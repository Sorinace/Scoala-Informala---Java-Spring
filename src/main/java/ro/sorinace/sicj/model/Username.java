package ro.sorinace.sicj.model;

import javax.persistence.*;

/**
 * @author Sorin created on 3/31/2020
 */
@Entity
@Table(name = "username")
public class Username {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String username;
    private String password;

    public Long getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


