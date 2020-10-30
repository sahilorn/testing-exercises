package coreJava;

public class checkStatic {


        static int count = 100;
        public void increment()
        {
            count++;
        }
        public static void main(String[] args)
        {
            checkStatic b1 = new checkStatic();
            b1.increment();
            checkStatic b2 = new checkStatic();
            System.out.println(b2.count);   // line 13
        }

}
