package hello.functionalprogrammingpatterns;

import hello.functionalprogrammingpatterns.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Consumer;

/**
 * Reference : https://dzone.com/articles/functional-programming-patterns-with-java-8
 */
@RestController
public class CustomController {
    @Autowired
    private UserFacade userFacade;
    private Consumer print = System.out::println;


    @GetMapping("/fpp/hello")
    public List<UserDto> test(){
        return userFacade.getAllUsers();
    }
}
