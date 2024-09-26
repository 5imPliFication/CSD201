package LinkedListDemo;

import java.util.LinkedList;

/**
 *
 * @author Simplification
 */
public class MyBSTree {

    Node root;

    public MyBSTree() {

    }

    public void clear() {
        this.root = root;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void visit(Node v) {
        System.out.println(v.info + " ");
    }

    public class myQueue {

        LinkedList<Node> queue;

        public myQueue() {
            this.queue = new LinkedList<Node>();
        }

        public void clearQueue() {
            this.queue.clear();
        }

        public boolean isQueueEmpty() {
            return this.queue.isEmpty();
        }

        public void enqueue(Node v) {
            this.queue.addLast(v);
        }

        public Node dequeue() {
            if (isEmpty()) {
                return null;
            }
            Node v = this.queue.removeFirst();
            return v;
        }

        public Node front() {
            if (isEmpty()) {
                return null;
            }
            return this.queue.getFirst();
        }
    }

    public void insert(int x) {
        if (isEmpty()) {
            System.out.println("Insert root: " + x);
            Node newNode = new Node(x);
            root = newNode;
        }
        Node curr;
        Node parentOfCurr;
        curr = root;
        parentOfCurr = null;
        while (curr != null) {
            if (curr.info == x) {
                System.out.println("The key " + x + " already exists");
                return;
            }
            parentOfCurr = curr;
            if (x < curr.info) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        Node newNode = new Node(x);
        if (x < parentOfCurr.info) {
            System.out.println("Insert " + parentOfCurr.info + ".left " + x);
            parentOfCurr.left = newNode;
        } else {
            System.out.println("Insert " + parentOfCurr.info + ".right " + x);
            parentOfCurr.right = newNode;
        }
        return;
    }

    public void insertMany(int[] x) {
        if (isEmpty()) {
            System.out.println("Insert root: " + x);
            Node newNode = new Node(x[0]);
            root = newNode;
            return;
        }
        for (int i = 0; i < x.length; i++) {
            insert(x[i]);
        }
    }

    public void preOrder(Node v) {
        if (v == null) {
            return;
        }
        visit(v);
        preOrder(v.left);
        preOrder(v.right);

    }

    public void inOrder(Node v) {
        if (v == null) {
            return;
        }
        inOrder(v.left);
        visit(v);
        inOrder(v.right);
    }

    public void postOrder(Node v) {
        if (v == null) {
            return;
        }
        postOrder(v.left);
        postOrder(v.right);
        visit(v);
    }

    public void breadthFirst() {
        if (root == null) {
            return;
        }
        myQueue q = new myQueue();
        q.enqueue(root);
        Node v;
        while (!q.isQueueEmpty()) {
            v = (Node) q.dequeue();
            if (v.left != null) {
                q.enqueue(v.left);
            }
            if (v.right != null) {
                q.enqueue(v.right);
            }
            visit(v);
        }
    }

    public void deleteByMerging(int x) {
        //Check if empty
        if (isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }
        //search node needed to be delete
        Node deleteNode;
        Node pOfDeleteNote;
        deleteNode = root;
        pOfDeleteNote = null;
        while (deleteNode != null) {
            if (deleteNode.info == x) {
                break; //found the node need to be deleted = x
            }
            //continue searching
            if (x < deleteNode.info) {
                pOfDeleteNote = deleteNode;
                deleteNode = deleteNode.left;
            } else {
                pOfDeleteNote = deleteNode;
                deleteNode = deleteNode.right;
            }
        }
        //check if found x
        if (deleteNode == null) {
            System.out.println("Key " + x + " does not exist");
            return;
        }
        //Case 1: delete leaf node 

        if (deleteNode.left == null && deleteNode.right == null) {
            //check if delete node is root
            if (pOfDeleteNote == null) {
                root = null;
            } else {
                if (pOfDeleteNote.left == deleteNode) {
                    pOfDeleteNote.left = null;
                } else {
                    pOfDeleteNote.right = null;
                }
            }
            return;
        }

        //Case 2:delete node has only left child
        if (deleteNode.left == null && deleteNode.right == null) {
            //check if root
            if (pOfDeleteNote == null) {
                root = deleteNode.left;
            } else {
                if (pOfDeleteNote.left == deleteNode) {
                    pOfDeleteNote.left = deleteNode.left;
                } else {
                    pOfDeleteNote.right = deleteNode.left;
                }
            }
            deleteNode.left = null;
            return;
        }

        //Case 3:delete node has only right child
        if (deleteNode.left == null && deleteNode.right == null) {
            //check if root
            if (pOfDeleteNote == null) {
                root = deleteNode.right;
            } else {
                if (pOfDeleteNote.left == deleteNode) {
                    pOfDeleteNote.left = deleteNode.right;
                } else {
                    pOfDeleteNote.right = deleteNode.right;
                }
            }
            deleteNode.right = null;
            return;
        }

        //Case 4:delete node has both right and left child
        if (deleteNode.left == null && deleteNode.right == null) {
            Node rightOfDeleteNode;
            Node replaceNode;  //the right most node will replace deleteNode

            //find the right most node on the left sub-tree of deleteNode
            rightOfDeleteNode = deleteNode.right;
            replaceNode = deleteNode.left;
            while (replaceNode.right != null) {
                replaceNode = replaceNode.right;
            }
            replaceNode.right = rightOfDeleteNode;
            deleteNode.right = null;
            //now deleteNode has only left child
        }

        if (pOfDeleteNote == null) {
            root = deleteNode.left;
        } else {
            if (pOfDeleteNote.left == deleteNode) {
                pOfDeleteNote.left = deleteNode.left;
            } else {
                pOfDeleteNote.right = deleteNode.left;
            }
        }
        deleteNode.left = null;
        return;

    }
}
