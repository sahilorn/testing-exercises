package docsApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


class Result {

    /*
     * Complete the 'comparatorValue' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     *  3. INTEGER d
     */

    public static int comparatorValue(List<Integer> a, List<Integer> b, int d) {
        // Write your code here
        int finalCounter = 0;
        for (int i = 0; i < a.size(); i++) {
            List<Integer> diffList = new ArrayList<>();
            for (int j = 0; j < b.size(); j++) {
                int diff = Math.abs(a.get(i) - b.get(j));
                diffList.add(diff);
            }
            int diffCounter = 0;
            System.out.println(" diffList -->" + diffList.toString());
            for (int i1 : diffList) {
                if (i1 <= d) {
                    break;
                } else {
                    diffCounter++;
                }
            }
            System.out.println(" diffCounter -->" + diffCounter);
            if (diffCounter == diffList.size()) {
                finalCounter++;
            }
        }

        return finalCounter;

    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abcd"));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(bufferedReader.readLine().trim());
            a.add(aItem);
        }

        int bCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < bCount; i++) {
            int bItem = Integer.parseInt(bufferedReader.readLine().trim());
            b.add(bItem);
        }

        int d = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.comparatorValue(a, b, d);
        System.out.println("result -->" + result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
