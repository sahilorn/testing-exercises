package clearwater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'areAlmostEquivalent' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY s
     *  2. STRING_ARRAY t
     */

    public static List<String> areAlmostEquivalent(List<String> s, List<String> t) {
        // Write your code here
        Map<String, Map<String, Integer>> t1 = new HashMap<>();
        createHashMap(t, t1);
        Map<String, Map<String, Integer>> s1 = new HashMap<>();
        s1 = createHashMap(s,s1);
        List<String> finalList = new ArrayList<>();
        print(t1);
        print(s1);
            int sum = 0;

            for (int i = 0; i < s.size(); i++) {

                Map<String, Integer> s2 = s1.get(s.get(i));
                Map<String, Integer> t2 = t1.get(t.get(i));
                for (String innerAlpha : s2.keySet()) {
                    if(s2.get(innerAlpha) != null && t2.get(innerAlpha) != null){
                        int value = Math.abs(s2.get(innerAlpha) - t2.get(innerAlpha));
                        if (value <= 3) {
                            sum++;
                        }
                    }else if(s2.get(innerAlpha) == null){
                        int value = t2.get(innerAlpha);
                        if (value <= 3) {
                            sum++;
                        }
                    }else if(t2.get(innerAlpha) == null){
                        int value = s2.get(innerAlpha);
                        if (value <= 3) {
                            sum++;
                        }
                    }
                }
                for (String innerAlpha : t2.keySet()) {
                    if(t2.get(innerAlpha) != null && s2.get(innerAlpha) != null){
                        int value = Math.abs(s2.get(innerAlpha) - t2.get(innerAlpha));
                        if (value <= 3) {
                            sum++;
                        }
                    }else if(t2.get(innerAlpha) == null){
                        int value = s2.get(innerAlpha);
                        if (value <= 3) {
                            sum++;
                        }
                    }else if(s2.get(innerAlpha) == null){
                        int value = t2.get(innerAlpha);
                        if (value <= 3) {
                            sum++;
                        }
                    }
                }

                if (sum == (s2.keySet().size()+t2.keySet().size())) {
                    finalList.add("YES");
                } else {
                    finalList.add("NO");
                }
            }



    return finalList;

    }

    private static void print(Map<String, Map<String, Integer>> t1) {
        for(String s:t1.keySet()){
            Map<String,Integer> s1 = t1.get(s);
            for(String s2:s1.keySet())
            System.out.println(" key -->" +s2 + " value -->" + s1.get(s2));
        }
    }

    private static Map<String, Map<String, Integer>> createHashMap(List<String> s, Map<String, Map<String, Integer>> s1) {
        for (String word : s) {
            HashMap<String, Integer> smaller = new HashMap<>();
            for (String alpha : word.split("")) {
                smaller.merge(alpha, 1, Integer::sum);
                s1.put(word, smaller);
            }
        }
        return s1;
    }
}




public class Equivalent {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abc"));

        int sCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> s = IntStream.range(0, sCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int tCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> t = IntStream.range(0, tCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result1.areAlmostEquivalent(s, t);
        System.out.println(" result -->"+result);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}
