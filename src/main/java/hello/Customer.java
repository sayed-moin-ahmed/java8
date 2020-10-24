package hello;

import java.util.Random;

public class Customer {

    private int id;
    private String name;

    public Customer(){
        Integer value = new Random().nextInt();
        this.id = value;
        this.name = String.valueOf(value);
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
}
