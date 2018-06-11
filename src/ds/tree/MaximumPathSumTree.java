package ds.tree;

public class MaximumPathSumTree<T> {

    Node<T> root;

    public static void main(String[] args) {
        MaximumPathSumTree<Integer> maximumPathSumTree = new MaximumPathSumTree<>();
        maximumPathSumTree.root = new Node<Integer>(10);
        maximumPathSumTree.root.left = new Node<Integer>(2);
        maximumPathSumTree.root.left.left = new Node<Integer>(20);
        maximumPathSumTree.root.left.right = new Node<Integer>(1);
        maximumPathSumTree.root.right = new Node<Integer>(10);
        maximumPathSumTree.root.right.right = new Node<Integer>(-25);
        maximumPathSumTree.root.right.right.left = new Node<Integer>(3);
        maximumPathSumTree.root.right.right.right = new Node<Integer>(4);
        maximumPathSumTree.maximumPathSum(maximumPathSumTree.root, 0);
    }

    public Integer maximumPathSum(Node<T> root, Integer res) {
        int sumOfLSubTree = 0;
        int sumOfRSubTree = 0;
        if(root.left!= null){
            sumOfLSubTree = maximumPathSum(root.left, res);
        }
        if(root.right != null){
            sumOfRSubTree = maximumPathSum(root.right, res);
        }
        res = findMaxSum(root, sumOfLSubTree, sumOfRSubTree);
        return res;
    }

    private int findMaxSum(Node<T> curr, Integer sumLeft, Integer sumRight){
        int maxSingle = Math.max(Math.max(sumLeft,sumRight)+curr.data,curr.data);
        int maxTop = Math.max(maxSingle, sumLeft+sumRight+curr.data);
        return Math.max(maxSingle,maxTop);
    }

    static class Node<T> {
        Integer data;
        Node<T> left;
        Node<T> right;

        public Node(Integer data) {
            this.data = data;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

}
