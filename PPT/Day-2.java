// Answer - 1

import java.util.Scanner;

public class Main{
    public static int floorSearch(int[] arr , int n , int x){
        return findFloor(arr , 0 , n-1 , x);
}
private static int findFloor(int[] arr , int low , int high , int x){
    if(low > high){
        return high;
    }
    
    int mid = low + (high - low) / 2 ;
    
    if (arr[mid] == x){
        return mid;
    }
    
    if(arr[mid] < x){
        return findFloor(arr , mid + 1 , high , x);
    }
    
    return findFloor(arr , low , mid - 1 , x);
    }

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int x = scanner.nextInt();

        int index = floorSearch(arr, n, x);

        if (index == -1)
            System.out.println("No closest item with an ID less than or equal to " + x + " exists in the warehouse");
        else
            System.out.println("The closest item ID less than or equal to " + x + " is " + arr[index]);

        scanner.close();
    }
}
