/*
* operations are subject to the following rules:

    - add and remove operations must not involve any looping or recursion.
        * A single such operation must take “constant time”,
        * i.e. execution time should not depend on the size of the deque.
    - get must use iteration, not recursion.
    - size must take constant time.
    - The amount of memory that your program uses at any given time must be proportional to the number of items.
        * For example, if you add 10,000 items to the deque, and then remove 9,999 items,
        * the resulting size should be more like a deque with 1 item than 10,000.
        * Do not maintain references to items that are no longer in the deque.
*
* */



public class LinkedListDeque<T> {

    public class DequeNode{

        public DequeNode prev;
        public T item;
        public DequeNode next;

        public DequeNode(DequeNode m, T x, DequeNode n){
            prev = m;
            item = x;
            next = n;
        }
    }

    private DequeNode sentinel;
    private int size;

    /*Constructor with no nodes*/
    public LinkedListDeque(){
        //sentinel = new DequeNode(sentinel, null, sentinel);
        sentinel = new DequeNode(null,null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /* Constructor with one node*/
    public LinkedListDeque(T x){
        size = 1;

        sentinel = new DequeNode(null, null, null);
        sentinel.next = new DequeNode(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;


    }


    /*Adds an item of type T to the front of the deque*/
    public void addFirst(T item){
        sentinel.next = new DequeNode(sentinel,item,sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        //DequeNode newNode = new DequeNode(sentinel, item, sentinel.next);
        //sentinel.next.prev = newNode;
        //sentinel.next = newNode;
        //sentinel.next = newNode;
        //sentinel.next.next.prev = newNode;
        size ++;
    }
    /*Adds an item of type T to the back of the deque*/
    public void addLast(T item){
        sentinel.prev = new DequeNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        //DequeNode newNode = new DequeNode(sentinel.prev, item, sentinel);
        //sentinel.prev.next = newNode;
        //sentinel.prev = newNode;
        size++;
    }

    /*Returns true if deque is empty*/
    public boolean isEmpty(){

        return (sentinel.next == sentinel);
    }

    /*Returns the number of items in the deque*/
    public int size(){
        return size;
    }

    /*Prints the items in the deque from first to last, seperated by a space*/
    public void printDeque(){
        DequeNode p = sentinel.next;
        while(p != sentinel){
            System.out.print(p.item+" ");
            p = p.next;
        }
        //System.out.print(p.item);

    }

    /*Removes and returns the item at the front of the deque. If no such item exists, returns null*/
    public T removeFirst(){
        if (sentinel.next == sentinel) {
            return null;
        }
        T removeItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        return removeItem;
    }

    /*Removes and returns the item at the back of the deque
    * If no such item exists, returns null*/
    public T removeLast(){
        if(sentinel.prev == sentinel){
            return null;
        }
        T removeItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        return removeItem;
    }

    /*Gets the item at the given index, where o is the front, 1is the next item, and so forth.
    * If no such item exists, returns null.
    * Must not alter the deque!*/
    public T get(int index){
        DequeNode p = sentinel.next;
        if(sentinel.prev == sentinel){
            return null;
        }
        while(index != 1 ){
            p = p.next;
        }
        return p.item;


    }


    public T getRecursive(int index){
        if(index > size){
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, DequeNode first) {
        if(index == 0){
            return first.item;
        }else{
            T getItem = getRecursiveHelper(index-1,first.next);

            return getItem;
        }
    }




}


/*In addition, you also need to implement:

public LinkedListDeque(): Creates an empty linked list deque.
public T getRecursive(int index): Same as get, but uses recursion.
You may add any private helper classes or methods in LinkedListDeque.java if you deem it necessary.*/