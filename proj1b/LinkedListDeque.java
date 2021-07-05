public class LinkedListDeque<T> implements Deque<T> {

    private class DequeNode {

        private DequeNode prev;
        private T item;
        private DequeNode next;

        DequeNode(DequeNode m, T x, DequeNode n) {
            prev = m;
            item = x;
            next = n;
        }
    }

    private DequeNode sentinel;
    private int size;

    /*Constructor with no nodes*/
    public LinkedListDeque() {
        //sentinel = new DequeNode(sentinel, null, sentinel);
        sentinel = new DequeNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /* Constructor with one node
    public LinkedListDeque(T x){
        size = 1;

        sentinel = new DequeNode(null, null, null);
        sentinel.next = new DequeNode(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;


    }*/

    @Override
    /*Adds an item of type T to the front of the deque*/
    public void addFirst(T item) {
        size++;
        //sentinel.next = new DequeNode(sentinel,item,sentinel.next);
        //sentinel.next.next.prev = sentinel.next;
        DequeNode newNode = new DequeNode(sentinel, item, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
    }
    @Override
    /*Adds an item of type T to the back of the deque*/
    public void addLast(T item) {
        //sentinel.prev = new DequeNode(sentinel.prev, item, sentinel);
        //sentinel.prev.prev.next = sentinel.prev;
        DequeNode newNode = new DequeNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    @Override
    /*Returns true if deque is empty*/
    public boolean isEmpty() {

        return (sentinel.next == sentinel);
    }

    @Override
    /*Returns the number of items in the deque*/
    public int size() {
        return size;
    }

    @Override
    /*Prints the items in the deque from first to last, seperated by a space*/
    public void printDeque() {
        DequeNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        //System.out.print(p.item);

    }

    @Override
    /*Removes and returns the item at the front of the deque. If no such item exists, returns null*/
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        } else {
            T removeItem = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size--;
            return removeItem;
        }
    }

    @Override
    /*Removes and returns the item at the back of the deque
    * If no such item exists, returns null*/
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        } else {
            T removeItem = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size--;
            return removeItem;
        }
    }

    @Override
    /*Gets the item at the given index, where o is the front, 1is the next item, and so forth.
    * If no such item exists, returns null.
    * Must not alter the deque!*/
    public T get(int index) {
        DequeNode p = sentinel.next;
        if (sentinel.prev == sentinel || index > size) {
            return null;
        }
        while (index != 0) {
            p = p.next;
            index--;
        }
        return p.item;


    }


    public T getRecursive(int index) {
        if (index > size) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, DequeNode first) {
        if (index == 0) {
            return first.item;
        } else {
            T getItem = getRecursiveHelper(index - 1, first.next);

            return getItem;
        }
    }




}


