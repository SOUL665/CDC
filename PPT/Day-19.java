// Date - 22-06-26

// Answer - 1 

import java.util.Scanner;

public class Main{
    public static void printMaxSubarrayInfo(int[] arr, int n){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0, end = 0, tempStart = 0;
        
        for (int i = 0; i < n; i++){
            currentSum += arr[i];
            
            if (currentSum > maxSum){
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
            
            if(currentSum < 0){
                currentSum = 0;
                tempStart = i + 1;
            }
        }
        
        int count = end - start + 1;
        double average = (double) maxSum / count;
        
        System.out.println("Max Sum: " + maxSum);
        System.out.println("Count: " + count);
        System.out.printf("Average: %.2f\n",  average);
    }
    
    public static void countPositiveSegments(int[] arr, int n){
        int segments = 0;
        boolean inSegment = false;
        
        for(int i = 0; i < n; i++){
            if(arr[i] > 0){
                if(!inSegment){
                    segments++;
                    inSegment = true;
                }
            }
            else{
                inSegment = false;
            }
        }
        System.out.println("Segments: " + segments);
    }
        
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
            
        if(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
                
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
                
            printMaxSubarrayInfo(arr, n);
            countPositiveSegments(arr, n);
        }
        sc.close();
    }
}


// Answer - 2

import java.util.Scanner;

public class Main{
    public static void printSubarrayDetails(int[] arr, int n){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0, end = 0,tempStart = 0;
        
        for(int i = 0; i < n; i++){
            currentSum += arr[i];
            
            if (currentSum > maxSum){
                maxSum = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        
        for(int i = start; i <= end; i++){
            System.out.print(arr[i] + (i == end ? "" : " "));
        }
        System.out.println();
    }
    public static int maxSubarraySum(int[] arr, int n){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for(int i = 0; i < n; i++){
            currentSum += arr[i];
            
            if (currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            
            printSubarrayDetails(arr, n);
            int result = maxSubarraySum(arr, n);
            System.out.println("Max Sum: " + result);
        }
        sc.close();
    }
}
