package ro.sorinace.sicj.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Sorin created on 3/31/2020
 */
@Entity
@Table(name = "auth_user_group")
public class AuthGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String auth_group;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuth_group() {
        return auth_group;
    }

    public void setAuth_group(String auth_group) {
        this.auth_group = auth_group;
    }
}
