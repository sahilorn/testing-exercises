public class ImplC extends BaseC implements BaseI{

    public static void main(String[] args) {
        (new ImplC()).method();
    }
}


interface BaseI{
    void method();
}

class BaseC{
    public void method(){
        System.out.println(" HI");
    }
}
