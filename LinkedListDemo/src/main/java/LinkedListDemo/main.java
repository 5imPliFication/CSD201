package LinkedListDemo;


public class main {

    public static void main(String[] args) {
        MyList mylist=new MyList();
        System.out.println("List is empty: "+mylist.isEmpty());
        mylist.addFirst(12);
        mylist.traverse();
        
        int[] a={4,5,1,2};
        mylist.addManyLast(a);
        mylist.traverse();
        
        mylist.addFirst(69);
        mylist.addLast(11);
        mylist.traverse();
        
        Node f = mylist.getFirst();
        System.out.println(f.info);
        Node l = mylist.getLast();
        System.out.println(l.info);
        Node m=mylist.get(2);
        Node mprev=mylist.getPrev(m);
        Node mnext=mylist.getNext(m);
        
        System.out.println(mprev.info);
        System.out.println(mnext.info);
        mylist.traverse();
        
        mylist.removeFirst();
        mylist.removeLast();
        mylist.addFirst(5);
        mylist.insertBefore(m,2);
        mylist.remove(m);
        System.out.println(mylist.getByIndex(12));
        mylist.traverse();
        
        System.out.println(mylist.size());
        
        
    }
}
