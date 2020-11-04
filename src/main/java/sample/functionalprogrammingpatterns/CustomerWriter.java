package sample.functionalprogrammingpatterns;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.Writer;

public class CustomerWriter {
    public void writeOrders(Writer writer) throws IOException {
        writer.write("Hello");
    }
}


