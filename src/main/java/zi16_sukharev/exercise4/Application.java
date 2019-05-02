package zi16_sukharev.exercise4;

import zi16_sukharev.exercise4.service.AccountService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {

    public static void main(String[] args) throws Exception {
        final MainMenuUI ui = new MainMenuUI(
                new AccountService(),
                new BufferedReader(new InputStreamReader(System.in))
        );
        ui.drawMenu();
    }
}
