package clearwater;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ArraySolution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abc"));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int operationsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int operationsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> operations = new ArrayList<>();

        IntStream.range(0, operationsRows).forEach(i -> {
            try {
                operations.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.performOperations(arr, operations);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}

class Result {

    /*
     * Complete the 'performOperations' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. 2D_INTEGER_ARRAY operations
     */

    public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
        // Write your code here

        if (arr.size() > 1) {

            System.out.println(" Initial Array --> " + arr);
            for (List<Integer> op : operations) {
                Integer swap = 0;
                System.out.println("1st Element -->" + op.get(0) + " 2nd Element --> " + op.get(1));
                if (op.get(0) != null && op.get(1) != null && op.get(0) >= 0 && op.get(1) < arr.size()
                        && op.get(0) < op.get(1)) {
                    System.out.println("1st value -->" + arr.get(op.get(0)) + " 2nd Value --> " + arr.get(op.get(1)));
                    swap = arr.get(op.get(0));
                    arr.set(op.get(0), arr.get(op.get(1)));
                    arr.set(op.get(1), swap);
                    System.out.println(" array after iteration " + arr);

                }
            }
            System.out.println("array =-= " + arr);
        }

        //return 0;
        return arr;
    }

}
