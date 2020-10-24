package hello;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExploreCollection {

    private List<Person> createPeople() {
        return List.of(
          new Person(20,"Sara"),
                new Person(20,"Sara"),
                new Person(22,"Sara"),
                new Person(20,"Bod"),
                new Person(30,"Paula"),
                new Person(2,"Jack"),
                new Person(72,"Jack"),
                new Person(12,"Jill")
        );

    }

    Consumer print = System.out::println;
    Predicate<? super Person> predicate = e-> e.getAge()>29;
    //Create a Comparator
    Comparator<Person> comparingByName = Comparator.comparing(Person::getName);
    Comparator<Person> comparingByAge = Comparator.comparing(Person::getAge);
    //BinaryOperator with a custom Comparator
    BinaryOperator<Person> boByName = BinaryOperator.maxBy(comparingByName);
    BinaryOperator<Person> boByAge = BinaryOperator.maxBy(comparingByAge);

    /**
     * Stream Map example
     */
    public void mapExample() {
        List<String> result = createPeople()
                .stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toUnmodifiableList());
        print.accept(result);
    }

    /**
     * Stream filter with map example
     */
    public void filterMapExample() {
        List<String> result = createPeople()
                .stream()
                .filter(predicate)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toUnmodifiableList());
        print.accept(result);
    }

    /**
     * Stream for Each example
     */
    public void forEachExample(){
        createPeople()
                .stream()
                .forEach(print);
    }

    /**
     * Stream Reduce example
     */
    public void reduceExample(){
        Person result = createPeople()
                .stream()
                .reduce(boByAge).get();
        print.accept(result);
    }

    /**
     * Partitioning of data in stream
     */
    public void partitionExample(){
         Map<Boolean, List<Person>> result= createPeople()
                .stream()
                .collect(Collectors.partitioningBy(e->e.getAge()>30));
        print.accept(result);
    }

    /**
     * Partitioning of data in stream with collectors.
     */
    public void partitionCollectorExample(){
        Map<Boolean, Long> result= createPeople()
                .stream()
                .collect(Collectors.partitioningBy(e->e.getAge()>30,Collectors.counting()));
        print.accept(result);
    }


}


