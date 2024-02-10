package ignore;

import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        do {
            
            System.out.println(":  ");
            int n = s.nextInt();
            
            
            String result = "";
            
            result = n % 2 == 0 ? "even" : "not even";
            
            System.out.println(result);
            
        } while (true);

    }
    
}
