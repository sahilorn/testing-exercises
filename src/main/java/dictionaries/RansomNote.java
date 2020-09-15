package dictionaries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

//        if (magazine.length >= note.length) {
//            List<String> s1List = new ArrayList<>(Arrays.asList(magazine));
//            int counter = 0;
//
//            for (String str : note) {
//                if (s1List.contains(str)) {
//                    s1List.remove(str);
//                    counter++;
//                } else {
//                    System.out.println("No");
//                    return;
//                }
//            }
//            if (counter == note.length) {
//                System.out.println("Yes");
//            } else {
//                System.out.println("No");
//            }
//
//
//        }
//        Set<String> a = new HashSet<String>();
//        Set<String> b = new HashSet<>();
//
//        for( String str:magazine){
//            a.add(str);
//        }
//        for(String str:note){
//            b.add(str);
//        }
//        a.
        int counter = 0;
        List<String> s1List = new ArrayList<>(Arrays.asList(magazine));
        for (String noteString : note) {
            if (s1List.indexOf(noteString) > -1) {
                s1List.remove(noteString);
                counter++;
            } else {
                System.out.println("No");
                return;
            }
        }
        if (counter == note.length) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        if (m >= 1 && n <= 30000) {
            String[] magazine = new String[m];
            String magazineString = scanner.nextLine();
            String noteString = scanner.nextLine();
            if (m == n) {
                System.out.println(magazineString.equals(noteString) ? "Yes" : "No");
            } else {
                String[] magazineItems = magazineString.split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < m; i++) {
                    if (magazineItems[i].length() >= 1) {
                        String magazineItem = magazineItems[i];
                        magazine[i] = magazineItem;
                    } else {
                        System.out.println("No");
                        scanner.close();
                        return;

                    }
                }

                String[] note = new String[n];

                String[] noteItems = noteString.split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < n; i++) {
                    if (noteItems[i].length() <= 5) {
                        String noteItem = noteItems[i];
                        note[i] = noteItem;
                    } else {
                        System.out.println("No");
                        scanner.close();
                        return;
                    }

                }
                checkMagazine(magazine, note);
            }
        } else {
            System.out.println("No");
        }

        scanner.close();
    }

}
