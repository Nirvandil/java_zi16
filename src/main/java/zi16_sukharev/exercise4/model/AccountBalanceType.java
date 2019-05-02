package zi16_sukharev.exercise4.model;

public enum AccountBalanceType {
    POSITIVE, NEGATIVE;

    public boolean is(long balance) {
        if (this == POSITIVE) {
            return balance >= 0;
        } else {
            return balance < 0;
        }
    }
}
