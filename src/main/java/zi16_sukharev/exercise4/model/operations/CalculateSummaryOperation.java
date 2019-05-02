package zi16_sukharev.exercise4.model.operations;

import zi16_sukharev.exercise4.model.Account;

import java.util.Collection;

public class CalculateSummaryOperation implements Operation<Long, Long> {

    @Override
    public Long perform(Collection<Account> accounts, Long accumulator) {
        return accumulator + accounts.stream()
                .mapToLong(Account::getBalance)
                .sum();
    }
}