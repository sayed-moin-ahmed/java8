package hello.functionalprogramming;

import hello.reactivestream.Person;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

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
                .collect(Collectors.partitioningBy(e->e.getAge()>30, counting()));
        print.accept(result);
    }

    /**
     * Race Condition
     * Shared mutability
     *  List<Integer> numbers = new ArrayList<>();
     */
    public void rc(){
        List<Integer> numbers = new ArrayList<>();
        var result  = List.of(1,2,3,4,5,6,7,8,9,10);
        result
                .parallelStream()
                .forEach(number->addToList(numbers,number));
        print.accept(numbers);
    }

    private void addToList(List<Integer> numbers, Integer number) {
        print.accept("Thread: "+Thread.currentThread());
        numbers.add(number);
    }

    /**
     * Grouping By Example.
     */
    public void groupingByExample(){
        Map<String,List<Person>> result = createPeople()
                .stream()
                .collect(groupingBy(Person::getName));
        print.accept(result);
    }

    /**
     * Grouping By counting Collectors.
     */
    public void groupingByCountingExample(){
        Map<String, Long> result = createPeople()
                .stream()
                .collect(groupingBy(Person::getName, counting()));
        print.accept(result);
    }

    /**
     * Grouping By  mapping Collectors.
     */
    public void groupingByMappingExample(){
        Map<String, List<Integer>> result = createPeople()
                .stream()
                .collect(groupingBy(Person::getName, mapping(Person::getAge,toList())));
        print.accept(result);
    }

    public void flatMappingExample(){
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        List<Integer> result = listOfLists.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        print.accept(result);
    }

    public void consumerTest(String msg,Consumer<String> consumer){
        consumer.accept(msg);
    }

    public void biConsumerTest(int t, int u, BiConsumer<Integer, Integer> biConsumer){
        biConsumer.accept(t,u);
    }

    public String functionTest(Integer value, Function<Integer, String> function){
        return function.apply(value);
    }

    public String biFunctionTest(int a, int b, BiFunction<Integer, Integer, String> biFunction){
        return biFunction.apply(a,b);
    }

}



