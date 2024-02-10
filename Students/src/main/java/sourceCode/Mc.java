package sourceCode;


import java.util.ArrayList;
import java.util.List;


public class Mc {

public static List<Student> students = new ArrayList<>();

public static void main(String[] args) {
    

    
    for (int i = 0; i < 5; i++) {
        students.add(new Student());
    }
    
    Prof prof1 = new Prof();
    Prof prof2 = new Prof();
    Prof prof3 = new Prof();
    
    
    Runnable room1 = () -> {
        int count = 0;
        for (Student st : students) {
            st.exam(prof1, "room1");
            count++;
        }
        System.out.println("passed room1: " + count);
    };
    
    Runnable room2 = () -> {
        int count = 0;
        for (Student st : students) {
            st.exam(prof2, "room2");
            count++;
        }
        
        System.out.println("passed room2: " + count);
    };
    
    Runnable room3 = () -> {
        int count = 0;
        for (Student st : students) {
            st.exam(prof3, "room3");
            count++;
        }
        
        System.out.println("passed room3: " + count);
    };

    Thread thread1 = new Thread(room1);
    Thread thread2 = new Thread(room2);
    Thread thread3 = new Thread(room3);

    thread1.start();
    thread2.start();
    thread3.start();
    
    
}

}
