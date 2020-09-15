package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NewYearChaos {

    static void minimumBribes1(int[] q) {

        int counter = 0;
        String finalString = "";
        for (int i = q.length - 1; i >= 0; i--) {
            int matchedValue = i + 1;
            if (q[i] != matchedValue) {
                if (q[i - 1] == matchedValue) {
                    int swap = q[i];
                    q[i] = q[i - 1];
                    q[i - 1] = swap;
                    counter++;
                } else if (q[i - 2] == matchedValue) {
                    for (int j = 0; j < 2; j++) {
                        int swap = q[i - 2 + j];
                        q[i - 2 + j] = q[i - 2 + 1 + j];
                        q[i - 2 + 1 + j] = swap;
                        counter++;
                    }
                } else {
                    finalString = "Too chaotic";
                    break;
                }
            }
        }
        String finalValue = finalString.equalsIgnoreCase("Too chaotic") ? finalString : Integer.toString(counter);
        System.out.println(finalValue);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes1(q);
        }

        scanner.close();
    }

}
