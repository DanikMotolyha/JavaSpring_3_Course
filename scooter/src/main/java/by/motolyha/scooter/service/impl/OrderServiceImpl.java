package by.motolyha.scooter.service.impl;

import by.motolyha.scooter.model.Orders;
import by.motolyha.scooter.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class OrderServiceImpl {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(OrderServiceImpl.class));

    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> findAll() {
        LOGGER.info("findAll");
        return orderRepository.findAll();
    }


    public void save(Orders order) {
        LOGGER.info("save " + order.toString());
        orderRepository.save(order);
    }

    public void deleteById(Integer id) {
        LOGGER.info("delete by id " + id);
        orderRepository.deleteById(id);
    }

}
