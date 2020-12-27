package string;

public class DelimeterChecking {

    public static void main(String[] args) {
        String acr = "sahil:";
        String[] stringList = acr.split(":");
        System.out.println(stringList.length);
        for (String i : stringList) {
            System.out.println("value -->" + i);
        }

    }


}
