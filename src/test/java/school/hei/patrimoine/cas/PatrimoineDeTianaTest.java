package school.hei.patrimoine.cas;

import org.junit.jupiter.api.Test;
import school.hei.patrimoine.cas.example.PatrimoineTianaAu31Mars2026;
import school.hei.patrimoine.modele.Patrimoine;

import java.time.LocalDate;

import static java.time.Month.MARCH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.hei.patrimoine.modele.Argent.ariary;
import static school.hei.patrimoine.modele.Devise.MGA;

class PatrimoineDeTianaTest {
    private final PatrimoineTianaAu31Mars2026 patrimoineTianaSupplier =
            new PatrimoineTianaAu31Mars2026();

    private Patrimoine patrimoineDeTiana() {
        return patrimoineTianaSupplier.get();
    }

    @Test
    void tiana_patrimoine_31_mars_2026() {
        // Given
        LocalDate dateCible = LocalDate.of(2026, MARCH, 31);
        Patrimoine patrimoine = patrimoineDeTiana();

        // When
        Patrimoine projection = patrimoine.projectionFuture(dateCible);

        // Then
        assertEquals(ariary(155_080_000), projection.getValeurComptable());
        assertEquals(MGA, projection.getDevise());
    }
}