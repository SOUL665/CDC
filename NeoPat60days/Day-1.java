// Answer - 1

import java.util.*;
class Main{
    public static void main(String[] a){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),arr[]= new int[n];
        for(int i=0;i<n;i++)arr[i]=s.nextInt();
        for(int i=n-2;i>=0;i--)System.out.print(arr[i]+"");
    }
}

// Answer - 2 

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int n = sc.nextInt();
            long result = (long) n*(n-1)/2;
            System.out.print(result);
        }
        sc.close();
    }
}

