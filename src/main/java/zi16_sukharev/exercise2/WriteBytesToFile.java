package zi16_sukharev.exercise2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBytesToFile {
    public static void main(String[] args) {
        try(BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("src\\main\\resources\\sample_bytes"))) {
            outputStream.write(42);
        } catch (IOException exc) {
            System.out.println("Caught exception \n " + exc.toString());
        }
    }
}
