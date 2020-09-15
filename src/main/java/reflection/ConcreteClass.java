package reflection;

public class ConcreteClass extends BaseClass implements BaseInterface {

    public int publicInt;
    private String privateString = "private string";
    protected boolean protectedBoolean;
    Object defaultObject;

    public ConcreteClass(int publicInt) {
        this.publicInt = publicInt;
    }

    @Override
    public void method1() {
        System.out.println("method 1");
    }

    @Override
    public int method2(String str) {
        System.out.println("method 2");
        return 0;
    }

    @Override
    public int method4() {
        System.out.println("Method4 overriden.");
        return 0;
    }

    public int method5(int i) {
        System.out.println("Method4 overridden.");
        return 0;
    }

    // inner classes
    public class ConcreteClassPublicClass {

    }

    private class ConcreteClassPrivateClass {

    }

    protected class ConcreteClassProtectedClass {

    }

    class ConcreteClassDefaultClass {

    }

    //member enum
    enum ConcreteClassDefaultEnum {}

    public enum ConcreteClassPublicEnum {}

    //member interface
    public interface ConcreteClassPublicInterface {

    }

    public static void main(String[] args) throws ClassNotFoundException {

// Get Class using reflection
        Class<?> concreteClass = ConcreteClass.class;
        concreteClass = new ConcreteClass(5).getClass();
        try {
            // below method is used most of the times in frameworks like JUnit
            //Spring dependency injection, Tomcat web container
            //Eclipse auto completion of method names, hibernate, Struts2 etc.
            //because ConcreteClass is not available at compile time
            concreteClass = Class.forName("com.journaldev.reflection.ConcreteClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(concreteClass.getCanonicalName()); // prints com.journaldev.reflection.ConcreteClass

//for primitive types, wrapper classes and arrays
        Class<?> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName()); // prints boolean

        Class<?> cDouble = Double.TYPE;
        System.out.println(cDouble.getCanonicalName()); // prints double

        Class<?> cDoubleArray = Class.forName("[D");
        System.out.println(cDoubleArray.getCanonicalName()); //prints double[]

        Class<?> twoDStringArray = String[][].class;
        System.out.println(twoDStringArray.getCanonicalName()); // prints java.lang.String[][]



        Class<?> superClass = Class.forName("reflection.ConcreteClass").getSuperclass();
        System.out.println(superClass); // prints "class reflection.BaseClass"
        System.out.println(Object.class.getSuperclass()); // prints "null"
        System.out.println(String[][].class.getSuperclass());// prints "class java.lang.Object"

    }
}
