// Date - 17/06/26

// Answer - 1

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String s = sc.next();
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String p1 = expand(s, i, i);
            String p2 = expand(s, i, i + 1);
            if (p1.length() > longest.length()) longest = p1;
            if (p2.length() > longest.length()) longest = p2;
        }
        System.out.println(longest);
    }

    private static String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}

// Answer - 2

import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int firstRepeating = -1;
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(arr[i])) {
                firstRepeating = arr[i];
            } else {
                set.add(arr[i]);
            }
        }
        
        if (firstRepeating != -1) {
            System.out.println("The first repeating element is " + firstRepeating);
        } else {
            System.out.println("There are no repeating elements");
        }
    }
}
