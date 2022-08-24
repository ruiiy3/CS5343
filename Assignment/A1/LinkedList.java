package com.company;

import java.util.Random;

public class LinkedList {
    public class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    private Node head;

    // new node add in the end
    public void insert(int value) {
        Node tmp = new Node(value);
        if (head == null)
            head = tmp;
        else {
            Node a = head;
            while(a.next != null) {
                a = a.next;
            }
            a.next = tmp;
        }
    }

    public void traverseList() {
        Node cur = head;
        if (cur == null)
            return;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void selectionSort() {
        Node cur = head;
        Node pre = null;
        while (cur.next != null) {

            Node tmp = cur;
            Node min = cur; // store min value node
            Node minpre = null;
            //find the min value
            while (tmp.next != null) {
                if (tmp.next.val < min.val) {
                    min = tmp.next;
                    minpre = tmp;
                }
                tmp = tmp.next;
            }
            // min != cur means need to swap, else move to next node
            if(min != cur) {
                if(pre == null) // first node
                    head = min;
                else
                    pre.next = min;

                minpre.next = cur;
                swapNode(min, cur);
            }
            cur = min.next;
            pre= min;
        }
    }
    //swap two nodes
    public void swapNode(Node a1, Node a2) {
        Node t = a1.next;
        a1.next = a2.next;
        a2.next = t;
    }
    public static void main(String[] args) throws Exception {

        Random rn = new Random();

        LinkedList result = new LinkedList();

        for (int i = 0; i < 15; i++) {
            result.insert(rn.nextInt(100));
        }

        System.out.println("List before sorting: ");
        result.traverseList();

        result.selectionSort();

        System.out.println("List after sorting: ");
        result.traverseList();

    }
}

