public class MyLinkedListDequeTest {
    public static void main(String[] args) {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        //System.out.println(lld1.isEmpty());
        //lld1.addFirst(1);
        //lld1.addFirst(2);
        //System.out.println(lld1.get(4));
        //System.out.println(lld1.removeFirst());
        //System.out.println(lld1.size());

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        ad1.addLast(2);
        ad1.addLast(1);
        ad1.addFirst(3);
        ad1.addFirst(4);
        ad1.addFirst(4);
        ad1.addFirst(4);
        ad1.addFirst(4);
        ad1.addFirst(4);
        ad1.addFirst(4);
        ad1.printDeque();
        System.out.println();
        System.out.println(ad1.isEmpty());

        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        System.out.println(ad1.isEmpty());

        




    }
}
