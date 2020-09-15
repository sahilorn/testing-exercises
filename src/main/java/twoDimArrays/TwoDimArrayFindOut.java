package twoDimArrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoDimArrayFindOut {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abcd"));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println("result --> " + result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

    }

    private static int hourglassSum(int[][] arr) {
        //System.out.println("array length --> " + arr.length);
        int x = 0;
        int y = 0;
        int maxValue = 0;

        while (x < arr.length - 2) {
            int sum = 0;
            int[][] ar1 = new int[3][3];
            int[][] ar2 = new int[3][3];

            System.out.println("Running row ------>" + x);

            for (int i = 0; i < 3; i++) {
                System.out.println();
                for (int j = 0; j < 3; j++) {
                    //System.out.print(" " + (x + i) + j + " ");
                    ar1[i][j] = arr[x + i][j];
                    System.out.print(" " + ar1[i][j] + " ");
                    sum = sum + ar1[i][j];
                }

//                System.out.println();
//                for (int j = 0; j < 3; j++) {
//                    System.out.print(" " + (i) + (x+j) + " ");
//                    ar1[i][j] = arr[i][x+j];
//                }
            }
            sum-= (ar1[1][0] + ar1[1][2]);
            if (sum > maxValue) {
                maxValue = sum;
            }
            System.out.println(" here with sum -->" + sum + " max value -->" + maxValue);
            sum = 0;
            for (int i = 0; i < 3; i++) {
                System.out.println();
                for (int j = 0; j < 3; j++) {
                    //System.out.print(" " + (x + i) + (arr.length + j - 3) + " ");
                    ar2[i][j] = arr[x + i][arr.length + j - 3];
                    System.out.print(" " + ar2[i][j] + " ");
                    sum = sum + ar2[i][j];
                }
            }
            sum = sum - ar2[1][0] - ar2[1][2];
            if (sum > maxValue) {
                maxValue = sum;
            }
            System.out.println(" here with sum -->" + sum + " max value -->" + maxValue);
            x++;
        }

        int[][] ar3 = new int[3][3];
        int[][] ar4 = new int[3][3];
        while (y < arr.length - 2) {
            int sum1 = 0;
            System.out.println("Running column ------>" + y);
            for (int i = 0; i < 3; i++) {
                System.out.println();
                for (int j = 0; j < 3; j++) {
                    //System.out.print(" " + (i) + (y+j) + " ");
                    ar3[i][j] = arr[i][y + j];
                    System.out.print(" " + ar3[i][j] + " ");
                    sum1 = sum1 + ar3[i][j];
                }

//                System.out.println();
//                for (int j = 0; j < 3; j++) {
//                    System.out.print(" " + (i) + (x+j) + " ");
//                    ar1[i][j] = arr[i][x+j];
//                }
            }
            sum1-= (ar3[1][0] + ar3[1][2]);
            if (sum1 > maxValue) {
                maxValue = sum1;
            }
            System.out.print(" here with sum -->" + sum1 + " max value -->" + maxValue);
            sum1 = 0;
            for (int i = 0; i < 3; i++) {
                System.out.println();
                for (int j = 0; j < 3; j++) {
                    //System.out.print(" " + (arr.length + i - 3) + (y+j) + " ");
                    ar4[i][j] = arr[arr.length + i - 3][y + j];
                    System.out.print(" " + ar4[i][j] + " ");
                    sum1 += ar4[i][j];
                }
            }
            sum1-= (ar4[1][0] + ar4[1][2]);
            if (sum1 > maxValue) {
                maxValue = sum1;
            }
            System.out.println(" here with sum -->" + sum1 + " max value -->" + maxValue);
            y++;
        }

        return maxValue;
    }

}
