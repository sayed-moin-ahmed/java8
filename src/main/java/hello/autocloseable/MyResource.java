package hello.autocloseable;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class MyResource  implements  AutoCloseable, Supplier {
    @Override
    public void close() throws Exception {
        print.accept("AutoCloseable::Close");
    }

    Consumer print  = System.out::println;

    @Override
    public Object get() {
        return this;
    }
}
