/*  其实proj1a非常简单，重点在resize这个方法上，并且proj并没有要求resize需要constant time(能否用constant time实现有待考虑)
*   最开始我没有看到可以不用constant time这个要求，挣扎了非常久，把扩容和缩容分成了两个方法，扩容思考了很久后倒能实现，nextLast定，分成两半，用System.arraycopy来扩。
*   但是缩容真的没想出合适的。
*   之后发现resize可以用循环一切就简化很多了，直接以和printDeque一样的方法把链表每个值赋给新的，我是相当于都用addLast，最后新的nextFirst = items.length -1 , nextLast = size;
*  */

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
