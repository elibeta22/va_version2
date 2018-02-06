package com.va.content.models;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by eli on 2/3/2018.
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    @Column(name = "enabled")
    private int enabled;


    public User(){
    }

    public User(User user) {

        this.id = user.id;
        this.name = user.name;
        this.email = user.email;
        this.username = user.username;
        this.password = user.password;
        this.enabled = user.enabled;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public int getEnabled() {return enabled;}

    public void setEnabled(int enabled) {this.enabled = enabled;}

}