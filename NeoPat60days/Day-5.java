// DSA 
// Answer - 1

import java.util.Scanner;

class Node{
    String appName;
    Node next;
    
    Node(String appName){
        this.appName = appName;
        this.next = null;
    }
}

class CircularLinkedList{
    Node head = null;
    Node tail = null;
    
    public void addNote(String appName) {
        Node newNode = new Node(appName);
        if(head == null){
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else{
            tail.next = newNode;
            tail = newNode;
            tail.next =head;
        }
    }
    
    public void display(){
        System.out.println("Circular Linked list - Running Applications");
        if (head == null){
            System.out.println("No applications to iterate.");
            return;
        }
        
        System.out.println("Running Applications:");
        Node current = head;
        do{
            System.out.println(current.appName);
            current = current.next;
        }
        while(current != head);
    }
}

public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList cll = new CircularLinkedList();
        boolean hasApps = false;
        
        while(sc.hasNextLine()){
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("exit")){
                break;
            }
            if (!input.isEmpty()){
                cll.addNote(input);
                hasApps = true;
            }
        }
        
        if (!hasApps){
            System.out.println("Circular Linked List - Running Applications");
            System.out.println("No applications to iterate.");
        }
        else{
            cll.display();
        }
        sc.close();
    }
}


// Fundamentals

// Answer - 1

import java.util.Scanner;

public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        if(sc.hasNextInt()){
            int m = sc.nextInt();
            int count = 0 ;
            
            while (count <m){
                if(sc.hasNextInt()){
                    int x = sc.nextInt();
                    if (sc.hasNextInt()){
                        int y = sc.nextInt();
                        int totalGap = x + y;
                        int ratio = (x*100)/totalGap;
                        
                        System.out.println(totalGap + " seconds");
                        
                        System.out.println("Time Gap Ratio:" + ratio + "%");
                    }
                }
                count++;
            }
        }
        sc.close();
    }
}

// Answer - 2

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int n = sc.nextInt();
            if (n <= 0){
                System.out.println(n + "is not a perfect number");
            }
            else if (n == 1){
                System.out.println("1 is not a perfect number");
            }
            else{
                int sum = 0;
                int i = 1;
                
                do{
                    if (n % i == 0){
                        sum += i;
                    }
                    i++;
                } while(i < n);
                
                if (sum == n){
                   System.out.println(n + " is a perfect number"); 
                } else {
                    System.out.println(n + " is not a perfect number");
                }
            }
        }
        sc.close();
    }
}

