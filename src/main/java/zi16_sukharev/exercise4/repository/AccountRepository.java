package zi16_sukharev.exercise4.repository;

import zi16_sukharev.exercise4.model.Account;
import zi16_sukharev.exercise4.model.Client;

import java.util.*;
import java.util.stream.Collectors;

public class AccountRepository {
    private Map<Client, List<Account>> clients = new HashMap<>() {{
        final Client rokfeller = new Client("Рокфеллер");
        final Account rokfellerMainAccount = new Account(rokfeller, 1_000_000_000_00L, 1L, "Основной");
        final Client ivanov = new Client("Иванов");
        final Account ivanovCreditAccount = new Account(ivanov, -5_000_00, 2L, "Кредитный");
        final Account ivanovSalaryAccount = new Account(ivanov, 10_000_00, 3L, "Зарплатный");
        final Account ivanovSecondCreditAccount = new Account(ivanov, -9_000_00, 4L, "Кредитный");
        put(rokfeller, Arrays.asList(rokfellerMainAccount));
        put(ivanov, Arrays.asList(ivanovCreditAccount, ivanovSalaryAccount, ivanovSecondCreditAccount));
    }};

    public Collection<Account> findAccounts(Client client) {
        return clients.getOrDefault(client, Collections.emptyList());
    }

    public Collection<Account> findAll() {
        return clients.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public Account findAccount(Long accountNumber) {
        return clients.values().stream()
                .flatMap(Collection::stream)
                .filter(account -> account.getNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Аккаунт с номером %s не существует", accountNumber)));
    }

    public Client findClient(String lastName) {
        return clients.keySet().stream()
                .filter(client -> client.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Клиента с фамилией %s не существует", lastName)));
    }
}
