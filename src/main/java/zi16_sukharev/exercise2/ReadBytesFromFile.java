package zi16_sukharev.exercise2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadBytesFromFile {
    public static void main(String[] args) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("src\\main\\resources\\sample_bytes"))) {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.println("Read byte " + data + " which means " + (char) data);
            }
        } catch (IOException exc) {
            System.out.println("Caught exception \n " + exc.toString());
        }

    }
}
