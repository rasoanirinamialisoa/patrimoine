package school.hei.patrimoine.possession;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public final class Materiel extends Possession {
  private final double tauxDAppreciationAnnuelle;

  public Materiel(String nom, Instant t, int valeurComptable, double tauxDAppreciationAnnuelle){
    super(nom, t, valeurComptable);
    this.tauxDAppreciationAnnuelle = tauxDAppreciationAnnuelle;
  }
  @Override
<<<<<<< HEAD
  public int valeurComptableFuture(Instant tFutur) {
    long differenceJour = ChronoUnit.DAYS.between(t, tFutur);
    long anneeApprox = differenceJour / 365;
    double futureValue = getValeurComptable() * Math.pow(1 + tauxDAppreciationAnnuelle, anneeApprox);
    return (int) futureValue;
=======
  public Possession projectionFuture(Instant tFutur) {
    throw new NotImplemented();
>>>>>>> 700f6b2cdfac3f3fed9215db5c3398507ef69e8a
  }
}
