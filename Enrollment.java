import java.util.PriorityQueue;


public class Enrollment {
    public static void main(String[] args) {
        
        PriorityQueue<student> studentNN = new PriorityQueue<>((st1,st2)-> Integer.compare(st1.getEnrollmentNumber(), st2.getEnrollmentNumber()));
        
        student st_1 = new student("Wendell",467224);
        student st_2 = new student("Wendell",124567);
        student st_3 = new student("Wendell",345236);
        student st_4 = new student("Wendell",446378);
        student st_5 = new student("Wendell",789536);
        student st_6 = new student("Wendell",256788);
        
        studentNN.add(st_1);
        studentNN.add(st_2);
        studentNN.add(st_3);
        studentNN.add(st_4);
        studentNN.add(st_5);
        studentNN.add(st_6);
        
        while(!studentNN.isEmpty()){
            student st = studentNN.poll();
            System.out.println("Enrollment Number: " + st.getEnrollmentNumber() + ", Name: " + st.getName());
        }
        
    }
}

class student{
    private String name;
    private int enrollmentNumber;

    public student(String name, int enrollmentNumber){
        this.name = name;
        this.enrollmentNumber = enrollmentNumber;
    }

    public String getName(){
        return name;
    }

    public int getEnrollmentNumber(){
        return enrollmentNumber;
    }
}
