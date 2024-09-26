package LinkedListDemo;


public class MyList {

    Node head;
    Node tail;

    public MyList() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = null;
        tail = null;
    }

    void removeFirst() {
        if (tail == head) {
            clear();
        } else {
            Node p = head;
            head = head.next;
            p.next = null;
        }
    }

    void removeLast() {
        if (tail == head) {
            clear();
        } else {
            Node p = head;
            while (p.next != tail) {
                p = p.next;
            }
            tail = p;
            p.next = null;

        }
    }

    void addFirst(int x) {
        if (isEmpty()) {
            Node p = new Node(x);
            head = p;
            tail = p;
        } else {
            Node p = new Node(x);
            p.next = head;
            head = p;
        }
    }

    void addLast(int x) {
        if (isEmpty()) {
            Node p = new Node(x);
            head = p;
            tail = p;
        } else {
            Node p = new Node(x);
            tail.next = p;
            tail = p;
        }
    }

    void addManyLast(int[] a) {
        for (int i = 0; i < a.length; i++) {
            addLast(a[i]);
        }
    }

    void visit(Node p) {
        System.out.print(p.info + " ");
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

//Q2.1
    Node getFirst() {
        if (isEmpty()) {
            return null;
        } else {
            return head;
        }
    }

    Node getLast() {
        if (isEmpty()) {
            return null;
        } else {
            return tail;
        }
    }

    Node get(int x) {
        Node p = head;
        while (p != null) {
            if (p.info == x) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    Node find(Node p) {
        Node q = head;
        while (p != q) {
            if (q == p) {
                get(p.info);
            }
            q = q.next;
        }
        return null;
    }

    Node getNext(Node p) {
        if (p != null) {
            return p.next;
        }
        return null;

    }

    Node getPrev(Node p) {
        if (p == head) {
            return null;
        }
        Node q = head;
        while (p != null && q.next != p) {
            q = q.next;
        }
        return q;
    }

    //Q2.2
    int size() {
        Node temp = head;
        int count = 0;
        while (temp != null) {

            count++;
            temp = temp.next;
        }
        return count;
    }

    Node getByIndex(int index) {
        Node p = head;
        int idx = 0;
        while (p != null) {
            p = p.next;
            if (idx == index) {
                return null;
            }
            idx++;
        }
        return null;
    }

    void insertAfter(Node p, int x) {
        Node q = getByIndex(x);
        if (q != null) {
            p.next = q.next;
            if (q != tail) {
                q.next = p;
            } else {
                addLast(p.info);
            }
        }
    }

    void insertBefore(Node p, int x) {
        Node n = getByIndex(x);
        if (n != null) {
            p.next = n;
            if (getPrev(n) != null) {
                getPrev(n).next = p;
            } else {
                addFirst(p.info);
            }
        }
    }

    void insert(int index, int x) {
        Node n = getByIndex(index);
        if (n != null) {
            n.info = x;
        }
    }

    //Q2.3
    
    void remove(Node p) {
        
    }
}
