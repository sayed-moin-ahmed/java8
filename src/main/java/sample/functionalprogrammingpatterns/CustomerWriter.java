package sample.functionalprogrammingpatterns;

import lombok.SneakyThrows;

import java.io.Writer;

public class CustomerWriter {
   @SneakyThrows
    public void writeOrders(Writer writer)  {
        writer.write("Hello");
    }
}


