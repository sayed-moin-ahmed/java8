package hello.functionalprogrammingpatterns;

import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UserMappper {

    public UserDto toDto(User user)
    {
       return new UserDto(user.getUserName());
    }

    BiFunction<UserDto,User,UserDto> result = (ud,u)-> ud.setUserName(u.getUserName());

}
