package by.motolyha.scooter.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class User {

    @Id
    @NotBlank(message = "Name is mandatory")
    @Column(name = "Id")
    private int userId;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "Name")
    private String name;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "Sername")
    private String serName;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "Login", unique = true)
    private String login;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "Password")
    private String password;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "Mail")
    private String mail;

    @JsonIgnore
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
