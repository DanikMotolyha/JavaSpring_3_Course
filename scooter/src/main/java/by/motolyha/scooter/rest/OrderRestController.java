package by.motolyha.scooter.rest;


import by.motolyha.scooter.dto.OrderDtoId;
import by.motolyha.scooter.model.Orders;
import by.motolyha.scooter.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class OrderRestController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping(value = "/order")
    void addUser(@RequestBody @Valid Orders order) {
        orderService.save(order);
    }

    @DeleteMapping(value = "/order/deleteById")
    void deleteById(@RequestBody @Valid OrderDtoId id) {
        orderService.deleteById(id.getId());
    }

    @GetMapping(value = "admin/all")
    List<Orders> getAll() {
        return orderService.findAll();
    }
}
