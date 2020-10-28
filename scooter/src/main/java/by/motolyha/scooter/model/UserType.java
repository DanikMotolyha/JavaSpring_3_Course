package by.motolyha.scooter.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "User_type")
public class UserType implements Serializable {

    @Id
    @NotNull
    @Column(name = "Id")
    private int userTypeId;

    @NotNull
    @Column(name = "user_type")
    private String userType;

    public UserType(@NotNull int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public UserType() {
    }
}
