// Answer - 1

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        double sumOfSquares = 0;
        for(int i = 0; i < n * n; i++){
            if(sc.hasNextInt()){
                int element = sc.nextInt();
                sumOfSquares += (double) element * element;
            }
        }
        int normal = (int) Math.sqrt(sumOfSquares);
        System.out.println(normal);
        
        sc.close();
    }
}

// Answer - 2

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();
        
        String[] words = new String[n];
        for(int i = 0; i < n; i++){
            words[i] = sc.nextLine().trim();
        }
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        for(int i = 0; i < n; i++){
            System.out.print(words[i]);
            if(i < n - 1){
                System.out.print(" ");
            }
        }
        System.out.println();
        sc.close();
    }
}
