package zi16_sukharev.exercise4;

import lombok.RequiredArgsConstructor;
import zi16_sukharev.exercise4.model.AccountBalanceType;
import zi16_sukharev.exercise4.service.AccountService;

import java.io.BufferedReader;
import java.io.IOException;

@RequiredArgsConstructor
public class MainMenuUI {
    private final AccountService accountService;
    private final BufferedReader reader;

    public void drawMenu() throws IOException {
        while (true) {
            System.out.println("===============================================================");
            System.out.println("Выберите, что необходимо сделать: введите число и нажмите Enter");
            System.out.println("1 - отобразить список клиентов и счетов");
            System.out.println("2 - заблокировать\\разблокировать счёт");
            System.out.println("3 - Получить сводную информацию по счёту");
            System.out.println("0 - Выйти из приложения");
            System.out.println("===============================================================");
            final String action = reader.readLine();
            switch (action) {
                case "1":
                    printAccounts();
                    break;
                case "2":
                    lockAction();
                    break;
                case "3":
                    infoAction();
                    break;
                case "0":
                    System.out.println("Завершение приложения");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Такого типа действия не существует :-(");
            }
        }
    }

    private void infoAction() throws IOException {
        System.out.println("Введите фамилию интересующего вас клиента");
        final String lastName = reader.readLine();
        System.out.println(String.format("Сводная информация по счетам клиента %s", lastName));
        final long positiveBalance = accountService.calculate(AccountBalanceType.POSITIVE, lastName);
        final long negativeBalance = accountService.calculate(AccountBalanceType.NEGATIVE, lastName);
        System.out.println(String.format("Суммарный баланс всех положительных счетов: %s", positiveBalance));
        System.out.println(String.format("Суммарный баланс всех отрицательных счетов: %s", negativeBalance));
    }

    private void lockAction() throws IOException {
        System.out.println("Введите номер счёта для блокировки");
        final Long accountNumber = Long.valueOf(reader.readLine());
        accountService.lockAccount(accountNumber);
        System.out.println(String.format("Счёт номер %s заблокирован", accountNumber));
    }

    private void printAccounts() {
        accountService.listAll().forEach(System.out::println);
    }
}