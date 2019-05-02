package zi16_sukharev.exercise3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    /**
     * Фамилия водителя.
     */
    private String lastName;
    /**
     * Инициалы водителя.
     */
    private String initials;
}
