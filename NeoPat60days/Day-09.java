// Date = 11/06/26
// DSA 
// Answer - 1

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] days = new int[n];
        int[] months = new int[n];
        int[] years = new int[n];
        
        for (int i = 0; i < n; i++) {
            days[i] = scanner.nextInt();
            months[i] = scanner.nextInt();
            years[i] = scanner.nextInt();
        }

for(int i =0; i< n - 1 ; i++){
    int minIndex = i;
    for(int j = i + 1 ; j < n; j++){
        if(years[j] < years[minIndex]){
            minIndex = j;
        }
        else if (years[j] == years[minIndex]){
            if (months[j] < months[minIndex]){
                minIndex = j;
            }
            else if (months[j] == months[minIndex]){
                if(days[j] < days[minIndex]){
                    minIndex = j;
                }
            }
        }
    }
    
    int tempYear = years[minIndex];
    years[minIndex] = years[i];
    years[i] = tempYear;
    
    int tempMonth = months[minIndex];
    months[minIndex] = months[i];
    months[i] = tempMonth;
    
    int tempDay = days[minIndex];
    days[minIndex] = days[i];
    days[i] = tempDay;
}
        for (int i = 0; i < n; i++) {
            System.out.printf("%d %d %d\n", days[i], months[i], years[i]);
        }
        
        scanner.close();
    }
}


// Fundamentals

// Answer - 1

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int n = sc.nextInt();
            if(neon(n) == 1){
                System.out.println(n + " is a neon number");
            }
            else{
                System.out.println(n + "is not a neon number");
            }
        }
        sc.close();
    }
    
    public static int neon(int n){
        int square = n * n;
        int sum = 0;
        
        if (square == 0 && n == 0){
            return 1;
        }
        
        while(square > 0){
            sum += square % 10;
            square /= 10;
        }
        if(sum == n){
            return 1;
        }
        else{
            return 0;
        }
    }
}

// Answer - 2

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n-1];
            for(int i =0; i<n-1; i++){
                arr[i] = sc.nextInt();
            }
            
            System.out.print(findMissingNumber(arr,n));
        }
        sc.close();
    }
    
    public static int findMissingNumber(int arr[] , int n){
        int d = (arr[n-2] - arr[0])/(n-1);
        int low = 0, high = n-2;
        int res = -1;
        
        while (low <= high){
            int mid = low + (high - low)/2;
            
            if(arr[mid] == arr[0] + mid*d){
                low = mid + 1;
            }
            else {
                res = arr[0] + mid*d;
                high = mid - 1;
            }
        }
        return res;
    }
}
