package zi16_sukharev.exercise3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class BusService {
    private final Bus[] buses = {
            new Bus("#42", "Ford", LocalDate.now().minus(1, ChronoUnit.YEARS), 10_000L,
                    new Driver("Sample", "A.B."), new Route("42")),
            new Bus("#24", "Fiat", LocalDate.now().minus(2, ChronoUnit.YEARS), 25_000L,
                    new Driver("Sample", "B.A."), new Route("24")),
            new Bus("#45", "Volkswagen", LocalDate.now().minus(8, ChronoUnit.MONTHS), 15_250L,
                    new Driver("Sample", "C.D."), new Route("42")),
            new Bus("#46", "Volkswagen", LocalDate.now().minus(3, ChronoUnit.YEARS), 31_500L,
                    new Driver("Sample", "D.C."), new Route("33")),
            new Bus("#47", "Mercedes-Benz", LocalDate.now().minus(2, ChronoUnit.YEARS), 38_500L,
                    new Driver("Sample", "D.E."), new Route("33"))};

    public Bus[] withMileageMoreThan(int mileage) {
        System.out.println("Filtering buses for mileage more than " + mileage);
        return Stream.of(buses)
                .filter(bus -> bus.getMileage() > mileage)
                .toArray(Bus[]::new);
    }

    public Bus[] withRouteNumber(String routeNumber) {
        return Stream.of(buses)
                .filter(bus -> bus.getRouteNumber().equals(routeNumber))
                .toArray(Bus[]::new);
    }

    public Bus[] workedMoreThan(int years) {
        return Stream.of(buses)
                .filter(bus -> bus.getCommissioningDate().isBefore(LocalDate.now().minus(years, ChronoUnit.YEARS)))
                .toArray(Bus[]::new);
    }
}
