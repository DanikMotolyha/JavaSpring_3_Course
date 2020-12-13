package by.motolyha.scooter;

import by.motolyha.scooter.model.User;
import by.motolyha.scooter.service.impl.OrderServiceImpl;
import by.motolyha.scooter.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {

    @Autowired
    private UserServiceImpl service;
    @Test
    public void getAllUsers(){
        try {
            Assert.assertNotNull(service.findAll());
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void getByLogin(){
        try {
            Assert.assertNotNull(service.findByLogin("Danik"));
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
