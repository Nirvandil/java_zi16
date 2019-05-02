package zi16_sukharev.exercise2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextToFile {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\resources\\sample_text"))) {
            writer.write("Hello, world!");
        } catch (IOException exc) {
            System.out.println("Caught exception \n " + exc.toString());
        }
    }
}
