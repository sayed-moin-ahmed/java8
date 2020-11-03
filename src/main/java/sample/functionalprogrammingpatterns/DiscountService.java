package sample.functionalprogrammingpatterns;

import sample.reactivestream.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

@Service
public class DiscountService {

    /**
     * Without Functional(i.e. without using map)
     * @param customer
     * @return
     */
    public String getDiscountLine(Customer customer) {
        Optional<Integer> discount = getDiscountPercentage(customer.getMemberCard().get());
        if (discount.isPresent())
            return "Discount%:"+discount.get();
        else
            return "";
    }

    /**
     * Using Map(Functional Style)
     * @param customer
     * @return
     */
    public String getDiscountLineFunctional(Customer customer) {
        return customer.getMemberCard()
                .flatMap(card->getDiscountPercentage(card))
                .map(d->"Discount%: "+d)
                .orElse("");
    }
    private Optional<Integer> getDiscountPercentage(MemberCard memberCard) {
        if(memberCard.getFidelityPoints()>100)
            return of(5);
        if(memberCard.getFidelityPoints()>50)
            return of(3);
        return empty();
    }
}
