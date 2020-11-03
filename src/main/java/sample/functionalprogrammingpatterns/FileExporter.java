package sample.functionalprogrammingpatterns;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.function.Consumer;

public class FileExporter {

    public File exportFile(String fileName, Consumer<Writer> contentWriter) throws IOException {
        File file = new File(fileName);
        try (Writer writer = new FileWriter(file)){
            contentWriter.accept(writer);
            return file;
        }catch(Exception e){
            throw e;
        }
    }


}
