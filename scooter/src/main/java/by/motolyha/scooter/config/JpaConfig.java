package by.motolyha.scooter.config;

import by.motolyha.scooter.service.ScooterService;
import by.motolyha.scooter.service.impl.ScooterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/scooter_rental?serverTimezone=Europe/Moscow&useSSL=FALSE");
        dataSource.setUsername("root");
        dataSource.setPassword("Danik77995588");
        return dataSource;
    }

    @Bean
    public ScooterService scooterService() {
        return new ScooterServiceImpl();
    }

}
