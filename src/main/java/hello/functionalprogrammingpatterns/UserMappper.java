package hello.functionalprogrammingpatterns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMappper {

    public UserDto toDto(User user)
    {
       return  new UserDto(user.getUserName());
    }

}
