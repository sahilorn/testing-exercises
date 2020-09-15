package TestQuestions;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CompareSolution extends Comparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Comparator comp = new Comparator();

        int testCases = Integer.parseInt(scan.nextLine());
        while(testCases-- > 0){
            int condition = Integer.parseInt(scan.nextLine());
            switch(condition){
                case 1:
                    String s1=scan.nextLine().trim();
                    String s2=scan.nextLine().trim();

                    System.out.println( (comp.compare(s1,s2)) ? "Same" : "Different" );
                    break;
                case 2:
                    int num1 = scan.nextInt();
                    int num2 = scan.nextInt();

                    System.out.println( (comp.compare(num1,num2)) ? "Same" : "Different");
                    if(scan.hasNext()){ // avoid exception if this last test case
                        scan.nextLine(); // eat space until next line
                    }
                    break;
                case 3:
                    // create and fill arrays
                    int[] array1 = new int[scan.nextInt()];
                    int[] array2 = new int[scan.nextInt()];
                    for(int i = 0; i < array1.length; i++){
                        array1[i] = scan.nextInt();
                    }
                    for(int i = 0; i < array2.length; i++){
                        array2[i] = scan.nextInt();
                    }

                    System.out.println( comp.compare(array1, array2) ? "Same" : "Different");
                    if(scan.hasNext()){ // avoid exception if this last test case
                        scan.nextLine(); // eat space until next line
                    }
                    break;
                default:
                    System.err.println("Invalid input.");
            }// end switch
        }// end while
        scan.close();
    }
}

class Comparator {

    public  boolean compare(String newData, String intialData) {
        if (newData != intialData) {
            if (newData == null || intialData == null)
                return false;
            return newData.equals(intialData);
        }
        return true;
    }

    public boolean compare(String[] newData, String[] intialData) {
        if (newData.length != intialData.length)
            return false;
        Set<String> anotherSet = new HashSet<>(Arrays.asList(intialData));
        for (String currentValue : newData)
            if (!anotherSet.contains(currentValue))
                return false;
        return true;
    }

    boolean compare(int[] newData, int[] intialData) {
        if (newData.length != intialData.length)
            return false;
        Set<Integer> crunchifySet = anotherSet(intialData);
        for (int currentValue : newData)
            if (!crunchifySet.contains(currentValue))
                return false;
        return true;
    }

    public static Set<Integer> anotherSet(int[] cData) {
        Set<Integer> anSet = new HashSet<>();
        for (int data : cData)
            anSet.add(data);
        return anSet;
    }

    boolean compare(int num1, int num2) {
        return false;
    }
}
