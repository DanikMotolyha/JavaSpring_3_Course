package by.motolyha.scooter.rest;


import by.motolyha.scooter.dto.OrderDtoId;
import by.motolyha.scooter.model.Orders;
import by.motolyha.scooter.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping()
    void addUser(@RequestBody @Valid Orders order) {
        System.out.println(order.getStartRent());
        System.out.println(order.getEndRent());
//                java.sql.Date sqlDate = java.sql.Date.valueOf(date)
        orderService.save(order);
    }

    @DeleteMapping(value = "/deleteById")
    void deleteById(@RequestBody @Valid OrderDtoId id){
        orderService.deleteById(id.getId());
    }

}
