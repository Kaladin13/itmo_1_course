package com.company.command;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user", schema = "s335095")
public class UserDTO implements Serializable {

    public long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String login;
    @Column
    private String password;

    public UserDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UserDTO() {

    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
