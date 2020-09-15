package warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValleyTest {

    public static void main(String[] args) {
        System.out.println(countingValleys(12,"DDUUDDUDUUUD"));
    }

    static int countingValleys(int n, String s) {
        int crossed = 0;
        if (s != null && (n >= 2)) {
            String[] charArray = s.split("");

            List<String> stringList = new ArrayList<>(Arrays.asList(charArray));
            int sum = 0;
            int vallayCross = 0;

            for (String stringChar : stringList) {
                int value = stringChar.equals("D") ? -1 : 1;
                sum = sum + value;
                if (sum == 0 && !stringChar.equalsIgnoreCase("D")) {
                    vallayCross++;
                }
            }


            //crossed = vallayCross / 2;


            return vallayCross;
        } else {
            return crossed;
        }

    }

}
