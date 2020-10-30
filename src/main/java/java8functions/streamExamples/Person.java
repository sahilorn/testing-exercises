package java8functions.streamExamples;

public class Person {

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    private Sex gender;
    private String fName;
    private String lName;
    public Person(Sex gender, String fName, String lName) {
        this.gender = gender;
        this.fName = fName;
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender=" + gender +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
