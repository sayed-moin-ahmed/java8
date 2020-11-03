package sample.spliterator;

import org.apache.logging.log4j.util.Supplier;

import java.util.List;

import static java.util.List.of;

public class CustomSpliterator {

    static Supplier<List<String>> data = ()->List.of("Hello","a","b","c","d");

    public static void main(String[] args){
        data.get().spliterator().forEachRemaining(System.out::println);
        System.out.println(data.get().spliterator().getExactSizeIfKnown());
    }

}
