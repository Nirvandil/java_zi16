package zi16_sukharev.exercise4.model.operations;

import zi16_sukharev.exercise4.model.Account;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringOperation implements Operation<Collection<Account>, Predicate<Account>> {
    @Override
    public Collection<Account> perform(Collection<Account> accounts, Predicate<Account> accountPredicate) {
        return accounts
                .stream()
                .filter(accountPredicate)
                .collect(Collectors.toList());
    }
}
