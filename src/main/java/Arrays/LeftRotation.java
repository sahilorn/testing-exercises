package Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class LeftRotation {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abcd"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);
        for (int i : result) {
            System.out.print(" " + i + " ");
        }

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    private static int[] rotLeft(int[] a, int d) {
        int[] b = new int[a.length];
        if (d >= 1 && d <= a.length) {
            for (int i = 0; i < a.length; i++) {
                int index = (a.length + d + i) % a.length;
                System.out.println(" i " + i + " will get " + index);
                b[i] = a[(a.length + d + i) % a.length];
                //System.out.println(" length -->" + b[i]);
            }
        }
        return b;
    }

}
