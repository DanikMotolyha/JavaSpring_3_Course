package by.motolyha.scooter.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;
@Entity
@Data
@Table(name = "scooter")
public class Scooter implements Serializable {

    @OneToMany(mappedBy = "scooter")
    Set<Orders> orders;

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
}

