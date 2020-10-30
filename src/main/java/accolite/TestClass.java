package accolite;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {

        int[] intArray = new int[]{2, 3, 5, 8, 10};
        List<Integer> collect = Arrays.stream(intArray).boxed().sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.println(collect.toString());

        int gap = 0;
        for (int i = 0; i < intArray.length ; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (Math.abs(intArray[i] - intArray[j]) > gap) {
                    gap = Math.abs(intArray[i] - intArray[j]);
                }
            }
        }

        System.out.println("final Gap ==>" + gap);


    }

}
