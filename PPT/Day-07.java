// Date - 12/06/26

// Answer - 1

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        int[] values = new int[n];
        for(int i = 0 ; i < n ; i++){
            values[i] = sc.nextInt();
        }
        int[] weights = new int[n];
        for(int i = 0 ; i < n; i++){
            weights[i] = sc.nextInt();
        }
        
        int capacity = sc.nextInt();
        
        int[][] dp = new int[n + 1][capacity + 1];
        for(int i = 1; i <= n ; i++){
            for(int j = 0 ; j <= capacity; j++){
                if(weights[i - 1] <= j){
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]] , dp[i -1][j]);
                }
                else{
                    dp[i][j] = dp[i -1][j];
                }
            }
        }
        System.out.print(dp[n][capacity]);
    }
}


// Asnwer - 2

import java.util.*;

public class Main{
    static class Job{
        int start , finish , profit;
        Job(int start , int finish , int profit){
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        for(int i = 0 ; i < n; i++){
            jobs[i] = new Job(sc.nextInt() , sc.nextInt() , sc.nextInt());
        }
        Arrays.sort(jobs , (a,b) -> Integer.compare(a.finish , b.finish));
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        
        for (int i = 1; i < n; i++){
            int currentProfit = jobs[i].profit;
            int lastNonOverlapping = -1;
            for(int j = i - 1; j >= 0 ; j--){
                if(jobs[j].finish <= jobs[i].start){
                    lastNonOverlapping = j;
                    break;
                }
            }
            
            if (lastNonOverlapping != -1){
                currentProfit += dp[lastNonOverlapping];
            }
            
            dp[i] = Math.max(currentProfit , dp[i - 1]);
        }
        System.out.print("The optimal profit is " + dp[n - 1]);
    }
}
