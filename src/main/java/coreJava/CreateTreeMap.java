package coreJava;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.spec.PSource;

public class CreateTreeMap {

    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(null, "1");
        System.out.println("hashMap --> " + hashMap.toString());

        TreeMap<String, String> fileExtensions = new TreeMap<>();
        fileExtensions.put("null", ".py");
        fileExtensions.put("c++", ".cpp");
        fileExtensions.put("kotlin", ".kt");
        fileExtensions.put("golang", ".go");
        fileExtensions.put("java", ".java");

        System.out.println("FileExtensions -->" + fileExtensions.toString());

        TreeMap<String, String> fileExtensions1 = new TreeMap<>(Comparator.reverseOrder());
        fileExtensions1.put("python", ".py");
        fileExtensions1.put("c++", ".cpp");
        fileExtensions1.put("kotlin", ".kt");
        fileExtensions1.put("golang", ".go");
        fileExtensions1.put("java", ".java");
        //fileExtensions1.put(null, "1");
        System.out.println("FileExtensions1 -->" + fileExtensions1.toString());
        for (String s : fileExtensions.values()) {
            System.out.println(" values -->" + s);
        }


    }

}
