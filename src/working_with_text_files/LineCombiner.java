package working_with_text_files;

import java.io.*;

//this implementation of text processor will take lines from different source text files and combine them(with the write
// method, and then write the combined lines into a target file (with write())
public class LineCombiner implements TextProcessor {

    //updated to try-with-resources
    public String read(File... files) throws IOException {

        StringBuilder sb = new StringBuilder("{\n");

        try (BufferedReader br = new BufferedReader(new FileReader(files[0]));
             BufferedReader br2 = new BufferedReader(new FileReader(files[1]))) {

            String line;
            String line2;
            while ((line = br.readLine()) != null && (line2 = br2.readLine()) != null) {

                sb.append(line);
                sb.append(" ");
                sb.append(line2);
                sb.append("\n");
            }
        }

        sb.append("}");
        return sb.toString();
    }

    public void write(String inputForTargetFile, File... files) throws IOException {

        //changed to try-with-resources, which, if it fails, will throw an IOException up
        //the call stack, but now there's no way we'll forget to close the reader and keep
        //the file safe

        //append the target file instead of overwriting it
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(files[0], true))) {
            bw.write(inputForTargetFile);
        }
    }
}
