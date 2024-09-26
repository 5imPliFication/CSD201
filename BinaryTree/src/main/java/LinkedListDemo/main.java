package LinkedListDemo;

public class main {

    public static void main(String[] args) {
        MyBSTree bstree = new MyBSTree();
        //insert
        bstree.insert(10);
        bstree.insert(6);
        bstree.insert(15);
        int[] a = {4, 8, 12, 19, 2, 5, 7, 9, 11, 14, 17, 20, 1, 3, 13, 16, 18, 21, 0, 22};
        bstree.insertMany(a);
        System.out.println();
        //order
        System.out.println("Pre-order (NLR) tree");
        bstree.preOrder(bstree.root);
        System.out.println();
        System.out.println("In-order (LNR) tree");
        bstree.inOrder(bstree.root);
        System.out.println();
        System.out.println("Post-order (LRN) tree");
        bstree.postOrder(bstree.root);
        System.out.println();
        //delete
        System.out.println("Delete by merging: leaf node 3");
        bstree.deleteByMerging(3);
        bstree.breadthFirst();
        System.out.println();
        System.out.println("Delete by merging: leaf node 7");
        bstree.deleteByMerging(7);
        bstree.breadthFirst();
        System.out.println();
        System.out.println("Delete by merging: node has only one left child 2");
        bstree.deleteByMerging(2);
        bstree.breadthFirst();
        System.out.println();
        System.out.println("Delete by merging: node has only one right child 20");
        bstree.deleteByMerging(20);
        bstree.breadthFirst();
        System.out.println();
        System.out.println("Delete by merging: node has only one right child 15");
        bstree.deleteByMerging(15);
        bstree.breadthFirst();
        System.out.println();
        System.out.println("Delete by merging: node has only one right child 10");
        bstree.deleteByMerging(10);
        bstree.breadthFirst();
        System.out.println();
        System.out.println("Delete by merging: node has only one right child 4");
        bstree.deleteByMerging(4);
        bstree.breadthFirst();
        System.out.println();
    }
}
