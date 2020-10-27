package by.motolyha.scooter.config;

import by.motolyha.scooter.repository.UserRepository;
import by.motolyha.scooter.service.UserService;
import by.motolyha.scooter.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/scooter_rental?serverTimezone=Europe/Moscow&useSSL=FALSE");
        dataSource.setUsername( "root" );
        dataSource.setPassword( "Danik77995588" );
        return dataSource;
    }

}
