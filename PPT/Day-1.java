// Answer - 1

import java.util.Scanner;
import java.util.HashSet;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        if(isHappy(n)){
            System.out.print(n + "is a Happy number");
        }
        else{
            System.out.print(n + "is not a Happy number");
        }
    }
    
    private static boolean isHappy(int n ){
        HashSet<Integer> seen = new HashSet<>();
        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            int sum = 0;
            while(n > 0){
                int digit = n % 10;
                sum +=digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}

// Answer - 2

import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1 ; i <= n; i++){
            for(int j = 1 ; j * j <= i; j++){
                if(dp[i-j*j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-j*j] + 1);
                }
            }
        }
        System.out.print(dp[n]);
    }
}
