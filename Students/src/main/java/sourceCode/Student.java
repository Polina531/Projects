package sourceCode;

public class Student {

public final String id;
static int count = 0;

public Student() {
    count++;
    this.id = "st" + count;
    
}

public synchronized void exam(Prof prof, String room) {
    
    if (prof.q.isEmpty()) {
        String student = id;
        prof.q.add(student);
        System.out.println("student " + student + " entered " + room);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        prof.passed.add(student);
        prof.q.remove(student);
        
        System.out.println("student " + student + " passed " + room);
    }
    
}
}
