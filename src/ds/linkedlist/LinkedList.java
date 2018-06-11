package ds.linkedlist;

import java.util.Scanner;

class LinkedList
{
    Node head;  // head of list
    /* Linked list Node*/
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node & Put in the data*/
        Node new_node = new Node(new_data);
        /* 3. Make next of new Node as head */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    /* Drier program to test above functions */
    public static void main(String args[])
    {
        int t,d,n,i,x,c;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        for(d=0;d<t;d++){
            n=sc.nextInt();
            LinkedList llist = new LinkedList();
            Node q;
            for(i=0;i<n;i++){
                x=sc.nextInt();
                llist.push(x);}
            Node p;
            p=llist.head;
            q=llist.head;
            while(q.next!=null)
                q=q.next;
            c=sc.nextInt();
            if(c>0){
                c=c-1;
                for(i=0;i<c;i++){
                    p = p.next;}
                q.next=p;
            }
            if(detectLoop(llist.head)==1)
                System.out.print("True\n");
            else
                System.out.print("False\n");
            System.gc();
        }
    }

    private static int detectLoop(Node head) {
        Node fast = head.next.next;
        Node slow = head.next;
        while((slow != null && slow.next != null)
                && (fast != null && fast.next != null)){
            fast = fast.next.next;
            if(fast.equals(slow)){
                return 1;
            }
            slow = slow.next;
        }
        return 0;
    }

    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
}