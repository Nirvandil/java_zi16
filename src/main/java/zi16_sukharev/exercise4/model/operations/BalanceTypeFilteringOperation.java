package zi16_sukharev.exercise4.model.operations;

import zi16_sukharev.exercise4.model.Account;
import zi16_sukharev.exercise4.model.AccountBalanceType;

import java.util.Collection;
import java.util.stream.Collectors;

public class BalanceTypeFilteringOperation implements Operation<Collection<Account>, AccountBalanceType> {
    @Override
    public Collection<Account> perform(Collection<Account> accounts, AccountBalanceType accountBalanceType) {
        return accounts.stream()
                .filter(account -> accountBalanceType.is(account.getBalance()))
                .collect(Collectors.toList());
    }
}