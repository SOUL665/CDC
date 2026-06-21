// Date - 21-06-26

// Answer - 1

import java.util.Scanner ;
import java.util.LinkedList ;
import java.util.Queue ;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()){
            return;
        }
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        
        int sum = 0;
        int evenCount = 0;
        int oddCount = 0;
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            queue.add(arr[i]);
            sum += arr[i];
            if(arr[i] % 2 == 0){
                evenCount++;
            }
            else{
                oddCount++;
            }
        }
        System.out.println("Averages of pairs:");
        for(int i = 0; i < n; i++){
            int current = arr[i];
            int next = arr[(i + 1) % n];
            double avg = (current + next) / 2.0;
            System.out.print(avg);
            if(i < n - 1){
                System.out.print(" ");
            }
        }
        System.out.println();
        
        System.out.println("Sum of all elements: " + sum);
        System.out.println("Number of even elements: " + evenCount);
        System.out.println("Number of odd elements: " + oddCount);
        sc.close();
    }
}


// Answer - 2

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()){
            return;
        }
        
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        double runningSum = 0;
        
        for(int i = 0; i < n; i++){
                int price = sc.nextInt();
                queue.add(price);
                runningSum += price;
                
                double movingAverage = runningSum / queue.size();
                System.out.printf("%.2f", movingAverage);
                
                if(i < n - 1){
                    System.out.print(" ");
                }
        }
        System.out.println();
        sc.close();
    }
}
