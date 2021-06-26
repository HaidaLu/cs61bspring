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
        // Add Last 0 1 2 3 4 5 6 7 8
        /*
        ad1.addLast(1);
        ad1.addLast(2);
        System.out.println(ad1.removeFirst());
        System.out.println(ad1.removeLast());
        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);
        ad1.addLast(4);
        ad1.addLast(5);
        ad1.addLast(6);
        ad1.addLast(7);
        ad1.addLast(8);
        ad1.addLast(9);
        ad1.printDeque();
        System.out.println();
        System.out.println(ad1.get(0));
        System.out.println(ad1.get(1));*/

        //Add First 0 1 2 3 4 5 6 7 8 9
        /*
        ad1.addFirst(0);
        ad1.printDeque();
        System.out.println();

        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addFirst(3);
        ad1.addFirst(4);
        ad1.addFirst(5);
        ad1.addFirst(6);
        ad1.addFirst(7);
        ad1.printDeque();
        System.out.println();

        ad1.addFirst(8);
        ad1.addFirst(9);
        ad1.printDeque();
        System.out.println();*/

        //add First then add Last
        /*
        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addFirst(3);
        ad1.addLast(4);
        ad1.addLast(5);
        ad1.addLast(6);
        ad1.addLast(7);
        ad1.addLast(8);
        ad1.addLast(9);
        ad1.printDeque();
        System.out.println();
         */

        //add - remove -isEmpty
        /*
        ad1.addFirst(1);
        System.out.println(ad1.removeLast());
        System.out.println(ad1.isEmpty());

        ad1.addLast(1);
        System.out.println(ad1.removeLast());
        System.out.println(ad1.isEmpty());


        ad1.addLast(1);
        System.out.println(ad1.removeFirst());
        System.out.println(ad1.isEmpty());

        ad1.addFirst(1);
        System.out.println(ad1.removeFirst());
        System.out.println(ad1.isEmpty());

         */
        /*
        ad1.addLast(1);
        System.out.println(ad1.removeFirst());
        System.out.println(ad1.isEmpty());
        */


        //at AGTestArrayDeque.test11:509 (AGTestArrayDeque.java)Making random calls to add/remove/get.
        ad1.addFirst(0);
        ad1.addLast(1);
        ad1.addFirst(2);
        ad1.removeLast() ;
        ad1.get(0) ;
        ad1.addFirst(5);
        ad1.get(1)     ;
        ad1.removeFirst()   ;
        ad1.addLast(8);
        ad1.addLast(9);
        ad1.removeLast()  ;
        ad1.removeLast()    ;
        ad1.get(0)   ;
        ad1.addFirst(13);
        ad1.addFirst(14);
        ad1.removeFirst()   ;
        ad1.removeLast()   ;
        ad1.get(0)     ;
        ad1.addFirst(18);
        ad1.printDeque();
        ad1.addLast(19);
        ad1.removeFirst() ;
        ad1.removeFirst()  ;
        ad1.removeFirst()  ;
        ad1.addLast(23);






    }
}
