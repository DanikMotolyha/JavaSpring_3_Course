package by.motolyha.scooter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public Scooter(String name, Integer price){
        this.name = name;
        this.price = price;
    }


    @JsonIgnore
    @OneToMany(mappedBy = "scooter")
    Set<Orders> orders;
}

