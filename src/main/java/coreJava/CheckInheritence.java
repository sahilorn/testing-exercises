package coreJava;
    class Animal
    {
        String name = "animal";
        String makeNoise()  { return "generic noise"; }
    }
    class Dog extends Animal
    {
        String name = "dog";
        String makeNoise() {  return "bark"; }
    }
public class CheckInheritence {

    public static void main(String[] args) {
        Dog an = (Dog)new Animal();
        System.out.println(an.name+" "+an.makeNoise());

    }

}
