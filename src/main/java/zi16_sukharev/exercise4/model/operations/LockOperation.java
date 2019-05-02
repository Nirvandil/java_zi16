package zi16_sukharev.exercise4.model.operations;

import zi16_sukharev.exercise4.model.Account;

import java.util.Collection;

public class LockOperation implements Operation<Void, Boolean> {

    @Override
    public Void perform(Collection<Account> accounts, Boolean lock) {
        accounts.forEach(account -> account.setLocked(lock));
        return null;
    }
}