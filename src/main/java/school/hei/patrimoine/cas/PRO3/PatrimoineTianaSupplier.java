package school.hei.patrimoine.cas.PRO3;

import school.hei.patrimoine.modele.Patrimoine;
import school.hei.patrimoine.modele.Personne;
import school.hei.patrimoine.modele.possession.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.function.Supplier;

import static java.time.Month.*;
import static school.hei.patrimoine.modele.Argent.ariary;
import static school.hei.patrimoine.modele.Devise.MGA;

public class PatrimoineTianaSupplier implements Supplier<Patrimoine> {

    public static final LocalDate AU_8_AVRIL_2025 = LocalDate.of(2025, APRIL, 8);
    public static final LocalDate AU_1_MAI_2025 = LocalDate.of(2025, MAY, 1);
    public static final LocalDate AU_1_JUIN_2025 = LocalDate.of(2025, JUNE, 1);
    public static final LocalDate AU_27_JUILLET_2025 = LocalDate.of(2025, JULY, 27);
    public static final LocalDate AU_27_AOUT_2025 = LocalDate.of(2025, AUGUST, 27);
    public static final LocalDate AU_31_JANVIER_2026 = LocalDate.of(2026, JANUARY, 31);
    public static final LocalDate AU_31_MARS_2026 = LocalDate.of(2026, MARCH, 31);
    public static final LocalDate AU_31_DECEMBRE_2025 = LocalDate.of(2025, DECEMBER, 31);

    @Override
    public Patrimoine get() {
        Personne tiana = new Personne("Tiana");

        var banque = new Compte("Compte bancaire", AU_8_AVRIL_2025, ariary(60_000_000));

        var terrain = new Materiel(
                "Terrain batî",
                AU_8_AVRIL_2025,
                AU_8_AVRIL_2025,
                ariary(100_000_000),
                0.1);

        new FluxArgent(
                "Train de vie",
                banque,
                AU_8_AVRIL_2025,
                AU_31_MARS_2026,
                1,
                ariary(-4_000_000));

        new FluxArgent(
                "Dépense projet",
                banque,
                AU_1_JUIN_2025,
                AU_31_DECEMBRE_2025,
                5,
                ariary(-5_000_000));

        var totalBenefice = 70_000_000;
        new FluxArgent(
                "Premier encaissement",
                banque,
                AU_1_MAI_2025,
                AU_1_MAI_2025,
                1,
                ariary((int) (totalBenefice * 0.1)));
        new FluxArgent(
                "Second encaissement",
                banque,
                AU_31_JANVIER_2026,
                AU_31_JANVIER_2026,
                31,
                ariary((int) (totalBenefice * 0.9)));

        new FluxArgent(
                "Prêt banquaire",
                banque,
                AU_27_JUILLET_2025,
                AU_27_JUILLET_2025,
                27,
                ariary(20_000_000));

        new FluxArgent(
                "Mensualité rembourssement prêt banquaire",
                banque,
                AU_27_AOUT_2025,
                AU_27_AOUT_2025.plusMonths(12),
                27,
                ariary(-2_000_000));

        Set<Possession> possessionsTiana = Set.of(banque, terrain);

        return Patrimoine.of(
                "Patrimoine de Tiana", MGA, AU_8_AVRIL_2025, tiana, possessionsTiana);
    }
}
