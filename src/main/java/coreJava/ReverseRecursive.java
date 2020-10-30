package coreJava;

public class ReverseRecursive {

    public static void main(String[] args) {
        String name = "sahil";
        int size = name.length();

        while (size > 0) {
            reverseArray(name);
            size--;
        }


    }

    private static void reverseArray(String name) {
        if (name.length() <= 1) {

        } else {
            reverseArray(name.substring(0, name.length() - 1));
        }
    }


}
