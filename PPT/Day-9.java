// Date - 14/06/26

// Answer - 1

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }
        
        if(!sc.hasNextInt()) return;
        int m = sc.nextInt();
        
        long[] dp = new long[m + 1];
        dp[0] = 1;
        
        for (int coin : coins){
            for (int i = coin; i <= m; i++){
                dp[i] += dp[i - coin];
            }
        }
        
        System.out.println(dp[m]);
    }
}

// Answer - 2

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        int s = (n + 24) / 25;
        
        double[][] dp = new double[s + 1][s + 1];
        dp[s][s] = 1.0;
        
        double probAEmptyFirst = 0;
        double probBothEmpty = 0;
        
        for (int i = s; i >= 0; i--){
            for(int j = s; j >=0; j--){
                if (dp[i][j] == 0) continue;
                
                int[][] ops = {{4, 0}, {3, 1}, {2, 2}, {1, 3}};
                
                for (int[] op : ops){
                    int nextI = Math.max(0, i - op[0]);
                    int nextJ = Math.max(0, j - op[1]);
                    
                    if(nextI == 0 && nextJ == 0){
                        probBothEmpty += dp[i][j] * 0.25;
                    }
                    else if(nextI == 0){
                        probAEmptyFirst += dp[i][j] * 0.25;
                    }
                    else if(nextJ == 0){
                        
                    }
                    else {
                        dp[nextI][nextJ] += dp[i][j] * 0.25;
                    }
                }
            }
        }
        
        double result = probAEmptyFirst + 0.5 * probBothEmpty;
        System.out.printf("%.3f\n", result);
    }
}
