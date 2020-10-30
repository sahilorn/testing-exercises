package hackerrankStringManuplation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class AnagramCheck {

    static int makeAnagram(String a, String b) {
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();

        Map<Character, Integer> arrayMapA = new HashMap<>();
        Map<Character, Integer> arrayMapB = new HashMap<>();

        for (char ch : arrayA) {
            arrayMapA.merge(ch, 1, Integer::sum);
        }
        for (char ch : arrayB) {
            arrayMapB.merge(ch, 1, Integer::sum);
        }
        int common = 0;

        System.out.println(" Array Map A");
        for (char ch : arrayMapA.keySet()) {

            System.out.println(ch + " -->" + arrayMapA.get(ch));
        }
        System.out.println(" Array Map B");
        for (char ch : arrayMapB.keySet()) {

            System.out.println(ch + " -->" + arrayMapB.get(ch));
        }

        List<Integer> uncommon = new ArrayList<>();
        int uncommonCount = 0;

        for (char ch : arrayMapA.keySet()) {

            if (arrayMapB.get(ch) != null) {
                common = common + Math.min(arrayMapA.get(ch), arrayMapB.get(ch));
            } else {
                uncommon.add(arrayMapA.get(ch));
                uncommonCount = uncommonCount + arrayMapA.get(ch);
            }
        }

        for (char ch : arrayMapB.keySet()) {

            if (arrayMapA.get(ch) != null) {
                common = common + Math.min(arrayMapA.get(ch), arrayMapB.get(ch));
            } else {
                uncommon.add(arrayMapB.get(ch));
                uncommonCount = uncommonCount + arrayMapB.get(ch);
            }
        }

        int totalSum = 0;
        for (Integer co : uncommon) {
            totalSum = totalSum + co;
        }
        System.out.println("totalSUm" + totalSum);
        System.out.println("arrayMapA.keySet().size()" + arrayA.length);
        System.out.println("arrayMapB.keySet().size()" + arrayB.length);
        System.out.println("common count -->" + common);
        int solution = arrayA.length + arrayB.length - common;
        System.out.println(" solution -->" + solution);
        return solution;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abcd"));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
