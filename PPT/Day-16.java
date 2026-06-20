// Date - 20-06-26

// Answer - 1

import java.util.Scanner;
import java.util.Stack;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

Node top = null;

void push(int value){
    Node newNode = new Node(value);
    if(top != null){
        newNode.next = top;
    }
    top = newNode;
    System.out.println("Node is Inserted");
}

void pop(){
    if(top == null){
        System.out.println("EMPTY STACK");
        return;
    }
    System.out.println("Popped Element: " + top.data);
    top = top.next;
}

void display(){
    if(top == null){
        System.out.println("EMPTY STACK");
        return;
    }
    System.out.println("The stack is: ");
    Node temp = top;
    while (temp != null){
        System.out.print(temp.data);
        if(temp.next != null){
            System.out.print(" ");
        }
        temp = temp.next;
    }
    System.out.println();
}

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, value;

        while (true) {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    value = sc.nextInt();
                    push(value);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}


// Answer - 2

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.btin);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        
        int targetIndex = n / 2;
        
        deleteMiddle(stack, n, targetIndex);
        
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    
    private static void deleteMiddle(Stack<Integer> stack, int n, int curr) {
        if (curr == 0) {
            stack.pop();
            return;
        }
        int x = stack.pop();
        deleteMiddle(stack, n, curr - 1);
        stack.push(x);
    }
}
