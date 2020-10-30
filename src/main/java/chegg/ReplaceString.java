package chegg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//AA##BCAS#
//B#BCA

class Result {

    /*
     * Complete the 'equalString' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static boolean equalString(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        } else if (s1.contains("#") && s2.contains("#")) {
            String newS1 = newString(s1);
            String newS2 = newString(s2);

            if (newS1.equalsIgnoreCase(newS2)) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } else {
            if (s1.equalsIgnoreCase(s2)) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        }

    }

    private static String newString(String s1) {
        char[] a = s1.toCharArray();

        for (int i = 0; i < a.length; i++) {
            if (a[i] == '#' && i != 0) {
                if (i + 1 < a.length && a[i + 1] == '#') {
                    a[i] = '@';
                    a[i - 1] = '@';
                    a[i - 2] = '@';
                } else {
                    a[i] = '@';
                    a[i - 1] = '@';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : a) {
            if (c != '@') {
                sb.append(c);
            }
        }
        return sb.toString();

    }

}

public class ReplaceString {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abcd"));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        boolean result = Result.equalString(s1, s2);

        bufferedWriter.write(String.valueOf(result ? 1 : 0));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
