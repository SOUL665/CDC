// Date - 03/07/26

// Answer - 1

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int ways = countWays(n);
        System.out.println(ways);
        
        scanner.close();
    }
  public static int countWays(int n){
    if(n == 1){
        return 1;
    }
    if(n == 2){
        return 2;
    }
    return countWays(n - 1) + countWays(n - 2);
  }
}


// Answer - 2

import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void deleteMid(Stack<Integer> s, int n , int count){
        if(s.isEmpty()){
            return;
        }
        if(count == (n / 2)){
            s.pop();
            return;
        }
        int temp = s.pop();
        deleteMid(s, n, count + 1);
        s.push(temp);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()){
            return;
        }
        
        int n = sc.nextInt();
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++){
            s.push(sc.nextInt());
        }
        deleteMid(s, n, 0);
        while(!s.isEmpty()){
            System.out.print(s.pop() + (s.isEmpty() ? "" : " "));
        }
        System.out.println();
        sc.close();
    }
}

// Amswer - 3

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[] arr = new int[100];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int[] results = new int[100];
        for (int i = 0; i < n; i++) {
            results[i] = find_nearest_right_common_factor_recursive(arr, n, i, 1);
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(results[i] + (i == n-1 ? "\n" : " "));
        }
        
        scanner.close();
    }
  public static int gcd(int a , int b){
    if(b == 0){
        return a;
    }
    return gcd(b, a % b);
}
  
public static int find_nearest_right_common_factor_recursive(int[] arr, int n, int targetIdx, int currIdx){
    if(currIdx >= n){
        return -1;
    }
    if(gcd(arr[targetIdx], arr[currIdx]) > 1){
        return currIdx + 1;
    }
    
    return find_nearest_right_common_factor_recursive(arr, n, targetIdx, currIdx + 1);
  }
}

// Answer - 4

import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        
        if(isBalanced(expression)){
            System.out.println(expression + " - Balanced");
        }
        else{
            System.out.println(expression + " - Not Balanced");
        }
        
        sc.close();
    }
    
    public static boolean isBalanced(String expr){
        Stack<Character> stack = new Stack<>();
        
        for (char ch : expr.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

// Answer - 6

import java.util.Scanner;

public class Main{
    public static int productOfDivisors(int n, int i, int product){
        if(i == 0){
            return product;
        }
        if(n % i == 0){
            product *= i;
        }
        return productOfDivisors(n, i - 1, product);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        int result = productOfDivisors(n, n, 1);
        
        System.out.println(result);
        
        scanner.close();
    }
}
