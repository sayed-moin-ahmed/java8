package sample.reactivestream;

import sample.functionalprogramming.Streamable;
import sample.functionalprogrammingpatterns.MemberCard;

import java.util.Optional;
import java.util.Random;

import static java.util.Optional.ofNullable;

public class Customer implements Streamable {

    private MemberCard memberCard;
    private int id;
    private String name;

    public Customer(){
        Integer value = new Random().nextInt();
        this.id = value;
        this.name = String.valueOf(value);
    }


    public Customer(MemberCard memberCard){
        this.memberCard = memberCard;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    public Optional<MemberCard> getMemberCard() {
        return ofNullable(memberCard);
    }

    @Override
    public Customer get() {
        return this;
    }
}
