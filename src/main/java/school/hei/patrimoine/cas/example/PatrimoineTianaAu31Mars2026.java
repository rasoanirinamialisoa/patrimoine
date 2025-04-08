package school.hei.patrimoine.cas.example;

import school.hei.patrimoine.modele.Patrimoine;
import school.hei.patrimoine.modele.Personne;
import school.hei.patrimoine.modele.possession.Compte;
import school.hei.patrimoine.modele.possession.FluxArgent;
import school.hei.patrimoine.modele.possession.Materiel;
import school.hei.patrimoine.modele.possession.Possession;

import java.time.LocalDate;
import java.util.Set;

import static java.time.Month.*;
import static school.hei.patrimoine.modele.Argent.ariary;
import static school.hei.patrimoine.modele.Devise.MGA;

public class PatrimoineTianaAu31Mars2026 {

    public static final LocalDate AU_8_AVRIL_2025 = LocalDate.of(2025, APRIL, 8);
    public static final LocalDate AU_31_MARS_2026 = LocalDate.of(2026, MARCH, 31);

    private Compte compteBancaire() {
        Compte compte = new Compte("Compte Bancaire", AU_8_AVRIL_2025, ariary(60_000_000));

        // Dépenses mensuelles famille (1er de chaque mois)
        new FluxArgent(
                "Dépenses familiales",
                compte,
                AU_8_AVRIL_2025.withDayOfMonth(1),
                AU_31_MARS_2026.withDayOfMonth(1),
                1,
                ariary(-4_000_000)
        );

        // Projet entrepreneurial (juin à décembre 2025)
        // Dépenses projet (5 du mois)
        new FluxArgent(
                "Dépenses projet",
                compte,
                LocalDate.of(2025, JUNE, 5),
                LocalDate.of(2025, DECEMBER, 5),
                5,
                ariary(-5_000_000)
        );

        // Revenus projet
        // 1er paiement (10%) - 1 mai 2025
        new FluxArgent(
                "Avance projet (10%)",
                compte,
                LocalDate.of(2025, MAY, 1),
                LocalDate.of(2025, MAY, 1),
                1,
                ariary(7_000_000)
        );

        // 2ème paiement (90%) - 31 janvier 2026
        new FluxArgent(
                "Solde projet (90%)",
                compte,
                LocalDate.of(2026, JANUARY, 31),
                LocalDate.of(2026, JANUARY, 31),
                31,
                ariary(63_000_000)
        );

        // Prêt bancaire
        // Réception du prêt - 27 juillet 2025
        new FluxArgent(
                "Réception prêt",
                compte,
                LocalDate.of(2025, JULY, 27),
                LocalDate.of(2025, JULY, 27),
                27,
                ariary(20_000_000)
        );

        // Remboursements prêt - À partir du 27 août 2025
        new FluxArgent(
                "Remboursement prêt",
                compte,
                LocalDate.of(2025, AUGUST, 27),
                LocalDate.of(2026, JULY, 27),
                27,
                ariary(-2_000_000)
        );

        return compte;
    }

    private Materiel terrain() {
        return new Materiel(
                "Terrain bâti",
                AU_8_AVRIL_2025,
                AU_31_MARS_2026,
                ariary(100_000_000),
                0.10 // Appréciation annuelle de 10%
        );
    }

    public Patrimoine get() {
        Personne tiana = new Personne("Tiana");

        Compte compte = compteBancaire();
        Materiel terrain = terrain();

        Set<Possession> possessions = Set.of(
                compte,
                terrain
        );

        return Patrimoine.of(
                "Patrimoine de Tiana au 31 mars 2026",
                MGA,
                AU_31_MARS_2026,
                tiana,
                possessions
        );
    }
}