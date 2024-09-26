package LinkedListDemo;

public class Node {

    int info;
    Node left;
    Node right;

    Node() {
    }

    Node(int x, Node left, Node right) {
        this.info = x;
        this.left = left;
        this.right = right;
    }

    Node(int x) {
        this(x, null, null);
    }
}
