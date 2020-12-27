package chegg;

import java.util.ArrayList;
import java.util.List;

public class SubArray {

    public static void main(String[] args) {

        int[] intArray = new int[]{4,2,5,1,6};
        int k = 1;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < intArray.length; i++) {
            int sum = 0;
            sum = intArray[i];
            arrayList.add(intArray[i]);

            for (int j = i + 1; j < intArray.length; j++) {
                arrayList.add(intArray[j]);
                sum = sum + intArray[j];
                if (sum >= k) {
                    if (sum == k) {
                        System.out.println(arrayList.toString());

                    }
                    break;
                }
            }
            System.out.println("size" + arrayList.size());
        }

    }
}
