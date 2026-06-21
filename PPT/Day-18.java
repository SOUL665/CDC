// Date - 22-06-26

// Answer - 1

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] users = new int[n];
        
        for(int i = 0; i < n; i++){
            users[i] = sc.nextInt();
        }
        
        long currentSum = 0;
        for(int i = 0; i < k; i++){
            currentSum += users[i];
        }
        long maxSum = currentSum;
        
        for (int i = k; i < n; i++){
            currentSum = currentSum - users[i - k] + users[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        System.out.println(maxSum);
    }
}


// Answer - 2

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] steps = new int[n];
        
        for(int i = 0; i < n; i++){
            steps[i] = sc.nextInt();
        }
        
        long currentSum = 0;
        for(int i = 0; i < k; i++){
            currentSum += steps[i];
        }
        long maxSum = currentSum;
        
        for(int i = k; i < n; i++){
            currentSum = currentSum - steps[i - k] + steps[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        System.out.println(maxSum);
    }
}
