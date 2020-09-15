package coreJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SingletonClass implements Serializable {

    public static SingletonClass singleton = new SingletonClass();

    public Object readResolve() {
        return singleton;
    }

}

public class SingletonBreakingThroughSerialisation {

    public static void main(String[] args) {

        try {
            SingletonClass instance1 = SingletonClass.singleton;
            ObjectOutput out
                    = new ObjectOutputStream(new FileOutputStream("file.text"));
            out.writeObject(instance1);
            out.close();

            // deserailize from file to object
            ObjectInput in
                    = new ObjectInputStream(new FileInputStream("file.text"));

            SingletonClass instance2 = (SingletonClass) in.readObject();
            in.close();

            System.out.println("instance1 hashCode:- "
                    + instance1.hashCode());
            System.out.println("instance2 hashCode:- "
                    + instance2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
