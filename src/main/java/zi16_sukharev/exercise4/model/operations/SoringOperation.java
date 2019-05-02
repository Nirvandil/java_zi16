package zi16_sukharev.exercise4.model.operations;

import zi16_sukharev.exercise4.model.Account;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SoringOperation implements Operation<Collection<Account>, Comparator<Account>> {
    @Override
    public Collection<Account> perform(Collection<Account> accounts, Comparator<Account> accountComparator) {
        return accounts
                .stream()
                .sorted(accountComparator)
                .collect(Collectors.toList());
    }
}
