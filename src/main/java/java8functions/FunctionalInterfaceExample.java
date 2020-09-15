package java8functions;

@FunctionalInterface
interface Square
{
    int calculate(int x);
    static String print(){
        System.out.println("Hi");

        return "Hi";
    }
}

public class FunctionalInterfaceExample {

    public static void main(String args[])
    {
        int a = 5;

        // lambda expression to define the calculate method
        Square s = (int x)->x*x;

        // parameter passed and return type must be
        // same as defined in the prototype
        int ans = s.calculate(a);
        String hello = Square.print();
        System.out.println(ans);
    }

}
