package ds.tree;

public class TernaryToTree<T> {


    //a?b:c
//    public Node<Character> getTreeFromTernary(String ternaryExpression){
//        Node<Character> root = new Node<>();
//        root.data = ternaryExpression.charAt(0);
//        for (int i = 1; i < ternaryExpression.length(); i++) {
//            if(ternaryExpression.charAt(i) == '?' || ternaryExpression.charAt(i) == ':'){
//                continue;
//            } else {
//
//            }
//        }
//    }


    class Node<T>{
        T data;
        Node<T> left;
        Node<T> right;
    }
}
