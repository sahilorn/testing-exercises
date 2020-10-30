package hackerrankStringManuplation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SherlockValidString {

    public static void main(String[] args) {

        String s = "aaaaabc";

        String validity = isValid(s);

        System.out.println("count -->" + validity);


    }

    private static String isValid(String s) {
        if (s.length() <= Math.pow(10, 5)) {
            String[] stringArray = s.split("");

            LinkedHashMap<String, Integer> frequency = new LinkedHashMap<>();
            for (String s1 : stringArray) {
                frequency.merge(s1, 1, Integer::sum);
            }
            for (String str : frequency.keySet()) {
                System.out.println(str + "-->" + frequency.get(str));
            }
            List<String> integerList = new ArrayList<>(frequency.keySet());
            int lowestValue = (frequency.get(integerList.get(0)));
            int commonValue = 0;
            int uncommon = 0;
            for (int i = 0; i < integerList.size(); i++) {
                commonValue = frequency.get(integerList.get(i));
                for (int j = i; j < integerList.size(); j++) {
                    if (commonValue == frequency.get(integerList.get(j))) {
                    } else {
                        uncommon = commonValue;
                    }
                }
            }

            System.out.println("uncommon -->" + uncommon);
            System.out.println("common -->" + commonValue);
            Map<Integer, Integer> dataFreq = new HashMap<>();

            for (String str : frequency.keySet()) {
                dataFreq.merge(frequency.get(str), 1, Integer::sum);
            }
            int leastValue = dataFreq.get(frequency.get(integerList.get(0)));
            int leastKey = frequency.get(integerList.get(0));
            for (Integer values : dataFreq.keySet()) {
                if (leastValue > dataFreq.get(values)) {
                    leastValue = dataFreq.get(values);
                    leastKey = values;
                }
                System.out.println(values + "-->" + dataFreq.get(values));
            }
            System.out.println("leastValue -->" + leastValue);

            if (leastValue == 1 && (uncommon - commonValue) == 1 || (leastValue == 1 && commonValue == 1
                    && uncommon >= 1)) {
                return "YES";
            } else if (leastValue == 1 && uncommon > 1) {
                return "NO";
            } else {
                return "NO";
            }
//            int lowestValue = (frequency.get(integerList.get(0)));
//            int commonValue = 0;
//            int uncommon = 0;
//            for (int i = 0; i < integerList.size(); i++) {
//                commonValue = frequency.get(integerList.get(i));
//                for (int j = i; j < integerList.size(); j++) {
//                    if (commonValue == frequency.get(integerList.get(j))) {
//                    } else {
//                        uncommon = commonValue;
//                        count++;
//                    }
//                }
//
////                if (lowestValue == frequency.get(integerList.get(i))) {
////                    commonValue = lowestValue;
////                } else {
////                    count++;
////                    lowestValue = frequency.get(integerList.get(i));
////                }
//
//            }
//            System.out.println("commonValue -->"+uncommon + "count -->"+count);
//            if (lowestValue == 1 && count <= 0) {
//                return "YES";
//            } else if ((lowestValue / commonValue) > commonValue) {
//                return "NO";
//            } else {
//                return "YES";
//            }
            //return "YES";

        } else {
            return "NO";
        }
    }


}
