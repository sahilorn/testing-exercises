import java.util.Arrays;

public class ArrayChecking {

    public static void main(String[] args) {

        int[] intArray = new int[]{1,20,2,10};
        int[] ts = Arrays.copyOfRange(intArray, 0,2);
        int[] ts1 = Arrays.copyOfRange(intArray,2,intArray.length);
        printArray(ts);
        System.out.println("\n");
        printArray(ts1);
        int[] anotherArray = new int[7];
        int temp = 0;
        int d = 2;
        for (int i = 0; i < intArray.length; i++) {

            temp = intArray[i];
            int i1 = intArray.length - d + i - 1;
            System.out.println(" i " + i + " i1  " + i1);
            if (i1 < intArray.length) {
                intArray[i] = intArray[i1];
                intArray[i1] = temp;
                System.out.println("value of i " + intArray[i] + "  value of i1  " +intArray[i1]);
            } else {
                int another = i1 - intArray.length;
                System.out.println(" in else block {} "+another);
                intArray[i] = ts[i1 - intArray.length];
            }
        }
        printArray(intArray);

    }

    private static void printArray(int[] intArray) {
        for (int intValue : intArray) {
            System.out.print(intValue+"  ");
        }
    }
}
