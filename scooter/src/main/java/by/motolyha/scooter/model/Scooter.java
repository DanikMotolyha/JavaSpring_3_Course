package by.motolyha.scooter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;
@Entity
@Data
@Table(name = "scooter")
public class Scooter implements Serializable {

    @Id
    @NotNull
    @Column(name = "Id")
    private int id;

    @NotNull
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Price")
    private int price;

    @JsonIgnore
    @OneToMany(mappedBy = "scooter")
    Set<Orders> orders;
}

