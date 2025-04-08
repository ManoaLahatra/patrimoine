package school.hei.patrimoine.cas;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import school.hei.patrimoine.cas.PRO3.PatrimoineTianaSupplier;
import school.hei.patrimoine.modele.Argent;
import school.hei.patrimoine.modele.Patrimoine;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class PatrimoineTianaTest {
    private final PatrimoineTianaSupplier patrimoineTianaSupplier = new PatrimoineTianaSupplier();

    private Patrimoine patrimoineTiana() {
        return patrimoineTianaSupplier.get();
    }

    @Test
    void patrimoineTianaLe31Mars2026() {
        var patrimoineTiana = patrimoineTiana();
        var patrimoineTianaLe31Mars2026 = patrimoineTiana.projectionFuture(LocalDate.of(2026, Month.MARCH, 31));

        assertEquals(Argent.ariary(164_780_821), patrimoineTianaLe31Mars2026.getValeurComptable());
    }
}
