import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class JsonString {

    public static void main(String[] args) {
        for(int i =0;i< 100;i++){
            Instant minus = Instant.now().minus((long) (new Random().nextInt(200)), ChronoUnit.DAYS);
            System.out.println(minus);
        }

    }

}
