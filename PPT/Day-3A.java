// Anwer - 1

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        
        int target = sc.nextInt();
        
        int left = 0;
        int right = cols - 1;
        boolean found = false;
        
        while(left < cols && right >= 0){
            int val1 = matrix[0][left];
            int val2 = matrix[rows - 1][right];
            
            int currentSum = val1 + val2;
            
            if(currentSum == target){
                System.out.println(val1 + "" + val2);
                found = true;
                left++ ; 
                right-- ; 
            }
            
            else if (currentSum < target){
                left++ ;
            }
            
            else{
                right-- ;
            }
        }
        
        if (!found){
            System.out.println("No pairs found");
        }
        sc.close();
    }
}
