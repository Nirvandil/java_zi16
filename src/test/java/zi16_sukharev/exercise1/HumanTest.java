package zi16_sukharev.exercise1;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HumanTest {

    @Test
    void testHumanBornAlwaysInPast() throws Exception {
        Human human = new Human();
        System.out.println("Checking this human was born in past");
        Thread.sleep(1);
        LocalDateTime now = LocalDateTime.now();
        assertTrue(human.getBirthDate().isBefore(now));
    }

    @Test
    void testHumanPopulationIncreasesWhenHumanBorn() {
        for (int i = 0; i < 5; i++) {
            long oldPopulation = Human.population();
            new Human();
            System.out.println("Checking we have +1 human");
            assertEquals(1, Human.population() - oldPopulation);
        }
    }
}