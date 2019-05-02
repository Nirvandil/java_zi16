package zi16_sukharev.exercise4.model;

import lombok.Value;

@Value
public class Client implements Comparable<Client> {
    String lastName;

    @Override
    public int compareTo(Client o) {
        return lastName.compareTo(o.lastName);
    }
}
