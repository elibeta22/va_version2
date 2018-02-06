package com.va.content.models;
import javax.persistence.*;

/**
 * Created by eli on 2/4/2018.
 */
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_role_id")
    private Long user_role_id;

    @Column(name="user_id")
    private Long user_id;

    @Column(name = "role")
    private String role;


    public UserRole(){
    }

    public UserRole(UserRole userRole) {
        this.user_role_id = userRole.user_role_id;
        this.user_id = userRole.user_id;
        this.role = userRole.role;
    }


    public Long getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Long user_role_id) {
        this.user_role_id = user_role_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
