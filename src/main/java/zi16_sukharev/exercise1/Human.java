package zi16_sukharev.exercise1;

import java.time.LocalDateTime;

public class Human {
    private static long population = 0;

    public static long population() {
        return population;
    }

    private final LocalDateTime birthDate;

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public Human() {
        this.birthDate = LocalDateTime.now();
        System.out.println("Human born!");
        population++;
    }
}
