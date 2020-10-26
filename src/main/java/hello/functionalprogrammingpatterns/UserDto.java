package hello.functionalprogrammingpatterns;

import org.springframework.stereotype.Component;

public class UserDto {

    public UserDto(String userName) {
        this.userName = userName;
    }

    private String userName;

    public String getUserName() {
        return userName;
    }

    public UserDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
