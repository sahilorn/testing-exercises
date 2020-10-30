package staticExamples;

public class StaticKeywordEx {

    //Static integer variable
    static int var1 = 77;
    //non-static string variable
    String var2;

    public static void main(String args[]) {
        StaticKeywordEx ob1 = new StaticKeywordEx();
        StaticKeywordEx ob2 = new StaticKeywordEx();

        ob1.var1 = 88;
        ob1.var2 = "I'm Object1";

        ob2.var1 = 99;
        ob2.var2 = "I'm Object2";
        System.out.println("ob1 integer:" + ob1.var1);
        System.out.println("ob1 String:" + ob1.var2);
        System.out.println("ob2 integer:" + ob2.var1);
        System.out.println("ob2 STring:" + ob2.var2);
    }

}
