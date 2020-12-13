package by.motolyha.scooter.service.impl;

import by.motolyha.scooter.model.Orders;
import by.motolyha.scooter.model.User;
import by.motolyha.scooter.model.UserType;
import by.motolyha.scooter.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl {
    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> findAll() {
        return orderRepository.findAll();
    }


    public void save(Orders order) {
        orderRepository.save(order);
    }

    public void deleteById(Integer id){
        orderRepository.deleteById(id);
    }

}
