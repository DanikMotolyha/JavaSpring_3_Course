package by.motolyha.scooter.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Orders implements Serializable {

    @Id
    @NotNull
    @Column(name = "Id")
    private int ordersId;

    @NotNull
    @Column(name = "Count")
    private int count;

    @NotNull
    @Column(name = "Start_rent")
    private Date startRent;

    @NotNull
    @Column(name = "End_rent")
    private Date endRent;

    @ManyToOne
    @JoinColumn(name = "User_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "Scooter_id")
    Scooter scooter;

    public Orders(int count, Date startRent, Date endRent, User user, Scooter scooter){
        this.count = count;
        this.startRent = startRent;
        this.endRent = endRent;
        this.user = user;
        this.scooter = scooter;
    }

    @Override
    public String toString() {
        return "You gen new order" +
                "\ncount = " + count +
                "\nstartRent = " + startRent +
                "\nendRent = " + endRent +
                "\nuser = " + user.getLogin() +
                "\nscooter = " + scooter.getName();
    }
}