package working_with_text_files;

import java.io.File;
import java.io.IOException;

//this mandates behavior to be provided in its implementations
public interface TextProcessor {

    String read(File... files) throws IOException;

    void write(String input, File... files) throws IOException;
}
