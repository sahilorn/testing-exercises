package hackerrankStringManuplation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlternatingCharacters {

    public static void main(String[] args) {

        String s = "AAABBB";
        String[] stringArray = s.split("");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < stringArray.length; i++) {
            if (i + 1 < stringArray.length) {
                if (stringArray[i].equalsIgnoreCase(stringArray[i + 1])) {
                    count++;
                }
            }

        }
        System.out.println(count);
    }

}
