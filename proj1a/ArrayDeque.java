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
        while (size > 16 && usageFactor() < 25) {
            halfItemLength();
        }
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
    }

    private void halfItemLength() {
        T[] a = (T[]) new Object[items.length / 2];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    private int usageFactor() {
        return (size * 100) / items.length;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, (nextLast - 1 + size) % size + 1);
        System.arraycopy(items, (nextFirst + 1) % size, a, (nextFirst + 1 + (capacity - size)) % size, size - (nextFirst + 1));
        items = a;
        nextFirst = nextFirst + (capacity - size);
        nextLast = (nextLast - 1 + size) % size + 1;
    }


    public void addLast(T item) {
        while (size > 16 && usageFactor() < 25) {
            halfItemLength();
        }
        if (size == items.length) {
            resize(size * 2);

        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size++;
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
