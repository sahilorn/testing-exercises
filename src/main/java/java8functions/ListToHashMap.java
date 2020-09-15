package java8functions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ListToHashMap {

    String arrayElementCount(int[] inputArray)
    {

        Map<Integer, Integer> elementCountMap = new HashMap<>();


        for (int i : inputArray)
        {
            if(elementCountMap.containsKey(i))
            {
                //If element is present in elementCountMap, incrementing it's count by 1

                elementCountMap.put(i, elementCountMap.get(i)+1);
            }
            else
            {
                //If element is not present in elementCountMap,
                //adding this element to elementCountMap with 1 as it's value

                elementCountMap.put(i, 1);
            }
        }

        System.out.println("Input Array : "+ Arrays.toString(inputArray));

        System.out.println("Element Count : "+elementCountMap);


        int countOfThree = 0;
        int countOfTwo= 0;
        int countOfOne = 0;
        for (Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
            if (entry.getValue() == 3) {
                countOfThree++;
            }
            if (entry.getValue() == 2) {
                countOfTwo++;
            }
            if (entry.getValue() == 1) {
                countOfOne++;
            }
        }

        System.out.println("countOf3 =="+countOfThree);
        System.out.println("countOf2 =="+countOfTwo);
        System.out.println("countOf1 =="+countOfOne);
        if ( countOfThree == 2 && countOfTwo ==2) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args)
    {
        ListToHashMap counti = new ListToHashMap();
         String value = counti.arrayElementCount(new int[]{4, 3, 3, 4, 1, 2, 2, 3, 6, 5, 4, 5});

        System.out.println(value);

    }

}
