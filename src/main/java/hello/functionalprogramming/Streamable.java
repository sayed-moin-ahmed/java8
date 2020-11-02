package hello.functionalprogramming;

import org.apache.logging.log4j.util.Supplier;

import java.util.stream.Stream;

@FunctionalInterface
public interface Streamable<T> {
    T get();
}

