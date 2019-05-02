package zi16_sukharev.exercise4.model;

import lombok.Getter;
import lombok.Setter;

public class Account {
    private long balance;
    @Getter
    @Setter
    private boolean isLocked = false;
    @Getter
    private final Client client;

    @Getter
    private Long number;

    @Getter
    @Setter
    private String description;

    public Account(Client client, long balance, Long number, String description) {
        this.client = client;
        this.balance = balance;
        this.number = number;
        this.description = description;
    }

    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return client.getLastName() + " счёт №" + number + " (" + description + "): " + balance +
                ". Блокировка: " + (isLocked ? "да" : "нет");
    }
}
