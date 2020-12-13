package by.motolyha.scooter.dto;

import by.motolyha.scooter.model.UserType;

public class UserResponse  {
    private int id;
    private String login;
    private UserType type;

    public UserResponse(int id, String login, UserType type) {
        this.id = id;
        this.login = login;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
