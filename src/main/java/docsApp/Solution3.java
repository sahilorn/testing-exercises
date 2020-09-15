package docsApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'commonPrefix' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY inputs as parameter.
     */

    public static List<Integer> commonPrefix(List<String> inputs) {
        List<Integer> integerList = new ArrayList<>();
        if (inputs.size() > 0) {
            for (String input : inputs) {
                int length = input.length();
                int commonLength = 0;
                for (int i = 0; i < length; i++) {
                    String suffixString = input.substring(i);
                    String removedString = input.substring(0, i);
                    char[] suffix = suffixString.toCharArray();
                    char[] removed =removedString.toCharArray();
                    System.out.print("remove --> " + suffixString);
                    System.out.println("  suffix --> " + removedString);
//                    System.out.println(" boolean --> "+suffix.startsWith(removed));
//                    if(suffix.startsWith(removed)){
//                        System.out.println(removed.length() <= 0 ? suffix.length() : removed.length());
//                        commonLength+= removed.length() <= 0 ? suffix.length() : removed.length();
//                    }
                    if(removed.length <=0){
                        commonLength+= suffix.length;
                    }else{
                        for (int x = 0; x < suffix.length; x++) {
                            System.out.print("suffix value --> " + suffix[x]);
                            System.out.println("   removed value -->" + removed[Math.floorMod(x,removed.length)]);
                            if (suffix[x] == removed[x % removed.length]) {
                                System.out.println("cm -->" + commonLength);
                                commonLength++;
                            }else{
                                break;
                            }
                        }
                    }

                }
                System.out.println("commonLength ==>" + commonLength);
                integerList.add(commonLength);
            }
        }
        // Write your code here
        return integerList;
    }

}

public class Solution3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abcd"));

        int inputsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> inputs = IntStream.range(0, inputsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<Integer> result = Result1.commonPrefix(inputs);

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