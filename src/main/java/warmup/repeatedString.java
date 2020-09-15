package warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class repeatedString {

//    public static void main(String[] args) {
//        repeatedString("aba", 10);
//
//    }

    static long repeatedString(String s, long n) {
        System.out.println(" String >>" + s);
        System.out.println("length --> " + n);
        String[] stringArray = s.split("");
        //List<String> stringList = new ArrayList<>(Arrays.asList(stringArray));
        long finalCount = 0;
        if (stringArray.length > 1 && stringArray.length < 100) {
            long wholeNum = n / stringArray.length;
            long remaining = n % stringArray.length;

            int acount = 0;
            for (String str : stringArray) {
                if (str.equalsIgnoreCase("a")) {
                    acount++;
                }
            }
            finalCount = wholeNum * acount;
            int bcount = 0;

            for (int i = 0; i < remaining; i++) {
                if (stringArray[i].equalsIgnoreCase("a")) {
                    bcount++;
                }
            }
            finalCount = finalCount + bcount;
            return finalCount;
        } else {
            // check if single string is a then print
            if (s.equalsIgnoreCase("a")) {
                return n;
            }
        }
        return finalCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abcd"));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
