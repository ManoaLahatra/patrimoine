package school.hei.patrimoine.cas;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import school.hei.patrimoine.cas.PRO3.PatrimoineBako;
import school.hei.patrimoine.modele.Argent;
import school.hei.patrimoine.modele.Patrimoine;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class BakoCasTest {
    private final PatrimoineBako patrimoineBakoSupplier = new PatrimoineBako();

    private Patrimoine patrimoineBako() {
        return patrimoineBakoSupplier.get();
    }

    @Test
    void patrimoineBakoLe31Decembre2025() {
        var patrimoineBako = patrimoineBako();
        var patrimoineBakoLe31Decembre2025 = patrimoineBako.projectionFuture(LocalDate.of(2025, Month.DECEMBER, 31));

        assertEquals(Argent.ariary(10_375_000), patrimoineBakoLe31Decembre2025.getValeurComptable());
    }
}
