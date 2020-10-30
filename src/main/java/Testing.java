public class Testing {


    static String str;

    public void Testing() {
        System.out.println(" in cont");
        str = "helo";
    }

    public static void main(String[] args) {
        Testing testing = new Testing();
        System.out.println(str);
    }
}

class Exc0 extends Exception {

}

class Exc1 extends Exc0 {

}

