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

public class PatrimoineBakoAu31Decembre2025 {

    public static final LocalDate AU_8_AVRIL_2025 = LocalDate.of(2025, APRIL, 8);
    public static final LocalDate AU_31_DECEMBRE_2025 = LocalDate.of(2025, DECEMBER, 31);

    private Compte compteBNI() {
        Compte compte = new Compte("Compte BNI", AU_8_AVRIL_2025, ariary(2_000_000));


        new FluxArgent(
                "Salaire",
                compte,
                AU_8_AVRIL_2025.withDayOfMonth(2).plusMonths(1),
                AU_31_DECEMBRE_2025.withDayOfMonth(2),
                2,
                ariary(2_125_000)
        );

        new FluxArgent(
                "Virement épargne",
                compte,
                AU_8_AVRIL_2025.withDayOfMonth(3).plusMonths(1),
                AU_31_DECEMBRE_2025.withDayOfMonth(3),
                3,
                ariary(-200_000)
        );


        new FluxArgent(
                "Loyer",
                compte,
                AU_8_AVRIL_2025.withDayOfMonth(26),
                AU_31_DECEMBRE_2025.withDayOfMonth(26),
                26,
                ariary(-600_000)
        );


        new FluxArgent(
                "Dépenses mensuelles",
                compte,
                AU_8_AVRIL_2025.withDayOfMonth(1).plusMonths(1),
                AU_31_DECEMBRE_2025.withDayOfMonth(1),
                1,
                ariary(-700_000)
        );

        return compte;
    }

    private Compte compteBMOI() {
        Compte compte = new Compte("Compte BMOI", AU_8_AVRIL_2025, ariary(625_000));

        new FluxArgent(
                "Virement épargne",
                compte,
                AU_8_AVRIL_2025.withDayOfMonth(3).plusMonths(1),
                AU_31_DECEMBRE_2025.withDayOfMonth(3),
                3,
                ariary(200_000)
        );

        return compte;
    }

    private Compte coffreFort() {
        return new Compte("Coffre fort", AU_8_AVRIL_2025, ariary(1_750_000));
    }

    private Materiel ordinateur() {
        double tauxProportionnel = 0.12 * (8.77/12);
        return new Materiel(
                "Ordinateur portable",
                AU_8_AVRIL_2025,
                AU_31_DECEMBRE_2025,
                ariary(3_000_000),
                -tauxProportionnel
        );
    }

    public Patrimoine get() {
        Personne bako = new Personne("Bako");

        Compte compteBNI = compteBNI();
        Compte compteBMOI = compteBMOI();
        Compte coffreFort = coffreFort();
        Materiel ordinateur = ordinateur();

        Set<Possession> possessions = Set.of(
                compteBNI,
                compteBMOI,
                coffreFort,
                ordinateur
        );

        return Patrimoine.of(
                "Patrimoine de Bako au 31 décembre 2025",
                MGA,
                AU_31_DECEMBRE_2025,
                bako,
                possessions
        );
    }

}