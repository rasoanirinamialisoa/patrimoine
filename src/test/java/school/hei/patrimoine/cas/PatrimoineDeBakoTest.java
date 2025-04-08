package school.hei.patrimoine.cas;

import org.junit.jupiter.api.Test;
import school.hei.patrimoine.cas.example.PatrimoineBakoAu31Decembre2025;
import school.hei.patrimoine.modele.Patrimoine;

import java.time.LocalDate;

import static java.time.Month.DECEMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.hei.patrimoine.modele.Argent.ariary;
import static school.hei.patrimoine.modele.Devise.MGA;

class PatrimoineDeBakoTest {
    private final PatrimoineBakoAu31Decembre2025 patrimoineBakoSupplier =
            new PatrimoineBakoAu31Decembre2025();

    private Patrimoine patrimoineDeBako() {
        return patrimoineBakoSupplier.get();
    }

    @Test
    void bako_patrimoine_fin_annee_2025() {

        LocalDate dateCible = LocalDate.of(2025, DECEMBER, 31);
        Patrimoine patrimoine = patrimoineDeBako();

        Patrimoine projection = patrimoine.projectionFuture(dateCible);

        assertEquals(ariary(1_327_500), projection.getValeurComptable());
        assertEquals(MGA, projection.getDevise());

    }
}