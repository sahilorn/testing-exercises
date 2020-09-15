package warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SocksPairSolution {

    public static void main(String[] args) {
        System.out.println(stockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));

    }

    static int stockMerchant(int n, int[] ar) {
        int pairCount = 0;
        if (n > 0 && n <= 100) {
            List<Integer> integerList = Arrays.stream(ar).boxed().collect(Collectors.toList());
            HashMap<Integer, Integer> stockTypeCount = new HashMap<>();
            for (int i : ar) {
                if (!stockTypeCount.containsKey(i)) {
                    stockTypeCount.put(i, 1);
                } else {
                    stockTypeCount.put(i, stockTypeCount.get(i) + 1);
                }
            }
            for (Entry<Integer, Integer> entry : stockTypeCount.entrySet()) {
                System.out.println(entry.getKey() + "  " + entry.getValue());
                if (entry.getValue() > 1) {
                    pairCount = pairCount + (entry.getValue() / 2);
                }
            }
        }
        return pairCount;
    }

}
