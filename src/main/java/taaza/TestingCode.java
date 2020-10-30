package taaza;

import java.util.Arrays;

public class TestingCode {

    public static void main(String[] args) {

        int[] intArray = new int[]{1, 2, 3, 4,5};

        swap(intArray);

        System.out.println(Arrays.toString(intArray));
    }

    private static void swap(int[] intArray) {
        int temp = 0;
        for (int i = 0; i < (intArray.length/2); i++) {
            temp = intArray[i];
            intArray[i] = intArray[intArray.length - 1 - i];
            intArray[intArray.length - 1 - i] = temp;
        }
    }

}
