package ignore;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Arrays.deepToString;
import static java.util.Collections.fill;


public class Animation {

    private static char[][] donut =
            {{' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' '},
            {' ', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', ' '},
            {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
            {' ', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', ' '},
            {' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' '}};
    

public static void main(String[] args) {
    int count = 0;
    display();
    
    for (int i=0; i<3; i++) {
        shrinkLeft(count);
        expandRight(count);
//        expandLeft(count);
        shrinkRight(count);
        
        display();
        
        count++;
    }
    for (int i=0; i<2; i++) {
        shrinkLeft(count);
        expandRight(count);
        expandLeft(count);
        shrinkRight(count);
        
        display();
        
        count++;
    }
    
    
}


    public static void display() {
//        clearScreen();
        for (char[] i : donut) {
            
            for (char j : i) {
                System.out.print(j);
            }
            
            System.out.println();
            
        }

    }

    public static void shrinkLeft(int op) {
        for (char[] i : donut) {
            i[op] = ' ';
            
        }
    
    }

    public static void expandRight(int op) {
        int count = 6 + op;
        for (char[] i : donut) {
            i[18-count] = '*';
            
        }
        
    }

    public static void shrinkRight(int op) {
        for (char[] i : donut) {
            i[18-op] = ' ';
            
        }
        
    }

    public static void expandLeft(int op) {
        int count = 6 + op;
        for (char[] i : donut) {
            i[count] = '*';
            
        }
        
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}