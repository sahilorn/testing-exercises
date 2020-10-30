package MultiThreading;

public class ShallowCloning {

    public static void main(String[] args)
    {
        EduCourse j2ee = new EduCourse("Java", "Spring", "Microservices");

        EduLearner learner1 = new EduLearner(2811, "Max", j2ee);

        EduLearner learner2 = null;

        try
        {
            //Creating a clone of learner1 and assigning it to learner2

            learner2 = (EduLearner) learner1.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        //Printing Details of Learner1
        System.out.println("Details of Learner 1: ");
        System.out.println("Id: "+learner1.eduId);
        System.out.println("Name: "+learner1.leaderName);
        System.out.println("Course Id: "+learner1.eduCourse);

        //Printing all the courses of 'learner1'
        System.out.println("Courses of Learner 1: ");
        System.out.println(learner1.eduCourse.course1);
        System.out.println(learner1.eduCourse.course2);
        System.out.println(learner1.eduCourse.course3);

        //Printing Details of Learner2
        System.out.println("Details of Learner 2: ");
        System.out.println("Id: "+learner2.eduId);
        System.out.println("Name: "+learner2.leaderName);
        System.out.println("Course Id: "+learner2.eduCourse);


        //Printing all the courses of 'learner2'
        System.out.println("Courses of Learner 2: ");
        System.out.println(learner2.eduCourse.course1);
        System.out.println(learner2.eduCourse.course2);
        System.out.println(learner2.eduCourse.course3);

        //Changing the course3 of 'learner2'
        learner2.eduCourse.course3 = "JSP";

        //This change will be reflected in original 'learner1'
        System.out.println("Updated Courses of Learner 2:");
        System.out.println(learner1.eduCourse.course1);
        System.out.println(learner1.eduCourse.course2);
        System.out.println(learner1.eduCourse.course3);
    }



}

class EduLearner implements Cloneable{
     int eduId;
     String leaderName;
     EduCourse eduCourse;


    public EduLearner(int eduId, String leaderBoard, EduCourse eduCourse) {
        this.eduId = eduId;
        this.leaderName = leaderBoard;
        this.eduCourse = eduCourse;
    }

    protected Object clone() throws CloneNotSupportedException{
        return  super.clone();
    }
}

class EduCourse {

    String course1;
    String course2;
    String course3;

    public EduCourse(String crs1, String crs2, String crs3)
    {
        this.course1 = crs1;

        this.course2 = crs2;

        this.course3 = crs3;
    }

}
