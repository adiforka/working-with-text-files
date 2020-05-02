package working_with_text_files;

import java.io.*;

//this implementation of text processor will take lines from different source text files and combine them(with the write
// method, and then write the combined lines into a target file (with write())
public class LineCombiner implements TextProcessor {

    public String read(File... files) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(files[0]));
        BufferedReader br2 = new BufferedReader(new FileReader(files[1]));
        StringBuilder sb = new StringBuilder("{\n");

        String line;
        String line2;
        while ((line = br.readLine()) != null && (line2 = br2.readLine()) != null) {

            sb.append(line);
            sb.append(" ");
            sb.append(line2);
            sb.append("\n");
        }

        sb.append("}");
        br.close();
        return sb.toString();
    }

    public void write(String inputForTargetFile, File... files) throws IOException {

        //append the target file instead of overwriting it
        BufferedWriter bw = new BufferedWriter(new FileWriter(files[0], true));
        bw.write(inputForTargetFile);

        //this is old-school, I know, and normally we'd use try-with-resources
        //an AutoCloseable, but I wanted to keep this code cleaner and let the
        //caller handle the exceptions wherever they run the program
        //thing is: the writer won't actually write right into the file unless I
        //call close on it after it writes
        bw.close();
    }
}
