// Date - 18/06/26

// Answer - 1

import java.util.Scanner;

class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
    }
}

public class Main {
    static Node head = null, tail = null;

    static void display() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (!sc.hasNextInt()) break;
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    head = tail = null;
                    while (true) {
                        int val = sc.nextInt();
                        if (val == -1) break;
                        Node newNode = new Node(val);
                        if (head == null) head = tail = newNode;
                        else {
                            tail.next = newNode;
                            newNode.prev = tail;
                            tail = newNode;
                        }
                    }
                    System.out.println("LINKED LIST CREATED");
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    int d3 = sc.nextInt();
                    Node n3 = new Node(d3);
                    if (head == null) head = tail = n3;
                    else {
                        n3.next = head;
                        head.prev = n3;
                        head = n3;
                    }
                    System.out.println("The linked list after insertion at the beginning is:");
                    display();
                    break;
                case 4:
                    int d4 = sc.nextInt();
                    Node n4 = new Node(d4);
                    if (head == null) head = tail = n4;
                    else {
                        tail.next = n4;
                        n4.prev = tail;
                        tail = n4;
                    }
                    System.out.println("The linked list after insertion at the end is:");
                    display();
                    break;
                case 5:
                    int val5 = sc.nextInt(), d5 = sc.nextInt();
                    Node curr = head;
                    while (curr != null && curr.data != val5) curr = curr.next;
                    if (curr == null) System.out.println("Value not found in the list");
                    else if (curr == head) {
                        Node n5 = new Node(d5);
                        n5.next = head;
                        head.prev = n5;
                        head = n5;
                    } else {
                        Node n5 = new Node(d5);
                        n5.prev = curr.prev;
                        n5.next = curr;
                        curr.prev.next = n5;
                        curr.prev = n5;
                    }
                    System.out.println("The linked list after insertion before a value is:");
                    display();
                    break;
                case 6:
                    int val6 = sc.nextInt(), d6 = sc.nextInt();
                    curr = head;
                    while (curr != null && curr.data != val6) curr = curr.next;
                    if (curr == null) System.out.println("Value not found in the list");
                    else if (curr == tail) {
                        Node n6 = new Node(d6);
                        tail.next = n6;
                        n6.prev = tail;
                        tail = n6;
                    } else {
                        Node n6 = new Node(d6);
                        n6.next = curr.next;
                        n6.prev = curr;
                        curr.next.prev = n6;
                        curr.next = n6;
                    }
                    System.out.println("The linked list after insertion after a value is:");
                    display();
                    break;
                case 7:
                    if (head != null) {
                        head = head.next;
                        if (head != null) head.prev = null;
                        else tail = null;
                    }
                    System.out.println("The linked list after deletion from the beginning is:");
                    display();
                    break;
                case 8:
                    if (tail != null) {
                        tail = tail.prev;
                        if (tail != null) tail.next = null;
                        else head = null;
                    }
                    System.out.println("The linked list after deletion from the end is:");
                    display();
                    break;
                case 9:
                    int val9 = sc.nextInt();
                    curr = head;
                    while (curr != null && curr.data != val9) curr = curr.next;
                    if (curr == null || curr == head) System.out.println("Value not found in the list");
                    else {
                        Node target = curr.prev;
                        if (target == head) head = curr;
                        else target.prev.next = curr;
                        curr.prev = target.prev;
                    }
                    System.out.println("The linked list after deletion before a value is:");
                    display();
                    break;
                case 10:
                    int val10 = sc.nextInt();
                    curr = head;
                    while (curr != null && curr.data != val10) curr = curr.next;
                    if (curr == null || curr == tail) System.out.println("Value not found in the list");
                    else {
                        Node target = curr.next;
                        curr.next = target.next;
                        if (target == tail) tail = curr;
                        else target.next.prev = curr;
                    }
                    System.out.println("The linked list after deletion after a value is:");
                    display();
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Invalid option! Please try again");
            }
        }
    }
}


// Answer - 2

import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            Node newNode = new Node(score);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        if (head == null) return;

        int maxScore = head.data;
        Node temp = head;
        while (temp != null) {
            if (temp.data > maxScore) {
                maxScore = temp.data;
            }
            temp = temp.next;
        }

        System.out.println(maxScore);
        
        sc.close();
    }
}
