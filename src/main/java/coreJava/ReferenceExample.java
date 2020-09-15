package coreJava;


class Father {

    static{
        System.out.println("1");
    }

    Father(){
        System.out.println("2");
    }

    String something(){
        System.out.println("5");
        return "5";
    }

}

public class ReferenceExample extends Father{

    static{
        System.out.println("3");
    }

    ReferenceExample(){
        System.out.println("4");
    }

    String something(){
        return "6";
    }

    public static void main(String[] args) {
        Father a = new ReferenceExample();
        System.out.println(a.something());
    }
}
