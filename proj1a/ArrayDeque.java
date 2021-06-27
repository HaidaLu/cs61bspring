/*
* */

public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextLast = 0;
        nextFirst = items.length - 1;
    }

    public void addFirst(T item) {
        if(size == 0){
            nextLast = 0;
            nextFirst = items.length - 1;
        }
        if (items.length > 16 && usageFactor() < 25) {
            resize( items.length / 2);
        }
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
    }

    public void addLast(T item) {
        if(size == 0){
            nextLast = 0;
            nextFirst = items.length - 1;
        }
        if (size > 16 && usageFactor() < 25) {
            resize(items.length / 2);
        }
        if (size == items.length) {
            resize(size * 2);

        }
        if (size < items.length && nextLast == items.length ) {
            nextLast = nextLast % items.length;
        }
        items[nextLast] = item;
        nextLast++;

        size++;
    }


    private int usageFactor() {
        return (size * 100) / items.length;
    }
    /*add and remove must take constant time, except during resizing operations.
        resize method accepts loop. so I create a brand new array and new pointer.
    * */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i<size; i++){
            a[i] = items[(nextFirst + 1 + i) % items.length];
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }


    public boolean isEmpty() {
        return (this.size == 0);
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        for (int i = 1; i<=size; i++){
            System.out.print(items[(nextFirst + i ) % items.length] + " ");
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (items.length > 16 && usageFactor() < 25) {
            resize( items.length / 2);
        }
        T firstItem = items[(nextFirst + 1) % items.length];
        items[(nextFirst + 1) % items.length] = null;
        nextFirst = (nextFirst + 1) % items.length;
        size--;
        return firstItem;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (items.length > 16 && usageFactor() < 25) {
            resize( items.length / 2);
        }
        T lastItem = items[(nextLast - 1 + items.length) % items.length];
        items[(nextLast - 1 + items.length) % items.length] = null;
        nextLast = (nextLast - 1 + items.length) % items.length;
        size--;
        return lastItem;
    }

    public T get(int index){
        if(index > this.size){
            return null;
        }else{
            return items[(nextFirst+1+index) % items.length];
        }
    }
}
