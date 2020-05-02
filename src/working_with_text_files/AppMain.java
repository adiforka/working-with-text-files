package working_with_text_files;

import java.io.*;

public class AppMain {
    public static void main(String[] args) {

        File sourceFile1 = new File("src\\working_with_text_files\\text_files\\source file 1.txt");
        File sourceFile2 = new File("src\\working_with_text_files\\text_files\\source file 2.txt");
        File targetFile = new File("src\\working_with_text_files\\text_files\\target file.txt");

        String text = "";
        TextProcessor combiner = new LineCombiner();

        try {
            text = combiner.read(sourceFile1, sourceFile2);
            combiner.write(text, targetFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //checking if the readout was ok
        System.out.println(text);
    }
}
