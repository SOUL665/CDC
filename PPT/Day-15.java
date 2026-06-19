// Date - 20/06/26


// Answer - 1

import java.util.Scanner;
import java.util.Arrays;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] productIds = new int[n];

        for (int i = 0; i < n; i++) {
            productIds[i] = sc.nextInt();
        }

        Node head = null;
        Node tail = null;

        for (int id : productIds) {
            Node newNode = new Node(id);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        tail.next = head;

        Arrays.sort(productIds);

        for (int i = 0; i < n; i++) {
            System.out.print(productIds[i] + " ");
        }
    }
}


// Answer - 2

import java.util.Scanner;

class Node {
    int data;
    Node next;

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
            Node newNode = new Node(sc.nextInt());
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        if (tail != null) tail.next = head;

        int k = sc.nextInt();

        if (k == 1) {
            if (head.next == head) {
                head = null;
            } else {
                head = head.next;
                tail.next = head;
            }
        } else {
            Node curr = head;
            for (int i = 1; i < k - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }

        if (head != null) {
            Node temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
        }
    }
}
