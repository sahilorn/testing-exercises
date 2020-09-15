import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantTest {

    public static void main(String[] args) {
        Instant current = Instant.now();
        Duration duration = Duration.between(Instant.parse("2020-03-25T10:49:02.666111400Z"), Instant.now());
        System.out.println(Instant.now());
        System.out.println(OffsetDateTime.now(ZoneOffset.UTC));
        int riskAssessment = Duration.parse("PT2M").compareTo(duration);
        System.out.println(Math.max(riskAssessment, 0));

        /*Instant maxAchievedDate = Instant.parse("2020-03-24T10:40:56.259Z");
        Duration fromChar2 = Duration.parse("PT2M");
        Duration duration = Duration.between(maxAchievedDate, Instant.now());
        int riskAssessment = fromChar2.compareTo(duration);
        System.out.println(Math.max(riskAssessment, 0));*/

    }

}
