import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DurationCheck {

    public static void main(String[] args) {

        /*Duration expirationAlertPeriod = Duration.ofHours(5);
        Duration validityPeriod = Duration.ofDays(15);
        Instant validFrom = Instant.now().minus(10, ChronoUnit.DAYS);
        System.out.println(" validFrom -->"+validFrom);
        System.out.println(" current Instant -->"+Instant.now());
        Duration duration = Duration.between(validFrom, Instant.now());
        System.out.println("duration -->"+duration.toDays());
        int comparison =validityPeriod.compareTo(duration);
        System.out.println("comparison -->"+comparison);
        int comparison1 =expirationAlertPeriod.compareTo(duration);
        System.out.println("comparison1 -->  "+comparison1);

        long l = validityPeriod.toDays() - expirationAlertPeriod.toDays();
        System.out.println(l);

        System.out.println(" in nanos --> "+expirationAlertPeriod.toDays());*/

        Instant currentInstant = Instant.now();
        Duration expirationAlertPeriod = Duration.ofDays(2);
        Duration validityPeriod = Duration.ofDays(6);
        Instant validUntil = currentInstant.plus(validityPeriod);
        Instant expirationAlertTime = currentInstant.plus(validityPeriod).minus(expirationAlertPeriod);
        if (Instant.now().isBefore(validUntil)) {
            if (Instant.now().isAfter(expirationAlertTime)) {
                int daysToExpire = (int) Duration.between(Instant.now(), validUntil).toDays();
                System.out.println("daysToExpire -->" + daysToExpire);
            } else {
                System.out.println("outside loop");
            }
        }

    }

}
