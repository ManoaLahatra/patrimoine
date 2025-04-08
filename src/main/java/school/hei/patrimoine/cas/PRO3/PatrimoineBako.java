package school.hei.patrimoine.cas.PRO3;

import static java.time.Month.APRIL;
import static java.time.Month.DECEMBER;
import static school.hei.patrimoine.modele.Argent.ariary;
import static school.hei.patrimoine.modele.Devise.MGA;

import java.time.LocalDate;
import java.util.Set;
import java.util.function.Supplier;

import school.hei.patrimoine.modele.Patrimoine;
import school.hei.patrimoine.modele.Personne;
import school.hei.patrimoine.modele.possession.Compte;
import school.hei.patrimoine.modele.possession.FluxArgent;
import school.hei.patrimoine.modele.possession.Materiel;
import school.hei.patrimoine.modele.possession.Possession;

public class PatrimoineBako implements Supplier<Patrimoine> {

    public static final LocalDate AU_8_AVRIL_2025 = LocalDate.of(2025, APRIL, 8);
    public static final LocalDate AU_31_DECEMBRE_2025 = LocalDate.of(2025, DECEMBER, 31);

    @Override
    public Patrimoine get() {
        Personne bako = new Personne("Bako");

        var bni = new Compte("BNI", AU_8_AVRIL_2025, ariary(2_000_000));
        var bmoi = new Compte("BMOI", AU_8_AVRIL_2025, ariary(625_000));
        var coffre = new Compte("Coffre fort", AU_8_AVRIL_2025, ariary(1_750_000));

        new FluxArgent(
                "Salaire",
                bni,
                AU_8_AVRIL_2025,
                AU_31_DECEMBRE_2025,
                2,
                ariary(2_125_000));

        new FluxArgent(
                "Epargne",
                bmoi,
                AU_8_AVRIL_2025,
                AU_31_DECEMBRE_2025,
                3,
                ariary(200_000));
        new FluxArgent(
                "Epargne (retrait BNI)",
                bni,
                AU_8_AVRIL_2025,
                AU_31_DECEMBRE_2025,
                3,
                ariary(-200_000));

        new FluxArgent(
                "Loyer",
                bni,
                AU_8_AVRIL_2025,
                AU_31_DECEMBRE_2025,
                26,
                ariary(-600_000));

        new FluxArgent(
                "Nourriture, transport",
                bni,
                AU_8_AVRIL_2025,
                AU_31_DECEMBRE_2025,
                1,
                ariary(-700_000));

        var ordinateur = new Materiel(
                "Ordinateur portable",
                AU_8_AVRIL_2025,
                AU_8_AVRIL_2025,
                ariary(3_000_000),
                -0.12);

        Set<Possession> possessionsBako = Set.of(bni, bmoi, coffre, ordinateur);

        return Patrimoine.of(
                "Patrimoine de Bako", MGA, AU_8_AVRIL_2025, bako, possessionsBako);
    }
}
