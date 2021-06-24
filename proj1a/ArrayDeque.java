public class ArrayDeque<T> {
    private int size;
    private T[] items;
    public ArrayDeque(){
        items =(T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T item){
        while(size>16 || usageFactor()<25){
            halfItemLength();
        }
        if (size == items.length){
            resize(size+1);
        }
        T[] a =(T[]) new Object[size+1];
        System.arraycopy(items,0,a,1,size);
        a[0] = item;
        size ++;
        System.arraycopy(a,0,items,0,size);


    }

    private void halfItemLength() {
        T[] a = (T[])new Object[items.length/2];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }

    private int usageFactor() {
        return (size * 100)/items.length;
    }

    private void resize(int capacity) {
        T[] a = (T[])new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }


    public void addLast(T item){
        while(size>16 || usageFactor()<25){
            halfItemLength();
        }
        if(size == items.length){
            resize(size+1);
        }
        items[size] = item;
        size++;

    }

    public boolean isEmpty(){
        return (this.size == 0);
    }

    public int size(){
        return this.size;
    }

    public void printDeque(){
        for (int i = 0; i<size;i++){
            System.out.print(items[i]+" ");
        }
    }

    public T removeFirst(){
        T firstItem = items[0];
        size --;
        T[] a =(T[])new Object[items.length-1];
        System.arraycopy(items,1,a,0,size-1);
        items = a;
        return firstItem;
    }

    public T removeLast(){
        T lastItem = items[size - 1];
        items[size-1] = null;
        size--;
        return lastItem;
    }

    public T get(int index){
        if(index > this.size){
            return null;
        }else{
            return items[size-1];
        }
    }
}
