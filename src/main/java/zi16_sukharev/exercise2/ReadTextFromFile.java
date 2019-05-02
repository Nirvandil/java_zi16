package zi16_sukharev.exercise2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFromFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\sample_text"))) {
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println("Read string: " + str);
            }
        } catch (IOException exc) {
            System.out.println("Caught exception \n " + exc.toString());
        }
    }
}
