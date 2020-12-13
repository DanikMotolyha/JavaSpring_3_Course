package by.motolyha.scooter.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScooterDtoFull {
    Integer id;
    String name;
    Integer price;
}
