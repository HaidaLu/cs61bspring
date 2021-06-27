/*难点在resize 一个扩容一个缩容，两个指针应该怎么变化
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
        //System.out.println(items.length);
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
        //System.out.println("next" + nextFirst);
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

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i<size; i++){
            a[i] = items[(nextFirst + 1 + i) % items.length];
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
        /*
        System.arraycopy(items, 0, a, 0, nextLast);
        int restFirst = size - nextLast;
        System.arraycopy(items, nextLast, a, nextLast + (capacity - size) , restFirst);
        items = a;
        nextFirst = nextLast + (capacity - size - 1);
        System.out.println(items.length);*/

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

    /*
    private void halfItemLength() {
        T[] a = (T[]) new Object[items.length / 2];
        int newLength = items.length / 2;
        int newFirst = (nextFirst - items.length) % newLength + newLength;
        int newLast = (nextLast - items.length) % newLength + newLength;
        if (nextFirst<newLast){
            System.arraycopy(items,nextFirst,a,newFirst,size);
        }else{
            System.arraycopy(items,0,a,0,nextLast);
            System.arraycopy(items,(nextFirst+1) % items.length, a,(newFirst+1) % newLength, size-nextLast);
        }
        //System.arraycopy(items,0, a, 0, );
        //System.arraycopy(items, 0, a, 0, size);


        items = a;
        nextLast = newLast;
        nextFirst = newFirst;
    }*/
}
