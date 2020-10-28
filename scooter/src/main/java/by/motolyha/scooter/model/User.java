package by.motolyha.scooter.model;


import lombok.Data;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable {

    @Id
    @NotNull
    @Column(name = "Id")
    private int userId;

    @NotNull
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Sername")
    private String serName;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "Login", unique = true)
    private String login;

    @NotNull
    @Column(name = "Password")
    private String password;

    @NotNull
    @Column(name = "Mail")
    private String mail;

    @OneToMany(mappedBy = "user")
    Set<Orders> orders;

    @ManyToOne
    @JoinColumn(name = "User_type")
    UserType userType;

    public User(String name, String serName, String login, String pass, String mail) {
        this.name = name;
        this.serName = serName;
        this.login = login;
        this.password = pass;
        this.mail = mail;
    }

    public User() {
    }

    @Override
    public String toString() {
        return String.format("User: " +
                "\n\tId: %d" +
                "\n\tuser_type: %d" +
                "\n\tName: %s" +
                "\n\tLogin: %s" +
                "\n\tSerName: %s" +
                "\n\tPassword: %s" +
                "\n\tMail: %s", userId, userType.getUserTypeId(), name, serName, login, password, mail);
    }
}
