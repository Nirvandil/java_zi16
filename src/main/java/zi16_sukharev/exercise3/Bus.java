package zi16_sukharev.exercise3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bus {
    /**
     * Номер автобуса
     */
    private String number;
    /**
     * Модель автобуса
     */
    private String model;
    /**
     * Дата ввода в эксплуатацию.
     */
    private LocalDate commissioningDate;
    /**
     * Пройденное расстояние в километрах.
     */
    private Long mileage;

    /**
     * Текущий водитель автобуса.
     */
    private Driver driver;

    /**
     * Текущий маршрут автобуса.
     */
    private Route route;

    public String getRouteNumber() {
        return route.getNumber();
    }
}
