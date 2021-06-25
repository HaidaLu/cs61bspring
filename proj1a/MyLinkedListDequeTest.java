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
        /*
        ad1.addFirst(1);
        ad1.addLast(2);
        ad1.addLast(3);
        ad1.addLast(4);
        ad1.addFirst(5);
        ad1.printDeque();
        System.out.println();
        System.out.println(ad1.get(3));

        System.out.println(ad1.removeFirst());
        ad1.printDeque();
        System.out.println();

        System.out.println(ad1.removeLast());
        ad1.printDeque();
        System.out.println();

        System.out.println(ad1.get(2));
        ad1.printDeque();
        System.out.println();*/
        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);
        ad1.addLast(4);
        ad1.addLast(5);
        ad1.addLast(6);
        ad1.addLast(7);
        ad1.addLast(8);
        ad1.printDeque();
        System.out.println();
        ad1.addLast(9);
        System.out.println(ad1.removeFirst());
        System.out.println(ad1.removeLast());
        System.out.println(ad1.removeLast());
        System.out.println(ad1.removeLast());
        System.out.println(ad1.removeLast());
        System.out.println(ad1.removeLast());
        System.out.println(ad1.removeLast());
        System.out.println(ad1.removeLast());
        System.out.println(ad1.removeLast());


        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);
        ad1.addLast(4);
        ad1.addLast(5);
        ad1.addLast(6);
        ad1.addLast(7);
        ad1.addLast(8);
        ad1.printDeque();
        System.out.println();
        //ad1.printDeque();
        ad1.addLast(1);
        ad1.printDeque();
        System.out.println();
        ad1.addLast(2);
        ad1.printDeque();
        System.out.println();
        ad1.addLast(3);
        ad1.printDeque();
        System.out.println();
        ad1.addLast(4);
        ad1.printDeque();
        System.out.println();
        ad1.addLast(5);
        ad1.printDeque();
        System.out.println();
        ad1.addLast(6);
        ad1.printDeque();
        System.out.println();
        ad1.addLast(7);
        ad1.printDeque();
        System.out.println();
        ad1.addLast(8);
        System.out.println(ad1.get(15));


        //System.out.println(ad1.size());
        ad1.printDeque();
        //System.out.println();

        //System.out.println(ad1.isEmpty());
        //ad1.printDeque();
        //System.out.println(ad1.get(0));




    }
}
