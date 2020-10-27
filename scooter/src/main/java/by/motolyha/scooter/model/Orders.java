package by.motolyha.scooter.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Table(name = "orders")
public class Orders implements Serializable {

    @Id
    @NotNull
    @Column(name = "Id")
    private int ordersId;

    @ManyToOne
    @JoinColumn(name = "User_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "Scooter_id")
    Scooter scooter;


    @NotNull
    @Column(name = "Count")
    private int count;

    @NotNull
    @Column(name = "Start_rent")
    private Date startRent;

    @NotNull
    @Column(name = "End_rent")
    private Date endRent;
}