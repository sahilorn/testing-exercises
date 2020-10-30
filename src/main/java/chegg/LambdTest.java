package chegg;

interface Employee {

    void empData(String name);
}

public class LambdTest {

    public static void main(String[] args) {
        Employee emp = name -> {
            System.out.println("em " + name);
            //throw  new Exception();
        };
        try {
            emp.empData("sahil");

        } catch (Exception e) {
        }
    }

}
