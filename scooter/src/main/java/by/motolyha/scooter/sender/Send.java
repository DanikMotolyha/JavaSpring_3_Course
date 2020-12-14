package by.motolyha.scooter.sender;

import by.motolyha.scooter.sender.type.Ssl;
import by.motolyha.scooter.sender.type.Tls;
import by.motolyha.scooter.service.impl.OrderServiceImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public enum Send {
    INSTANCE;
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(OrderServiceImpl.class));

    private static Tls tlsSender = new Tls("danik.motolyga@gmail.com", "Mail77995588");
    private static Ssl sslSender = new Ssl("danik.motolyga@gmail.com", "Mail77995588");

    public void send(String subject, String message, String mail){
        try {
            tlsSender.send(subject, message, "danik.motolyga@gmail.com", mail);
        } catch (Exception ex1){
            try {
                LOGGER.log(Level.FINEST, ex1.getMessage());
                sslSender.send(subject, message, "danik.motolyga@gmail.com", mail);
            } catch (Exception ex2){
                LOGGER.log(Level.FINEST, ex2.getMessage());
            }
        }
    }
}
