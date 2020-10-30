package luxoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;


public class TestClass2 {


    public static void main(String args[]) {
        Set<Name> obj = new TreeSet<Name>();
        obj.add(Name.Alice);
        obj.add(Name.Smith);
        obj.add(Name.Bob);
        obj.add(Name.Smith);
        for (Name d : obj) {
            System.out.println(d);
        }
    }
}

enum Name {
    Alice, Smith, Bob, Jones
}


