package coreJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student
{
    int rollno;
    String name, address;

    // Constructor
    public Student(int rollno, String name,
            String address)
    {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // Used to print student details in main()
    public String toString()
    {
        return this.rollno + " " + this.name +
                " " + this.address;
    }
}

class SortByRoll implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        return s1.rollno - s2.rollno;
    }
}

public class CollectionSortExample {

    public static void main (String[] args)
    {
        ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(111, "bbbb", "london"));
        ar.add(new Student(131, "aaaa", "nyc"));
        ar.add(new Student(121, "cccc", "jaipur"));

        System.out.println("Unsorted");
        for (Student student : ar)
            System.out.println(student);

        ar.sort(new SortByRoll());

        Collections.sort(ar, (o1, o2) -> 0);
        System.out.println("\nSorted by rollno");
        for (Student student : ar)
            System.out.println(student);
    }

}
