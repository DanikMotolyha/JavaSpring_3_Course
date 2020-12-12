package by.motolyha.scooter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotBlank(message = "Enter the username")
    @Size(min = 5, max = 20,message = "Username must be between 5 and 20 symbols")
    private String username;
    @Size(min = 5, max = 20,message = "SerName must be between 5 and 20 symbols")
    private String serName;
    @Size(min = 5, max = 20,message = "Login must be between 5 and 20 symbols")
    @NotBlank(message = "Enter the login")
    private String login;
    @Size(min = 8, max = 20,message = "Password must be between 5 and 20 symbols")
    @NotBlank(message = "Enter the password")
    private String password;
    @Size(min = 5, max = 20,message = "mail must be between 5 and 20 symbols")
    private String mail;
}
