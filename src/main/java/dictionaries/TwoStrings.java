package dictionaries;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

//        List<String> s1List = new ArrayList<>(Arrays.asList(s1.split("")));
//        List<String> s2List = new ArrayList<>(Arrays.asList(s2.split("")));
//        if (s1List.size() < s2List.size()) {
//            for (int i = 0; i < s1List.size() / 2; i++) {
//                if (s2List.contains(s1List.get(i))) {
//                    return "YES";
//                }
//            }
//            for (int i = s1List.size() - 1; i > s1List.size() / 2; i--) {
//                if (s2List.contains(s1List.get(i))) {
//                    return "YES";
//                }
//            }
//            return "NO";
//
//        } else {
//            for (int i = 0; i < s2List.size() / 2; i++) {
//                if (s1List.contains(s2List.get(i))) {
//                    return "YES";
//                }
//            }
//            for (int i = s2List.size() - 1; i > s2List.size() / 2; i--) {
//                if (s1List.contains(s2List.get(i))) {
//                    return "YES";
//                }
//            }
//            return "NO";
//        }

//        String s3 = s1.concat(s2);
//
//        for( char c : s3.toCharArray()){
//            if(s1.indexOf(c) > -1 && s2.indexOf(c) > -1){
//                return "YES";
//            }
//        }
//  return "NO";
        String flag = "";
        Set<Character> a = new HashSet<Character>();
        Set<Character> b = new HashSet<Character>();

        for (char c : s1.toCharArray()) {
            a.add(c);
        }
        for (char c : s2.toCharArray()) {
            b.add(c);
        }
        a.retainAll(b);
        if (a.isEmpty()) {
            flag = "NO";
        } else {
            flag = "YES";
        }
        return flag;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abcd"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }


}
