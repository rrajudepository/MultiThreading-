package DSAPractice.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ll {
    static Node head=null;
    static Node tail=null;

    public static void push_front(int data){
        Node curr = new Node(data);
        if(head == null){
           head = tail = curr;
        }else{
            curr.next = head;
            head = curr;
        }
    }

    public static void push_back(int data){
        Node curr = new Node(data);
        if(head == null){
            head = tail = curr;
        }else{
            tail.next = curr;
            tail=curr;
        }
    }

    public static void pop_front(){
        if(head == null){
            System.out.println("LinkedlIst is empty");
        }else{
           Node curr = head;
           head = head.next;
           curr.next= null;
        }
    }

    public static void pop_back(){
        if(head == null){
            System.out.println("LinkedList is empty");
        }else if(head == tail){
            head = null;
            tail = null;
        }else{
            Node curr = head;
            while(curr.next!=tail){
                curr= curr.next;
            }
            curr.next = null;
            tail = curr;
        }
    }

    public static void printLinkedList(){
        if(head == null){
            System.out.println("LinkedList is empty");
        }else{
            Node curr = head;
            while(curr!=null){
                System.out.print(curr.data+" -> ");
                curr = curr.next;
            }
            System.out.println("null\n");
        }
    }

    public static int middleElement(){
        if(head==null){
            System.out.println("LL is empty");
            return -1;
        }else{
            Node slow = head;
            Node fast = head;
            while(slow!=null && fast != null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }

        
    }

    public static void reverseLinkedlist(){
        Node prev = null;
        Node curr = head;
        Node next = null;
        Node tail2 = head;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        tail = tail2;

    }

    public static void main(String[] args) {
        List<Integer> value = new ArrayList<>();
        Collections.addAll(value, 1,2,3,4,5,6,7,8,9,10);

        for(int val : value){
            push_front(val);
        }
        System.out.println("Printing linked list");
        printLinkedList();

        push_back(11);
        System.out.println("Printing linked list after inserting 11 at the end");
        printLinkedList();

        pop_back();
        System.out.println("Printing linked list after pop back");
        printLinkedList();

        pop_front();
        System.out.println("Printing linked list after pop front");
        printLinkedList();

        int val = middleElement();
        
        if(val != -1){
           System.out.println("middle element of linkedlist is: "+ val);
        }else{
           System.out.println("Linked List is empty");
        }

        push_back(12);
        System.out.println("Printing linked list after inserting 12 at the end");
        printLinkedList();

        val = middleElement();
        
        if(val != -1){
           System.out.println("middle element of linkedlist is: "+ val);
        }else{
           System.out.println("Linked List is empty");
        }

        System.out.println("After reversing the linked list: ");
        reverseLinkedlist();
        printLinkedList();


    }
}
