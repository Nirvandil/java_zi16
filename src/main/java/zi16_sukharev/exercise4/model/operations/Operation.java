package zi16_sukharev.exercise4.model.operations;

import zi16_sukharev.exercise4.model.Account;

import java.util.Collection;

public interface Operation<RETURNS, VALUE> {
    RETURNS perform(Collection<Account> accounts, VALUE value);
}
