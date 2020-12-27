package clearwater;

public class BalancedArray {

    public static void main(String[] args) {

        int[] intArray = new int[]{1, 1, 1, 2, 1, 1, 1};

        int middle = intArray.length / 2;

        for (int k = middle; k < intArray.length; k++) {
            int sumFwd = 0;
            int sumBack = 0;
            for (int i = intArray.length - 1; i > k; i--) {
                System.out.print(" " + intArray[i]);
                sumBack = sumBack + intArray[i];
            }
            System.out.println();
            for (int j = 0; j < k; j++) {
                System.out.print(" " + intArray[j]);
                sumFwd = sumFwd + intArray[j];
            }
            System.out.println();
            System.out.println(" sumFwd " + sumFwd);
            System.out.println("sumBack" + sumBack);
            if (sumFwd == sumBack) {
                System.out.println(" pivot value is" + k);
                break;
            }

        }


    }

}
