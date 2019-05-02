package zi16_sukharev.exercise4.service;

import zi16_sukharev.exercise4.model.Account;
import zi16_sukharev.exercise4.model.AccountBalanceType;
import zi16_sukharev.exercise4.model.Client;
import zi16_sukharev.exercise4.model.operations.*;
import zi16_sukharev.exercise4.repository.AccountRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class AccountService {
    private final AccountRepository repository = new AccountRepository();

    public void lockAccount(Long accountNumber) {
        Account account = repository.findAccount(accountNumber);
        execute(new LockOperation(), Collections.singletonList(account), true);
    }

    public void unlockAccount(Long accountNumber) {
        Account account = repository.findAccount(accountNumber);
        execute(new LockOperation(), Collections.singletonList(account), false);
    }

    public long calculate(AccountBalanceType balanceType, String lastName) {
        Client client = repository.findClient(lastName);
        Collection<Account> accounts = findAccountsWithType(balanceType, client);
        return execute(new CalculateSummaryOperation(), accounts, 0L);
    }

    private Collection<Account> findAccountsWithType(AccountBalanceType balanceType, Client client) {
        return execute(new BalanceTypeFilteringOperation(), repository.findAccounts(client), balanceType);
    }

    public Collection<Account> listAll() {
        return execute(new SoringOperation(), repository.findAll(), Comparator.comparing(Account::getClient));
    }

    private <T, E> T execute(Operation<T, E> operation, Collection<Account> accounts, E value) {
        return operation.perform(accounts, value);
    }

}
