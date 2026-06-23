// Date - 23-06-26

// Answer - 1

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        if(!sc.hasNextInt()) return;
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        
        int[][] matrix1 = new int[r1][c1];
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c1; j++){
                matrix1[i][j] =sc.nextInt();
            }
        }
        
        if(!sc.hasNextInt()) return;
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        
        int[][] matrix2 = new int[r2][c2];
        for(int i = 0; i < r2; i++){
            for(int j = 0; j < c2; j++){
                matrix2[i][j] =sc.nextInt();
            }
        }
        
        if(c1 != r2){
            System.out.print("Matrix multiplication not possible");
            return;
        }
        
        int[][] result = new int[r1][c2];
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c2; j++){
                for(int k = 0; k < c1; k++){
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c2; j++){
                System.out.print(result[i][j]);
                if(j < c2 - 1){
                    System.out.print(" ");
                }
            }
            if(i < r1 - 1){
                System.out.println();
            }
        }
    }
}


// Answer - 2

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        if(!sc.hasNextInt()) return;
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        int[][] matrix = new int[r][c];
        int maxSum = Integer.MIN_VALUE;
        int targetRowIndex = -1;
        
        for(int i = 0; i < r; i++){
            int currentSum = 0;
            for(int j = 0; j < c; j++){
                matrix[i][j] = sc.nextInt();
                currentSum += matrix[i][j];
            }
            
            if(currentSum > maxSum){
                maxSum = currentSum;
                targetRowIndex = i;
            }
        }
        
        for(int i = 0; i < r; i++){
            if(i == targetRowIndex){
                continue;
            }
            for(int j = 0; j < c; j++){
                System.out.print(matrix[i][j]);
                if(j < c - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
