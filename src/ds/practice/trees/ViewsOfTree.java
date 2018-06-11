package ds.practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ViewsOfTree {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(4);
        root.left = new Node<>(2);
        root.right = new Node<>(1);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(10);
        root.right.left = new Node<>(12);
        root.right.right = new Node<>(24);
        printLeftView(root);

    }


    public static void printLeftView(Node<Integer> root) {
        if(root==null)
            return;
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        q.add(null);
        boolean isFirst=true;
        while(!q.isEmpty()){
            Node temp=q.peek();
            q.poll();
            if(isFirst&&temp!=null){
                System.out.print(temp.data+" ");
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
                isFirst=false;
            }
            else if(temp==null && q.size()>1){
                isFirst=true;
                q.add(null);
            }
            else if(temp!=null){
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
        }
    }
}
