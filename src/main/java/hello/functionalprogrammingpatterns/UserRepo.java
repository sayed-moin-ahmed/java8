package hello.functionalprogrammingpatterns;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepo {

    public List<User> findAll(){
        return List.of(
          new User("Sam"),
          new User("Rock")
        );
    }

}
