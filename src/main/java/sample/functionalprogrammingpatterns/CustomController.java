package sample.functionalprogrammingpatterns;

import sample.reactivestream.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    private DiscountService discountService;

    private Consumer print = System.out::println;


    @GetMapping("/fpp/sample")
    public List<UserDto> test(){
        return userFacade.getAllUsers();
    }

    @GetMapping("/fpp/optional")
    public String result(@RequestParam("fidelityPoints") Integer fidelityPoints){
        return discountService.getDiscountLineFunctional(new Customer(new MemberCard(fidelityPoints)));
    }
}
