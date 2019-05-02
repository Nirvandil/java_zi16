package zi16_sukharev.exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusServiceTest {

    private BusService busService = new BusService();

    @Test
    void withMileageMoreThan() {
        assertEquals(2, busService.withMileageMoreThan(25_000).length);
    }

    @Test
    void withRouteNumber() {
        assertEquals(1, busService.withRouteNumber("24").length);
        assertEquals(2, busService.withRouteNumber("42").length);
    }

    @Test
    void workedMoreThan() {
        final Bus[] oldBuses = busService.workedMoreThan(2);
        assertEquals(1, oldBuses.length);
        assertEquals("#46", oldBuses[0].getNumber());
    }
}