import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GivenString {

    public static void main(String[] args) {
        String givenString = "aaab";

        String[] strArray = givenString.split("");
        System.out.println("Array -->"+strArray);
        List<String> stList = Arrays.asList(strArray);
        System.out.println("List --->"+ stList);
        HashMap<String,Integer> stringIntegerHashMap = new HashMap<>();

        for(String str :stList){
            int counter = 0;
            if (stringIntegerHashMap.get(str) == null){
                stringIntegerHashMap.put(str,++counter);
            }else{
                int counterValue = stringIntegerHashMap.get(str);
                stringIntegerHashMap.replace(str,++counterValue);
            }
        }
        stringIntegerHashMap.forEach((k,v) -> System.out.println( "key -->"+k+"value -->"+v));

        StringBuilder newString = new StringBuilder();
        for (String str: stringIntegerHashMap.keySet()){
            newString.append(str);
        }
        System.out.println("finalString"+newString.toString());
    }

}
