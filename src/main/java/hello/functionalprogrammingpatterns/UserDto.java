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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
